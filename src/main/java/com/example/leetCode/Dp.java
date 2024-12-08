package com.example.leetCode;

import java.util.*;
import java.util.Arrays;

public class Dp {
    public int climbStairs(int n) { // 70. Climbing Stairs

        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        dp[0] = 0; dp[1] = 1;

        return getNum(dp, n);
    }
    public int getNum( int[] dp, int num){
        if(num == 0) return 1;
        if(num < 1) return 0;

        if(dp[num] != -1) return dp[num];

        return dp[num] = getNum(dp, num-1) + getNum(dp, num-2);
    }

    public int coinChange(int[] coins, int amount) {// 322. Coin Change
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;

        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }

    public void reverseString(char[] s) {
        //내풀이
//        Stack<Character> stack = new Stack<Character>();
//
//        for(int i=0;i<s.length;i++){
//            stack.push(s[i]);
//        }
//        for(int i=0;i<s.length;i++){
//            s[i] = stack.pop();
//        }
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public String[] reorderLogFiles(String[] logs) {

        List<String> let = new ArrayList<>();
        List<String> dig = new ArrayList<>();

        for( String log : logs ){
            if(Character.isDigit(log.split(" ")[1].charAt(0))){
                dig.add(log);
            }else{
                let.add(log);
            }
        }

        let.sort((s1, s2)->{
            String[] str1 = s1.split(" ", 2);
            String[] str2 = s2.split(" ", 2);

            int compare = str1[1].compareTo(str2[1]);

            if(compare == 0){
                return str1[0].compareTo(str2[0]);
            }else{
                return compare;
            }
        });

        let.addAll(dig);

        return let.toArray(new String[0]);
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban  = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();

        String[] str = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        for(String s : str){
            if(!ban.contains(s)){
                count.put(s, count.getOrDefault(s, 0)+1);
            }
        }

        return Collections.max(count.entrySet()
                , Map.Entry.comparingByValue()).getKey();
    }
}














