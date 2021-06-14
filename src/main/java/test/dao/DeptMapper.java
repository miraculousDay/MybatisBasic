package test.dao;

import test.modal.Dept;
import test.modal.Emp;
import test.modal.Record;

import java.util.List;
import java.util.Map;

public interface DeptMapper {
    List<Dept> findAll();

    /**
     * 一对一嵌套查询，在获取查询结果后访问dept属性获取部门部门信息，需要执行两次sql
     * @param empno
     * @return
     */
    Emp findEmpById(int empno);

    /**
     * 一对一嵌套查询，给association中配置对应属性名称sql,只需执行一次sql
     * @param empno
     * @return
     */
    Emp findEmpById1(int empno);

    /**
     * 一对多查询，通过部门编号获取部门所有人员
     * @param deptno
     * @return
     */
    Dept findDeptById(int deptno);

    /**
     * 一对多查询，通过部门编号获取部门所有人员1
     * @param deptno
     * @return
     */
    Dept findDeptById1(int deptno);

    List<Map<String, Object>> getAllRecord();

    List<Record> getAllRecord1();
}
