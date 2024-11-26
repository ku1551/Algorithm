package com.example.leetCode;

import java.util.*;
import java.util.stream.IntStream;

public class Arrays {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            int diff = target - nums[i];

            if(map.containsKey(diff)){
                result[0] = map.get(diff);
                result[1] = i;
            }

            map.put(nums[i], i);
        }
        return result;
    }

    public int maxProfit(int[] prices) {
        int result = 0;
        int minvalue = prices[0];

        for(int i=0; i< prices.length; i++){
            minvalue = Math.min(prices[i], minvalue);
            result = Math.max(result, prices[i] - minvalue);
        }

        return result;
    }


    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        boolean result = false;

        for(int i =0; i< nums.length; i++){
            if (set.contains(nums[i])){
                result =  true;
                break;
            }else{
                set.add(nums[i]);
            }
        }
        return false;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] result = new int[nums.length];

        if(nums.length == 1) return nums;

        prefix[0] = 1;
        for(int i=1; i< nums.length; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        suffix[nums.length-1] = 1;
        for(int i=nums.length-2; i >= 0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        for(int i=0; i<nums.length; i++){
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }

    public int maxSubArray(int[] nums) {
        int nowMax =nums[0], result =nums[0];

        for(int i=1; i< nums.length; i++){
            nowMax = Math.max(nums[i], nowMax + nums[i]);
            result = Math.max(nowMax, result);
        }

        return result;
    }

    public int maxProduct(int[] nums) { //Maximum Product Subarray
        int  min = nums[0], max = nums[0], result =max ;

        for(int i = 1; i< nums.length; i++) {
            int preMax = max;

            max  = IntStream.of(nums[i], preMax * nums[i], min * nums[i]).max().orElseThrow();
            min  = IntStream.of(nums[i], preMax * nums[i], min * nums[i]).min().orElseThrow();
            result = Math.max(result, max);
        }

        return result;
    }

    public int findMin(int[] nums) { // Find Minimum in Rotated Sorted
        java.util.Arrays.sort(nums);
        return nums[0];
    }

    public int search(int[] nums, int target) { // Search in Rotated Sorted Array
        // solution 1
        //        for(int i=0; i< nums.length; i++){
//            if(nums[i] == target) return i;
//        }
//        return -1;

        // solution2
        int min =0, max = nums.length-1;
        while (min <= max){
            int Mid = min + (max - min) / 2;
            if(nums[Mid] == target){
                return Mid;
            }
            if(nums[min] <= nums[Mid]){
                if(target >= nums[min] && target < nums[Mid]){
                    max = Mid -1;
                }else{
                    min = Mid +1;
                }
            }else{
                if(target <= nums[max] && target > nums[Mid]){
                    min = Mid +1;
                }else{
                    max = Mid -1;
                }
            }
        }
        return -1;
    }

    public List<List<Integer>> threeSum(int[] nums) { // 15. 3Sum
        List<List<Integer>> arr = new ArrayList<>();
        java.util.Arrays.sort(nums);

        for(int i=0; i< nums.length-2; i++){
            if(i != 0 && nums[i] == nums[i-1]) continue;

            int j = i+1, k = nums.length-1;

            while(j<k){
                if(j != i+1 && nums[j] == nums[j-1]){
                    j++;
                    continue;
                }

                if(k != nums.length -1 && nums[k] == nums[k+1]){
                    k--;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == 0 ){
                    arr.add(java.util.Arrays.asList(nums[i], nums[j++], nums[k]));
                }else if (sum < 0 ){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return arr;
    }


    public int maxArea(int[] height) { // 11. Container With Most Water
        int left = 0, right = height.length-1, area = 0;

        while (left < right){
            area = Math.max(area, (Math.min(height[left], height[right]) * (right - left)));

            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }
        return area;
    }

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

    public int missingNumber(int[] nums) {
        java.util.Arrays.sort(nums);

        if(nums[0] != 0) return 0;

        if(nums[nums.length-1] != nums.length) return nums.length;

        for(int i=1; i<nums.length; i++){
            if(nums[i] != i) return i;
        }
        return 0;
    }


}





























