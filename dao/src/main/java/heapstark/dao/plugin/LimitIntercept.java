package heapstark.dao.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Properties;

/**
 * springBoot
 * Created by wangzhilei3 on 2018/1/24.
 */
@Intercepts(@Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class,Integer.class}))
public class LimitIntercept implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
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
        sql = "select * from(" + sql + ") LIMIT_NAME" + " limit " + 5;
        metaStmt.setValue("delegate.boundSql.sql", sql);

        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {

    }
}
