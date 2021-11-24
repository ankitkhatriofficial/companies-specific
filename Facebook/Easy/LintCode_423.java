package Facebook.Easy;

import java.util.Stack;

public class LintCode_423 {
    /** Solution */
    public boolean isValidParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else if (ch == ')') {
                if (st.isEmpty() || st.peek() != '(')
                    return false;
                st.pop();
            } else if (ch == '}') {
                if (st.isEmpty() || st.peek() != '{')
                    return false;
                st.pop();
            } else if (ch == ']') {
                if (st.isEmpty() || st.peek() != '[')
                    return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }
}
