package test.modal;

import java.util.List;

/**
 * @author : tanyu
 * create at:  2021-01-06  21:56
 * @description:
 */
public class Record {

    private String code;
    private String name;
    private List<RecordVo> records;

    public Record(String code, String name, List<RecordVo> records) {
        this.code = code;
        this.name = name;
        this.records = records;
    }

    public Record() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RecordVo> getRecords() {
        return records;
    }

    public void setRecords(List<RecordVo> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "Record{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", records=" + records +
                '}';
    }
}