package test.modal;

import java.io.Serializable;
import java.util.List;

public class Dept implements Serializable {
    private Integer id;
    private String name;
    private String loc;
    private List<Emp> empList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }


    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", loc='" + loc + '\'' +
                ", empList=" + empList +
                '}';
    }
}
