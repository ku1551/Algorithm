package com.example.leetCode;

public class Binary {
    public int getSum(int a, int b) { // 371. Sum of Two Integers
        return Integer.sum(a, b);
    }

    public int hammingWeight(int n) { // 191. Number of 1 Bits
        String num = Integer.toBinaryString(n);

        int result = 0;
        for(int i=0; i<num.length(); i++){
            if(num.charAt(i) == '1'){
                result +=1;
            }
        }
        System.out.println(num);
        return result;
    }

    public int[] countBits(int n) { // 338. Counting Bits

        int[] arr = new int[n+1];

        for(int i=0; i<arr.length; i++){

            int result = 0;
            String num = Integer.toBinaryString(i);
            for(int j=0; j<num.length(); j++){
                if(num.charAt(j) == '1'){
                    result +=1;
                }
            }
            arr[i] = result;
        }

        return arr;
    }

    public int missingNumber(int[] nums) { // 268. Missing Number
        java.util.Arrays.sort(nums);

        if(nums[0] != 0) return 0;

        if(nums[nums.length-1] != nums.length) return nums.length;

        for(int i=1; i<nums.length; i++){
            if(nums[i] != i) return i;
        }
        return 0;
    }

    public int reverseBits(int n) { // 190. Reverse Bits
//        return Integer.reverse(n);

        int result =0;

        for(int i = 0; i< 32; i++){
            result <<= 1;
            result |= (n & 1);
            n >>= 1;
        }
        return result;
    }
}
