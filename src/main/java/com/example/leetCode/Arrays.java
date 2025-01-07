package com.example.leetCode;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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
        public int[] productExceptSelf2(int[] nums) {
            int[] arr = new int[nums.length];
            java.util.Arrays.fill(arr, 1);

            for(int i=0; i<nums.length; i++){
                for(int j=0; j<nums.length; j++){
                    if(i == j){
                        continue;
                    }
                    arr[i] = nums[i]* nums[j];
                }
            }
            return arr;
    }



    public int maxSubArray(int[] nums) {
        int nowMax =nums[0], result =nums[0];

        for(int i=1; i< nums.length; i++){
            nowMax = Math.max(nums[i], nowMax + nums[i]);
            result = Math.max(nowMax, result);
        }

        return result;
    }

    public int maxSubArray(int[] nums) {
        int now = nums[0], result = nums[0];

        for(int i=1; i<nums.length; i++){
            now = Math.max(nums[i], now+nums[i]);
            result = Math.max(now,result);
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

    public int lengthOfLIS(int[] nums) {
        int result = 0;

        for(int i=0; i<nums.length; i++){
            for(int j=i; j<nums.length; j++){

            }
        }

        return result;
    }

    public int averageValue(int[] nums) {
        int sum =0, cnt = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]%3 == 0){
                cnt++;
                sum += nums[i];
            }
        }

        return cnt == 0 ? 0 : Math.round(sum/cnt);

    }

    public String[] findWords(String[] words) {
        String setA = "qwertyuiop";
        String setB = "asdfghjkl";
        String setC = "zxcvbnm";

        List<String> result = new ArrayList<>();

        for(int i=0; i< words.length; i++){
            String[] s = words[i].toLowerCase().split("");
            boolean tmp = false;
            if(setA.contains(s[0])){
                tmp = validWord(setA, s);
            } else if (setB.contains(s[0])) {
                tmp = validWord(setB, s);
            } else{
                tmp = validWord(setC, s);
            }
            if(tmp) result.add(words[i]);
        }

        return result.toArray(new String[result.size()]);
    }

    public boolean validWord(String set, String[] word){

        for(int i=0; i< word.length; i++){
            if(!set.contains(word[i])) return false;
        }

        return true;
    }


    public int numEquivDominoPairs(int[][] dominoes) {
        Set<String> set = new HashSet<>();
        int result = 0;

        for(int i=0; i<dominoes.length; i++){
            set.add(String.valueOf(dominoes[i][0])+ String.valueOf(dominoes[i][1]));
            set.add(String.valueOf(dominoes[i][1])+ String.valueOf(dominoes[i][0]));
        }

        return (dominoes.length*2 - set.size())/2;
    }

    public boolean isPalindrome2(String s) { // 125. Valid Palindrome

        String filter = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String revert = new StringBuilder(filter).reverse().toString();

        return filter.equals(revert);
    }
    public boolean isPalindrome(String s) { // 125. Valid Palindrome
        int start = 0;
        int end = s.length()-1;

        while(start < end){
            if(!Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }else if(!Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }else{
                if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                    return false;
                }
                start++;
                end--;
            }
        }

        return true;
    }

    public void reverseString(char[] s) { // 344. Reverse String
        int start = 0, end = s.length-1;

        while(start < end){
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;

            start++;
            end--;
        }
    }

    public String[] reorderLogFiles(String[] logs) { // 937. Reorder Data in Log Files
        List<String> text = new ArrayList<>();
        List<String> num = new ArrayList<>();

        for(String s : logs){
            if(Character.isDigit(s.split(" ")[1].charAt(0))){
                num.add(s);
            }else{
                text.add(s);
            }
        }

        text.sort((s1, s2)->{
            String[] sort1 = s1.split(" ", 2);
            String[] sort2 = s2.split(" ", 2);

            int compare = sort1[1].compareTo(sort2[1]);

            if(compare == 0){
                return sort1[0].compareTo(sort2[0]);
            }else{
                return compare;
            }
        });

        text.addAll(num);

        return text.toArray(new String[text.size()]);

    }

    public String mostCommonWord1(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>(java.util.Arrays.asList(banned));

        Map<String, Integer> map = new HashMap<>();

        String[] arr = paragraph.replaceAll("\\W", " ").toLowerCase().split("\\s+");

        for(String s : arr){
            if(!ban.contains(s)){
                map.put(s, map.getOrDefault(s, 0)+1);
            }
        }

        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
    public String mostCommonWord2(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>(java.util.Arrays.asList(banned));

        return java.util.Arrays.stream(paragraph.replaceAll("\\W", " ").toLowerCase().split("\\s+"))
                .filter(word -> !ban.contains(word) && !word.isEmpty())
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }

    public List<List<String>> groupAnagrams(String[] strs) { //49 Anagrams
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] arr = s.toCharArray();

            java.util.Arrays.sort(arr);
            String str = String.valueOf(arr);

            if(!map.containsKey(str))  map.put(str, new ArrayList<>());

            map.get(str).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<>();

        for(int i=0; i< words.length; i++){
            for(int j=0; j< words.length; j++){
                if(i != j && words[i].contains(words[j])){
                    set.add(words[j]);
                }
            }
        }

        return new ArrayList<>(set);
    }






}





























