package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import test.dao.DeptMapper;
import test.modal.Dept;
import test.modal.Emp;
import test.modal.Record;
import test.util.MyBatisUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 单元测试类
 * */
public class DeptMapperTest {

    private SqlSession session;
    private DeptMapper deptMapper;

    /**
     * 执行单元测试之前加载的方法
     */
    @Before
    public void before() {
        session = MyBatisUtil.getSession();
        deptMapper = session.getMapper(DeptMapper.class);
    }

    @Test
    public void findAllTest() {
        try {
            DeptMapper mapper = session.getMapper(DeptMapper.class);
            List<Dept> list = mapper.findAll();
            System.out.println("DeptMapperTest.findAllTest:"+list);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSession(session);
        }
    }

    /**
     * findById测试
     */
    @Test
    public void findByIdTest() {
        Emp emp = deptMapper.findEmpById(1011);
        if(emp != null) {
            Dept dept = emp.getDept();
            System.out.println("DeptMapperTest.findByIdTest:"+dept);
        }
        session.close();
    }

    /**
     * findById1测试
     */
    @Test
    public void findById1Test() {
        Emp emp = deptMapper.findEmpById1(1011);
        System.out.println("DeptMapperTest.findById1Test:"+emp);
        session.close();
    }

    /**
     * findDeptById测试
     */
    @Test
    public void findDeptByIdTest() {
        Dept dept = deptMapper.findDeptById(1);
        System.out.println("DeptMapperTest.findDeotByIdTest:"+dept);
        session.close();
    }

    /**
     * findDeptById1测试
     */
    @Test
    public void findDeptById1Test() {
        Dept dept = deptMapper.findDeptById1(1);
        System.out.println("DeptMapperTest.findDeotByIdTest1:"+dept);
        session.close();
    }

    @Test
    public void getAllRecordTest() {
        Map<String, Record>  resultMap = new LinkedHashMap<>();
        List<Map<String, Object>> allRecord = deptMapper.getAllRecord();
//        List<Map<String, Object>> maps = allRecord.stream().map(e -> {
//            String code = e.get("CODE") + "";
//            Map<String, String> map = new HashMap<>();
//            map.put("date", e.get("MONTH") + "");
//            map.put("level", e.get("LEVEL") + "");
//            if (resultMap.get(code) != null) {
//                resultMap.get(code).getRecords().add(map);
//            } else {
//                List<Map<String, String>> list = new LinkedList<>();
//                list.add(map);
//                Record r = new Record(code,e.get("NAME")+"",list);
//                resultMap.put(code,r);
//            }
//            return e;
//        }).collect(Collectors.toList());
        List<Record> recordList = resultMap.entrySet().stream().map(e -> {
            return e.getValue();
        }).collect(Collectors.toList());
        recordList.stream().forEach(System.out::println);
    }

    @Test
    public void getAllRecordTest1() {
        List<Record> allRecord1 = deptMapper.getAllRecord1();
        allRecord1.stream().forEach(System.out::println);
    }
}
