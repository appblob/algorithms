package strings;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class BasicCalculator2 {

    /**
     2+3-1 = 0 + (+2) + (+3) + (-1)
     */
    int calculate(String s) {

        int len = s.length();
        char[] chars = s.toCharArray();

        int result = 0;

        int previous = 0; // stores previously found number
        char prevOperation = '+'; // stores previously found operator

        int current = 0;  // new number currently found

        for(int i = 0; i < len; i++) {

            char ch = chars[i];

            if(ch == ' ') continue;

            else if(Character.isDigit(ch)) {

                current = ch - '0';

                while((i + 1) < len && Character.isDigit(chars[i + 1])) {

                    current = current * 10 + chars[i + 1] - '0';
                    i++;
                }
                // once a number ends
                // perform operation on previous and current numbers
                switch(prevOperation) {
                    case '+' :
                        result += previous;
                        previous = current;
                        break;

                    case '-' :
                        result += previous;
                        previous = -current; //3-4 previous = -4
                        break;

                    case '*' :
                        previous *= current;
                        break;

                    case '/':
                        previous /= current;
                        break;
                }
            } else {

                prevOperation = ch;
            }

        }

        return result + previous;
    }

    public int calculateV1(String s) {

        if(s == null || s.length() == 0) return 0;

        Stack<Integer> numStack =  new Stack<>();

        int num = 0;
        char prevSign = '+';
        for(int i = 0; i< s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) num = num * 10 + (ch - '0');

            if(ch != ' ' && !Character.isDigit(ch) || i == s.length() - 1) {

                if(prevSign == '+') numStack.push(num);
                if(prevSign == '-') numStack.push(-num);
                if(prevSign == '*') numStack.push(numStack.pop() * num);
                if(prevSign == '/') numStack.push(numStack.pop() / num);

                // store the sign for the next time, num is used so reset it to 0
                prevSign = ch;
                num = 0;
            }
        }

        int result = 0;
        for(int number : numStack) result += number;

        return result;
    }
    
    public int calculateV2(String s) {

        if(s == null || s.length() == 0) return 0;

        Deque<Integer> numStack =  new LinkedList<>();

        int num = 0;
        char prevSign = '+';
        for(int i = 0; i< s.length(); i++) {

            char ch = s.charAt(i);

            if(Character.isDigit(ch)) num = num * 10 + ch - '0';

            if(ch != ' ' && !Character.isDigit(ch) || i == s.length() - 1) {

                if(prevSign == '+') numStack.offerFirst(num);
                if(prevSign == '-') numStack.offerFirst(-num);
                if(prevSign == '*') numStack.offerFirst(numStack.pollFirst() * num);
                if(prevSign == '/') numStack.offerFirst(numStack.pollFirst() / num);

                prevSign = ch;
                num = 0;
            }
        }

        int result = 0;
        for(int number : numStack) result += number;

        return result;
    }
}
