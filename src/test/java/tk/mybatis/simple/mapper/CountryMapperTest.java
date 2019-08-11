package tk.mybatis.simple.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import test.dao.CountryMapper;
import test.modal.Country;

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

    //TODO  单元测试成功，数据无法入库
    @Test
    public void insertCountry() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CountryMapper mapper = (CountryMapper)sqlSession.getMapper(CountryMapper.class);
        Country country = new Country();
        country.setCountrycode("JAN");
        country.setCountryname("日本");
        mapper.insert(country);
    }
}
