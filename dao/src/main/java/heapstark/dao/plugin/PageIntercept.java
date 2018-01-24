package heapstark.dao.plugin;

import heapstark.domain.vo.PageParams;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * springBoot
 * Created by wangzhilei3 on 2018/1/24.
 */
@Intercepts(@Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class, Integer.class}))
public class PageIntercept implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {

        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();

        MetaObject metaStmt = SystemMetaObject.forObject(statementHandler);
        while (metaStmt.hasGetter("h")) {
            Object object = metaStmt.getValue("h");
            metaStmt = SystemMetaObject.forObject(object);
        }
        while (metaStmt.hasGetter("target")) {
            Object object = metaStmt.getValue("target");
            metaStmt = SystemMetaObject.forObject(object);
        }

        String sql = (String) metaStmt.getValue("delegate.boundSql.sql");
        if (!checkSelect(sql)) {
            return invocation.proceed();
        }
        BoundSql boundSql = (BoundSql) metaStmt.getValue("delegate.boundSql");
        Object paramObject = boundSql.getParameterObject();
        PageParams pageParams = getPageParams(paramObject);

        if (pageParams == null) {
            return invocation.proceed();
        }
        pageParams.setTotal(getTotal(invocation, metaStmt, boundSql));

        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {

    }

    /**
     * @param invocation
     * @return
     */
    private StatementHandler getUnProxyObject(Invocation invocation) {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStmt = SystemMetaObject.forObject(statementHandler);
        Object object = null;
        while (metaStmt.hasGetter("h")) {
            object = metaStmt.getValue("h");
            metaStmt = SystemMetaObject.forObject(object);
        }
        if (object == null) {
            return statementHandler;
        }
        return (StatementHandler) object;
    }

    /**
     * @param sql
     * @return
     */
    private boolean checkSelect(String sql) {
        return sql.trim().toLowerCase().indexOf("select") == 0;

    }

    private PageParams getPageParams(Object paramObject) {
        if (paramObject == null) {
            return null;
        }
        if (!(paramObject instanceof PageParams)) {
            return null;
        }

        return (PageParams) paramObject;

    }

    private int getTotal(Invocation invocation, MetaObject metaState, BoundSql boundSql) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) metaState.getValue("delegate.mappedStatement");
        org.apache.ibatis.session.Configuration configuration = mappedStatement.getConfiguration();
        String sql = (String) metaState.getValue("delegate.boundSql.sql");

        String countSql = "select count(*) from (" + sql + ") LIMIT_NAME";
        PreparedStatement preparedStatement = null;
        Connection connection = (Connection) invocation.getArgs()[0];
        int a =0;
        try {
            preparedStatement = connection.prepareStatement(countSql);
            //BoundSql countBoundSql = new BoundSql(configuration,countSql,boundSql,)

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 a = resultSet.getInt(1);
                return a;
            }
        } catch (SQLException e) {
                e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            return a;
        }
    }
}
