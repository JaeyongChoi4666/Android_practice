package com.example.electionapp.vo;

import java.io.Serializable;

public class Election implements Serializable {
    String univ_name;
    String election_name;
    int count_candidate;
    int election_winner_code;

    public Election() {
    }

    public Election(String univ_name, String election_name, int count_candidate, int winner_code) {
        this.univ_name = univ_name;
        this.election_name = election_name;
        this.count_candidate = count_candidate;
        this.election_winner_code = winner_code;
    }

    public int getWinner_code() {
        return election_winner_code;
    }

    public void setWinner_code(int winner_code) {
        this.election_winner_code = winner_code;
    }

    public int getCount_candidate() {
        return count_candidate;
    }

    public void setCount_candidate(int count_candidate) {
        this.count_candidate = count_candidate;
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

    @Override
    public String toString() {
        return "Election{" +
                "univ_name='" + univ_name + '\'' +
                ", election_name='" + election_name + '\'' +
                ", count_candidate='" + count_candidate + '\'' +
                '}';
    }
}
