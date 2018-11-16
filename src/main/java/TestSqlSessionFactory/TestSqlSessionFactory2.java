package TestSqlSessionFactory;

import Model.Man;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class TestSqlSessionFactory2 {

    public static void main(String[] args) {

        // 数据库连接池信息

        PooledDataSource dataSource = new PooledDataSource();

        //数据库连接信息
        String driver = "oracle.jdbc.Driver.OracleDriver";
        String url = "jdbc:oracle:thin:localhost:1521:orcl";
        String username = "SCOTT";
        String password = "12345678";

        dataSource.setDriver(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        dataSource.setDefaultAutoCommit(false);

        //采用 JDBC 事务管理

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development",transactionFactory,dataSource);

        //创建Configuration 对象
        Configuration configuration = new Configuration(environment);

        //注册一个上下文别名

        configuration.getTypeAliasRegistry().registerAlias("man", Man.class);

        //加入一个映射器
        configuration.addMapper(Man.class);

        //创建 SqlSession工厂的对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        //创建 SqlSession对象
        SqlSession sqlSession = null;
        try {
             sqlSession = sqlSessionFactory.openSession();

            /**
             *  Some Code
             */

            //提交事务
            sqlSession.commit();
        } catch (Exception e) {

            //事务回滚
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }


    }

}
