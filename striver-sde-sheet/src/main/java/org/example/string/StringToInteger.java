package org.example.string;

//Time Complexity: O(n)
//Space Complexity: O(1)
//Problem link: https://leetcode.com/problems/string-to-integer-atoi/description/?source=submission-noac
//Level: Medium
public class StringToInteger {
    public int myAtoi(String s) {
        long ans = 0, temp = 0;
        final int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;
        int ind = 0, n = s.length();
        boolean isNegative = false;
        while(ind < n && s.charAt(ind) == ' '){
            ind ++;
        }
        if(ind < n && s.charAt(ind) == '-'){
            ind ++;
            isNegative = true;
        }
        else if(ind < n && s.charAt(ind) == '+'){
            ind ++;
        }
        System.out.println("ind: " + ind);
        while(ind < n){
            int num = -1;
            switch(s.charAt(ind)){
                case '0':
                    num = 0;
                    break;
                case '1':
                    num = 1;
                    break;
                case '2':
                    num = 2;
                    break;
                case '3':
                    num = 3;
                    break;
                case '4':
                    num = 4;
                    break;
                case '5':
                    num = 5;
                    break;
                case '6':
                    num = 6;
                    break;
                case '7':
                    num = 7;
                    break;
                case '8':
                    num = 8;
                    break;
                case '9':
                    num = 9;
                    break;
                default:
                    return isNegative? (-ans < MIN? MIN: (int)-ans): (ans > MAX? MAX: (int)ans);
            }
            ans = temp + num;
            temp = ans;
            temp *= 10;
            ind ++;
            if(ans > MAX){
                return isNegative? (-ans < MIN? MIN: (int)-ans): (ans > MAX? MAX: (int)ans);
            }
        }

        return isNegative? (-ans < MIN? MIN: (int)-ans): (ans > MAX? MAX: (int)ans);

    }
}
