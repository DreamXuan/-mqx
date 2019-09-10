package com.exam.pojo;

public class Subject {
    private Integer sid;

    private String scontent;

    private String sa;

    private String sb;

    private String sc;

    private String sd;

    private String skey;

    private Integer sstate;

    private String studentkey;

    private String spid;

    private Integer randomid;

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }


    public String getStudentkey() {
        return studentkey;
    }

    public void setStudentkey(String studentkey) {
        this.studentkey = studentkey;
    }

    public Integer getRandomid() {
        return randomid;
    }

    public void setRandomid(Integer randomid) {
        this.randomid = randomid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getScontent() {
        return scontent;
    }

    public void setScontent(String scontent) {
        this.scontent = scontent == null ? null : scontent.trim();
    }

    public String getSa() {
        return sa;
    }

    public void setSa(String sa) {
        this.sa = sa == null ? null : sa.trim();
    }

    public String getSb() {
        return sb;
    }

    public void setSb(String sb) {
        this.sb = sb == null ? null : sb.trim();
    }

    public String getSc() {
        return sc;
    }

    public void setSc(String sc) {
        this.sc = sc == null ? null : sc.trim();
    }

    public String getSd() {
        return sd;
    }

    public void setSd(String sd) {
        this.sd = sd == null ? null : sd.trim();
    }

    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey == null ? null : skey.trim();
    }

    public Integer getSstate() {
        return sstate;
    }

    public void setSstate(Integer sstate) {
        this.sstate = sstate;
    }
}