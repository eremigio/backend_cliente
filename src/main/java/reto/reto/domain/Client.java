package reto.reto.domain;

import java.util.Date;

public class Client {
    private Integer id;
    private String name;
    private String lastname;
    private String datebirthday;
    private Date datedeath;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lasname) {
        this.lastname = lasname;
    }

    public String getDatebirthday() {
        return datebirthday;
    }

    public void setDatebirthday(String datebirthday) {
        this.datebirthday = datebirthday;
    }

    public Date getDatedeath() {
        return datedeath;
    }

    public void setDatedeath(Date datedeath) {
        this.datedeath = datedeath;
    }
}
