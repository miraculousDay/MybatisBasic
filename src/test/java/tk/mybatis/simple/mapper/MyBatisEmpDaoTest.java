package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import test.dao.EmpMapper;
import test.modal.Emp;
import test.util.MyBatisUtil;

import java.util.*;

/**
 * 单元测试类
 */
public class MyBatisEmpDaoTest {

    private SqlSession session;
    private EmpMapper empMapper;

    /**
     * 执行单元测试之前加载的方法
     */
    @Before
    public void before() {
        session = MyBatisUtil.getSession();
        empMapper = session.getMapper(EmpMapper.class);
    }

    /**
     * 测试连接
     */
    @Test
    public void createConTest() {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(MyBatisEmpDaoTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println(sqlSession);
        sqlSession.close();
    }


    /**
     * EmpMapper测试
     */
    @Test
    public void findByIdTest1() {
        try {
            Emp emp = empMapper.findById(1011);
            System.out.println("TestCase.findByIdTest1:" + emp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 动态插入sql测试
     */
    @Test
    public void dynamicInsertTest() {
        try {
            Emp emp = new Emp();
            emp.setEmpno(1014);
            emp.setEname("赵武4");
            emp.setJob("运维");
            //emp.setMgr(101);
            emp.setHiredate(new Date());
            emp.setSal(5465.0);
            emp.setComm(100.0);
            emp.setDeptno(1);
            empMapper.dynamicInsert(emp);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 批量插入sql1测试
     * 批量插入要考虑效率问题，主要一次插入1000左右(视服务器情况可调整)
     */
    @Test
    public void batchInsert1Test() {
        try {
            ;
            Integer empno = 1015;
            List<Emp> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                Emp emp = new Emp();
                emp.setEmpno(empno + i);
                emp.setEname("赵武" + i);
                emp.setJob("运维");
                emp.setMgr(101);
                emp.setHiredate(new Date());
                emp.setSal(5465.0);
                emp.setComm(100.0);
                emp.setDeptno(1);
                list.add(emp);
            }
            int batchInsert1 = empMapper.batchInsert1(list);
            System.out.printf("batchInsert1:" + batchInsert1);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 批量插入sql2测试
     */
    @Test
    public void batchInsert2Test() {
        try {
            Integer empno = 1019;
            List<Emp> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                Emp emp = new Emp();
                emp.setEmpno(empno + i);
                emp.setEname("赵武" + i);
                emp.setJob("运维");
                emp.setMgr(101);
                emp.setHiredate(new Date());
                emp.setSal(5465.0);
                emp.setComm(100.0);
                emp.setDeptno(1);
                list.add(emp);
            }
            int batchInsert2 = empMapper.batchInsert2(list);
            System.out.printf("batchInsert2:" + batchInsert2);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 动态更新sql1测试
     */
    @Test
    public void dynamicUpdate1Test() {
        Emp emp = new Emp();
        emp.setEmpno(1011);
        emp.setEname("名称");
        emp.setDeptno(1);
        empMapper.dynamicUpdate1(emp);
        session.commit();
        session.close();
    }

    /**
     * 动态更新sql2测试
     */
    @Test
    public void dynamicUpdate2Test() {
        Emp emp = new Emp();
        emp.setEmpno(1011);
        emp.setEname("名称1");
        emp.setDeptno(1);
        empMapper.dynamicUpdate2(emp);
        session.commit();
        session.close();
    }

    /**
     * 批量更新sql测试
     */
    @Test
    public void batchUpdateTest() {
        List<Emp> all = empMapper.findAll();
        all.stream().forEach(e -> {
            e.setEname(e.getEname() + "321");
            e.setJob(e.getJob() + "321");
            e.setSal(20000d);
        });
//        all.stream().forEach(System.out::println);
        System.out.println(empMapper.batchUpdate2(all));
        session.commit();
        session.close();
    }
}
