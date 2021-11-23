package Facebook;

import java.util.*;

public class LintCode_1032 {

    /** Solution */
    public List<String> letterCasePermutation(String S) {
        return letterCasePermutation_(S, 0);
    }

    private List<String> letterCasePermutation_(String s, int idx) {
        if (idx == s.length())
            return new ArrayList<>(Arrays.asList(""));
        List<String> rest = letterCasePermutation_(s, idx + 1);
        List<String> ans = new ArrayList<>();
        char ch = s.charAt(idx);
        boolean isAlpha = Character.isLetter(ch);
        for (String str : rest) {
            if (isAlpha) {
                ans.add(Character.toLowerCase(ch) + str);
                ans.add(Character.toUpperCase(ch) + str);
            } else
                ans.add(ch + str);
        }
        return ans;
    }
}
