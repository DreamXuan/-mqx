package com.exam.pojo;

public class Studentpaper {
    private Integer id;

    private String spid;

    private Integer userid;

    private Integer sid;

    private String studentkey;

    private Integer studentstate;

    private String pname;

    private Integer rightcount;

    private Integer errorcount;

    public Integer getRightcount() {
        return rightcount;
    }

    public void setRightcount(Integer rightcount) {
        this.rightcount = rightcount;
    }

    public Integer getErrorcount() {
        return errorcount;
    }

    public void setErrorcount(Integer errorcount) {
        this.errorcount = errorcount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid == null ? null : spid.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getStudentkey() {
        return studentkey;
    }

    public void setStudentkey(String studentkey) {
        this.studentkey = studentkey == null ? null : studentkey.trim();
    }

    public Integer getStudentstate() {
        return studentstate;
    }

    public void setStudentstate(Integer studentstate) {
        this.studentstate = studentstate;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }
}