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

    public String longestPalindrome(String s) {
        int len = s.length();
        int left = 0, right = 0;
        int start = 0, maxLen = 0;

        if(len < 2) return s;

        for(int center=0; center<  2* len -1; center++){
            left = center/2;
            right = left + (center%2);

            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }

            int curLen = right - left-1;
            if(curLen > maxLen){
                maxLen = curLen;
                start = left+1;
            }
        }
        return s.substring(start, start+maxLen);
    }

    public int[] twoSum1(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            map.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++){
            int result = target - nums[i];
            if(map.containsKey(result) && i != map.get(result)) {
                return new int[]{i, map.get(result)};
            }
        }
        return null;
    }

    public int trap(int[] height) {
        int volume = 0, left = 0, right = height.length-1,
                maxLeft = height[left], maxRight = height[right];

        while(left < right){
            maxLeft = Math.max(height[left], maxLeft);
            maxRight = Math.max(height[right], maxRight);

            if(maxLeft <= maxRight){
                volume += maxLeft + height[left];
                left++;
            }else{
                volume += maxRight - height[right];
                right--;
            }
        }
        return volume;
    }

    public int trap1(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int volumn = 0;

        for(int i=0; i< height.length; i++){
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                Integer top = stack.pop();

                if(stack.isEmpty()) break;

                int distance = i-stack.peek() -1;

                int waters = Math.min(height[i], height[stack.peek()])-height[top];

                volumn += distance + waters;
            }
            stack.push(i);
        }

        return volumn;

    }

    public boolean isPalindrome(ListNode head) { //234.Palindrome Linked List
        List<Integer> list = new ArrayList<>();

        while(head.next != null){
            list.add(head.val);
            head = head.next;
        }

        int left = 0, right = list.size()-1;
        while(left<right){
            if(list.get(left) != list.get(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        // return reverse(head, null);
        ListNode prev = null, node = head;

        while(node != null){
            ListNode next = node.next;

            node.next = prev;

            prev = node;

            node = next;
        }
        return prev;
    }

    private ListNode reverse(ListNode node, ListNode prev){
        if(node == null) return prev;

        ListNode next = node.next;

        node.next = prev;

        return reverse(next, node);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return result.next;
    }

    public ListNode swapPairs(ListNode head) { // 24 Swap Nodes in Pairs
        if(head == null || head.next == null) return head;

        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

    public ListNode oddEvenList(ListNode head) { //328 Odd Even Linked List
        if(head == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }else if(stack.isEmpty() || stack.pop() != s.charAt(i)){
                return false;
            }
        }

        return stack.isEmpty();
    }

    public String removeDuplicateLetters(String s) {
        for(char c : toSortedSet(s)){
            String suffix = s.substring(s.indexOf(c));

            if(toSortedSet(s).equals(toSortedSet(suffix))){
                return c + removeDuplicateLetters(suffix.replace(String.valueOf(c), ""));
            }
        }
        return "";
    }

    private Set<Character> toSortedSet(String s){
        Set<Character> set = new TreeSet<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if(o1 == o2){
                    return 0;
                } else if (o1 > o2) {
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        for(int i=0; i<s.length(); i++){
            set.add(s.charAt(i));
        }

        return set;
    }

    public boolean isAnagram(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);

        return java.util.Arrays.equals(arr1, arr2);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();

        int[] result = new int[temperatures.length];

        for(int i=0; i<temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int last = stack.pop();
                result[last] = i-last;
            }

            stack.push(i);
        }
        return result;
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);

        return 1 + Math.max(leftHight, rightHight);
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            int oneDigit = s.charAt(i - 1) - '0';
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit != 0) {
                dp[i] += dp[i - 1];
            }

            if (10 <= twoDigits && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public void setZeroes(int[][] matrix) {

        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(row.contains(i)){
                    matrix[i][j] = 0;
                } else if (col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        int height = matrix.length;
        int width = matrix[0].length;
        int hinit = 0;
        int winit = 0;
        int idx = 0;

        while(height >= hinit && width >= winit){
            switch (idx %4){
                case 0:
                    for(int i=winit; i<width; i++){
                        list.add(matrix[hinit][i]);
                    }
                    hinit++;
                    idx++;
                    break;
                case 1 :
                    for(int i=hinit; i<height; i++){
                        list.add(matrix[i][width-1]);
                    }
                    idx++;
                    width--;
                    break;
                case 2 :
                    for(int i=width-1; i>=winit; i--){
                        list.add(matrix[height-1][i]);
                    }
                    idx++;
                    height--;
                    break;
                case 3 :
                    for(int i=height-1; i >=hinit; i--){
                        list.add(matrix[i][winit]);
                    }
                    idx++;
                    winit++;
                    break;
            }
        }
        return list;
    }

    class Solution {
        public void rotate(int[][] matrix) {
            for(int i=0; i<matrix.length; i++){
                for(int j=i; j<matrix[0].length; j++){
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }

            for(int i=0; i<matrix.length; i++){
                int left = 0, right = matrix.length-1;

                while(left < right){
                    int tmp = matrix[i][left];
                    matrix[i][left] = matrix[i][right];
                    matrix[i][right] = tmp;

                    left++;
                    right--;
                }
            }
        }
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean result = false;

        for(int i=0; i< board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)) {
                    result = findWord(board, visited, word, i, j, 0);
                    if(result) return true;
                }
            }
        }
        return result;
    }

    public boolean findWord(char[][] board, boolean[][] visited, String word, int i, int j, int idx){
        if(idx == word.length()) return true;

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(idx)) return false;

        visited[i][j] = true;
        idx++;
        if(findWord(board, visited, word, i+1, j, idx) ||
           findWord(board, visited, word, i-1, j, idx) ||
           findWord(board, visited, word, i, j+1, idx) ||
           findWord(board, visited, word, i, j-1, idx)
        ){
            return true;
        }

        visited[i][j] = false;
        return false;
    }


}

class MyStack {
    private Queue<Integer> queue;
    private Queue<Integer> stack;

    public MyStack() {
        queue = new LinkedList<>();
        stack= new LinkedList<>();
    }

    public void push(int x) {
        while(stack.size() > 0){
            queue.add(stack.remove());
        }

        stack.add(x);

        while(queue.size() > 0){
            stack.add(queue.remove());
        }
    }

    public int pop() {
        return stack.remove();
    }

    public int top() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
class MyQueue {
    private Deque<Integer> stack;
    private Deque<Integer> queue;
    public MyQueue() {
        stack = new ArrayDeque<>();
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        while(!queue.isEmpty()){
            stack.push(queue.remove());
        }

        queue.add(x);

        while(!stack.isEmpty()){
            queue.push(stack.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int peek() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}




























