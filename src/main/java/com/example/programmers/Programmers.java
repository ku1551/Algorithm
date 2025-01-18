package com.example.programmers;

public class programmers {
        public int solution(int[] wallet, int[] bill) {
            int answer = 0;
            wallet = checkRange(wallet);
            bill = checkRange(bill);
            
            while(bill[0] > wallet[0] || bill[1] > wallet[1]){
                bill[0] = bill[0]/2;
                bill = checkRange(bill);
                answer++;
            }
            
            return answer;
        }
        
        public int[] checkRange(int[] arr){
            if(arr[0] < arr[1]){
                int tmp = arr[0];
                arr[0] = arr[1];
                arr[1] = tmp;
            }
            
            return arr;
        }

}
