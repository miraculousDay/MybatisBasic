package tk.mybatis.simple.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import test.dao.CountryMapper;
import test.modal.Country;
import test.util.MyBatisUtil;

import java.io.Reader;

public class CountryMapperTest {
    private static SqlSessionFactory sqlSessionFactory;


    private SqlSession session;
    private CountryMapper countrymapper;

    /**
     * 执行单元测试之前加载的方法
     */
    @Before
    public void before() {
        session = MyBatisUtil.getSession();
        countrymapper = session.getMapper(CountryMapper.class);
    }

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
    public void insertCountry() {
        Country country = new Country();
        country.setCountrycode("JAN");
        country.setCountryname("日本");
        countrymapper.insert(country);
        session.commit();
    }
}
