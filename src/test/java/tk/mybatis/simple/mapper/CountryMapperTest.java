package tk.mybatis.simple.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import tk.mybatis.simple.model.Country;

import java.io.Reader;
import java.util.List;

public class CountryMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void initFun() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();;
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Country> list = sqlSession.selectList("selectAll");
        if (list != null && list.size() > 0) {
            System.out.println("list.size():"+list.size());
        }
    }
}
