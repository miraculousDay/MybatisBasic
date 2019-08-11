package tk.mybatis.simple.model;

import java.io.Serializable;

public class Country implements Serializable {
    private String id;
    private String countryCode;
    private String countryName;

    public String getId() {
        return id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }
}
