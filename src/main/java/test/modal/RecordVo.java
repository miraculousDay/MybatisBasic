package test.modal;

/**
 * @author : tanyu
 * create at:  2021-01-11  23:44
 * @description:
 */
public class RecordVo {
    private String date;
    private String level;

    public RecordVo(String date, String level) {
        this.date = date;
        this.level = level;
    }

    public RecordVo() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}