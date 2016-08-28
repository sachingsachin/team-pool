package com.prismoskills.persistence;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity (name="Users")
@AttributeOverride( name="id", column = @Column(name="user_id"))
public class UserEntity extends BaseEntity {

    String fname;
    String lname;
    String id1;
    String id2;
    String id3;
    String id4;

    @Column(name="reports_to")
    String reportsTo;

    String status;

    // Constructors
    public UserEntity() {
    }

    public UserEntity(String fname, String lname,
            String id1, String id2, String id3, String id4,
            String reportsTo, String status) {
        super();
        this.fname = fname;
        this.lname = lname;
        this.id1 = id1;
        this.id2 = id2;
        this.id3 = id3;
        this.id4 = id4;
        this.reportsTo = reportsTo;
        this.status = status;
    }

    // Getter setters
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getId1() {
        return id1;
    }
    public void setId1(String id1) {
        this.id1 = id1;
    }
    public String getId2() {
        return id2;
    }
    public void setId2(String id2) {
        this.id2 = id2;
    }
    public String getId3() {
        return id3;
    }
    public void setId3(String id3) {
        this.id3 = id3;
    }
    public String getId4() {
        return id4;
    }
    public void setId4(String id4) {
        this.id4 = id4;
    }
    public String getReportsTo() {
        return reportsTo;
    }
    public void setReportsTo(String reports_to) {
        this.reportsTo = reports_to;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
