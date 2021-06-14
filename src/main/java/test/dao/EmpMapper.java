package test.dao;

import test.modal.Emp;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
    List<Emp> findAll();

    Emp findById(int id);

    void save(Emp e);

    void update(Emp e);

    void delete(int id);

    List<Map<String, Object>> findByDeptNo(int deptno);

    void dynamicInsert(Emp e);


    /**
     * 批量插入sql1
     * @param list
     * @return
     */
    int batchInsert1(List<Emp> list);


    /**
     * 批量插入sql2
     * @param list
     * @return
     */
    int batchInsert2(List<Emp> list);

    /**
     * 动态更新sql1
     * @param emp
     * @return
     */
    int dynamicUpdate1(Emp emp);

    /**
     * 动态更新sql2
     * @param emp
     * @return
     */
    int dynamicUpdate2(Emp emp);

    /**
     * 批量更新
     * @param map
     * @return
     */
    int batchUpdate(Map map);

    /**
     * 批量更新1
     * 使用case when 进行判断更新，当数据量过大时候的会产生长度极长的sql
     * @param list
     * @return
     */
    int batchUpdate1(List<Emp> list);

    /**
     * oracle begin end 批量更新
     * mysql 使用批量SQL执语句
     * 以这种方式执行的话，不容易看出那条sql执行出错
     * @param list
     * @return
     */
    int batchUpdate2(List<Emp> list);
}
