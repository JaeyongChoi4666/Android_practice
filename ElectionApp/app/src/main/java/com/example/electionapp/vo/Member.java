package com.example.electionapp.vo;

import java.io.Serializable;

public class Member implements Serializable {
    private String member_id;
    private String member_pw;
    private String univ_name;
    private String dept_name;
    private String member_name;
    private String member_number;
    private String member_grade;

    public Member() {
        super();
    }

    public Member(String member_id, String member_pw) {
        super();
        this.member_id = member_id;
        this.member_pw = member_pw;
    }

    public Member(String member_id, String member_pw, String univ_name, String dept_name, String member_name,
                    String member_number, String member_grade) {
        super();
        this.member_id = member_id;
        this.member_pw = member_pw;
        this.univ_name = univ_name;
        this.dept_name = dept_name;
        this.member_name = member_name;
        this.member_number = member_number;
        this.member_grade = member_grade;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_pw() {
        return member_pw;
    }

    public void setMember_pw(String member_pw) {
        this.member_pw = member_pw;
    }

    public String getUniv_name() {
        return univ_name;
    }

    public void setUniv_name(String univ_name) {
        this.univ_name = univ_name;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_number() {
        return member_number;
    }

    public void setMember_number(String member_number) {
        this.member_number = member_number;
    }

    public String getMember_grade() {
        return member_grade;
    }

    public void setMember_grade(String member_grade) {
        this.member_grade = member_grade;
    }

    @Override
    public String toString() {
        return "MemberVO [member_id=" + member_id + ", member_pw=" + member_pw + ", univ_name=" + univ_name
                + ", dept_name=" + dept_name + ", member_name=" + member_name + ", member_number=" + member_number
                + ", member_grade=" + member_grade + "]";
    }

}
