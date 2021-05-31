package com.example.electionapp.vo;

public class Dept {
    private String univ_name = null;
    private String dept_name = null;

    public Dept() {
        super();
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

    @Override
    public String toString() {
        return "Dept [univ_name=" + univ_name + ", dept_name=" + dept_name + "]";
    }
}
