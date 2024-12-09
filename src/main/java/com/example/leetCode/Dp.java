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

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        if(n == 0) return 0;

        int[] arr = new int[n];

        Arrays.fill(arr, 1);

        int result = 1;

        for(int i=1; i< n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    arr[i] = Math.max(arr[i], arr[j]+1);
                }
            }
            result = Math.max(arr[i], result);
        }
        return result;
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

    public int longestCommonSubsequence(String text1, String text2) { // 1143. Longest Common Subsequence
        int w = text1.length();
        int h = text2.length();

        int[][] dp = new int[w+1][h+1];

        for(int i=1; i<=w; i++){
            for(int j=1; j<=h; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[w][h];
    }

    public boolean wordBreak(String s, List<String> wordDict) { // 139. Word Break
        Set<String> word = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length()+1];

        dp[0] = true;

        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(dp[i] && word.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) { // 39. Combination Sum
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(0, candidates, target, result, list);

        return result;
    }

    private void dfs(int index, int[] candidates, int target, List<List<Integer>> result, List<Integer> list) {
        if(index == candidates.length){
            if(target == 0){
                result.add(new ArrayList<>(list));
            }
            return;
        }
        if(candidates[index] <= target){
            list.add(candidates[index]);
            dfs(index, candidates, target - candidates[index], result, list);
            list.removeLast();
        }

        dfs(index+1, candidates, target, result, list);
    }

}









































