package heapstark.dao.plugin;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.DefaultResultSetHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * springBoot
 * Created by wangzhilei3 on 2018/1/20.
 */
@Intercepts(@Signature(method = "handleResultSets", type = ResultSetHandler.class, args = {Statement.class}))
public class MapIntercept implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        if (target instanceof DefaultResultSetHandler) {
            Statement stmt = (Statement) invocation.getArgs()[0];
            // 根据maoParam返回处理结果
            return handleResultSet(stmt.getResultSet());
        }
        return invocation.proceed();

    }

    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    public void setProperties(Properties properties) {

    }

    private ParameterHandler reflect(DefaultResultSetHandler resultSetHandler) {
        Field field = ReflectionUtils.findField(DefaultResultSetHandler.class, "parameterHandler");
        field.setAccessible(true);
        Object value = null;
        try {
            value = field.get(resultSetHandler);
        } catch (Exception e) {
        }
        return (ParameterHandler) value;
    }

    private Object handleResultSet(ResultSet resultSet) {
        if (null != resultSet) {
            String keyFieldName = "propkey";
            String valueFieldName = "propvalue";

            Map<String, String> resultMap = new HashMap<String, String>();
            try {
                while (resultSet.next()) {
                    String key = (String) resultSet.getObject(keyFieldName);
                    String value = (String) resultSet.getObject(valueFieldName);
                    resultMap.put(key, value);
                }
            } catch (SQLException e) {
            } finally {
                closeResultSet(resultSet);
            }
            return Arrays.asList(resultMap);
        }
        return null;
    }

    private void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
        }
    }


}
