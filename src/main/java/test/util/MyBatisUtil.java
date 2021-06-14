package test.util;

import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 连接数据库工具类
 * */
public class MyBatisUtil {
    private static SqlSessionFactory sf;

    /**
     * 初始化获取mybatis配置文件
     * */
    static {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        sf = builder.build(TestCase.class.getClassLoader().getResourceAsStream("mybatis-config.xml"));
    }

    /**
     * 获取SqlSession
     * */
    public static SqlSession getSession() {
        return sf.openSession();
    }

    /**
     * 关闭SqlSession
     * */
    public static void closeSession(SqlSession sqlSession) {
        if(sqlSession != null) {
            sqlSession.close();
        }
    }

    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisUtil.getSession();
        System.out.println(sqlSession);
        MyBatisUtil.closeSession(sqlSession);
    }
}
