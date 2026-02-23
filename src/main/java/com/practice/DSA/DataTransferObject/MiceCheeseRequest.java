package com.practice.DSA.DataTransferObject;

import java.util.LinkedList;

public class MiceCheeseRequest {
    private LinkedList<Integer> reward1;
    private LinkedList<Integer> reward2;
    private int k;

    public LinkedList<Integer> getReward1() {
        return reward1;
    }

    public void setReward1(LinkedList<Integer> reward1) {
        this.reward1 = reward1;
    }

    public LinkedList<Integer> getReward2() {
        return reward2;
    }

    public void setReward2(LinkedList<Integer> reward2) {
        this.reward2 = reward2;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

}
