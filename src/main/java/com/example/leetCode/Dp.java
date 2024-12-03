package com.example.leetCode;

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

    }
}
