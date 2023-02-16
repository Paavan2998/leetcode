package easy;

import java.util.HashMap;

public class romanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }

//  my solution takes 5ms to execute and consumes 48.8 MB of space
//  probably because of accessing the hash map every time
    public static int romanToInt(String s){
        HashMap<Character, Integer> romanToIntMap = initializeRomanToIntMap();
        int ans = 0;
        int slen = s.length() -1;
        while(slen > 0){
            int rightCharValue = romanToIntMap.get(s.charAt(slen));
            int leftCharValue = romanToIntMap.get(s.charAt(slen-1));
            if(rightCharValue <= leftCharValue){
                ans = ans + rightCharValue;
                slen = slen - 1;
            }else {
                ans = ans + rightCharValue - leftCharValue;
                slen = slen - 2;
            }
        }
        if(slen == 0 ){
            ans = ans + romanToIntMap.get(s.charAt(slen));
        }
        return ans;
    }
    public static HashMap initializeRomanToIntMap(){
        HashMap<Character, Integer> romanToIntMap = new HashMap<>();
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);
        return romanToIntMap;
    }

//  leetcode solution
//  because the values stored in hashmap are fixed and finite
//  we can use switch case to reduce time it takes to access the map
//  it will also reduce the space complexity
//  takes 3ms to execute and 42.3 MB of space
    public static int romanToIntSwitchCase(String s) {
        int answer = 0, number = 0, prev = 0;

        for (int j = s.length() - 1; j >= 0; j--) {
            switch (s.charAt(j)) {
                case 'M' : number = 1000;
                case 'D' : number = 500;
                case 'C' : number = 100;
                case 'L' : number = 50;
                case 'X' : number = 10;
                case 'V' : number = 5;
                case 'I' : number = 1;
            }
            if (number < prev) {
                answer -= number;
            }
            else {
                answer += number;
            }
            prev = number;
        }
        return answer;
    }
}
