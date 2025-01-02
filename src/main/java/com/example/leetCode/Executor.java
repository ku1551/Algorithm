package com.example.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Executor {
    public static void main(String[] args) {

        Arrays arr = new Arrays();
        Dp dp = new Dp();

        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        int[][] arrs = {{1,2},{2,1},{3,4},{5,6}};

        arr.numEquivDominoPairs(arrs);
    }
}
