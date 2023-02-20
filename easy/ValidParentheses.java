package easy;

import java.util.Stack;

/*
* Input: s = "()"
* Output: true
*
* Input: s = "()[]{}"
* Output: true
*
* Input: s = "(]"
* Output: false
*
* */
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Boolean isValid = false;
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            Character c = s.charAt(i);
            switch (c){
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.isEmpty() || !stack.pop().equals('(')){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || !stack.pop().equals('{')){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || !stack.pop().equals('[')){
                        return false;
                    }
                    break;
            }
        }
        if(stack.empty()){
            isValid = true;
        }
        return isValid;
    }

}
