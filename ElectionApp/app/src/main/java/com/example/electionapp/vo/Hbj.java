package com.example.electionapp.vo;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.Arrays;

public class Hbj implements Serializable {
    private int hbj_code;
    private String univ_name;
    private String election_name;
    private String hbj_name;
    private String hbj_gender;
    private String hbj_grade;
    private String hbj_giho;
    private String hbj_prom1;
    private String hbj_prom2;
    private String hbj_prom3;
    private byte[] hbj_picture;
    private int hbj_vote;

    public Hbj() {
    }

    public Hbj(int hbj_code, String univ_name, String election_name, String hbj_name, String hbj_gender, String hbj_grade, String hbj_giho, String hbj_prom1, String hbj_prom2, String hbj_prom3, byte[] hbj_picture, int hbj_vote) {
        this.hbj_code = hbj_code;
        this.univ_name = univ_name;
        this.election_name = election_name;
        this.hbj_name = hbj_name;
        this.hbj_gender = hbj_gender;
        this.hbj_grade = hbj_grade;
        this.hbj_giho = hbj_giho;
        this.hbj_prom1 = hbj_prom1;
        this.hbj_prom2 = hbj_prom2;
        this.hbj_prom3 = hbj_prom3;
        this.hbj_picture = hbj_picture;
        this.hbj_vote = hbj_vote;
    }

    public int getHbj_code() {
        return hbj_code;
    }

    public void setHbj_code(int hbj_code) {
        this.hbj_code = hbj_code;
    }

    public String getUniv_name() {
        return univ_name;
    }

    public void setUniv_name(String univ_name) {
        this.univ_name = univ_name;
    }

    public String getElection_name() {
        return election_name;
    }

    public void setElection_name(String election_name) {
        this.election_name = election_name;
    }

    public String getHbj_name() {
        return hbj_name;
    }

    public void setHbj_name(String hbj_name) {
        this.hbj_name = hbj_name;
    }

    public String getHbj_gender() {
        return hbj_gender;
    }

    public void setHbj_gender(String hbj_gender) {
        this.hbj_gender = hbj_gender;
    }

    public String getHbj_grade() {
        return hbj_grade;
    }

    public void setHbj_grade(String hbj_grade) {
        this.hbj_grade = hbj_grade;
    }

    public String getHbj_giho() {
        return hbj_giho;
    }

    public void setHbj_giho(String hbj_giho) {
        this.hbj_giho = hbj_giho;
    }

    public String getHbj_prom1() {
        return hbj_prom1;
    }

    public void setHbj_prom1(String hbj_prom1) {
        this.hbj_prom1 = hbj_prom1;
    }

    public String getHbj_prom2() {
        return hbj_prom2;
    }

    public void setHbj_prom2(String hbj_prom2) {
        this.hbj_prom2 = hbj_prom2;
    }

    public String getHbj_prom3() {
        return hbj_prom3;
    }

    public void setHbj_prom3(String hbj_prom3) {
        this.hbj_prom3 = hbj_prom3;
    }

    public byte[] getHbj_picture() {
        return hbj_picture;
    }

    public void setHbj_picture(byte[] hbj_picture) {
        this.hbj_picture = hbj_picture;
    }

    public int getHbj_vote() {
        return hbj_vote;
    }

    public void setHbj_vote(int hbj_vote) {
        this.hbj_vote = hbj_vote;
    }

    @Override
    public String toString() {
        return "Hbj{" +
                "hbj_code=" + hbj_code +
                ", univ_name='" + univ_name + '\'' +
                ", election_name='" + election_name + '\'' +
                ", hbj_name='" + hbj_name + '\'' +
                ", hbj_gender='" + hbj_gender + '\'' +
                ", hbj_grade='" + hbj_grade + '\'' +
                ", hbj_giho='" + hbj_giho + '\'' +
                ", hbj_prom1='" + hbj_prom1 + '\'' +
                ", hbj_prom2='" + hbj_prom2 + '\'' +
                ", hbj_prom3='" + hbj_prom3 + '\'' +
                ", hbj_picture=" + Arrays.toString(hbj_picture) +
                ", hbj_vote=" + hbj_vote +
                '}';
    }
}
