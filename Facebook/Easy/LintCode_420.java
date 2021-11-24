package Facebook.Easy;

public class LintCode_420 {
    /** Solution */
    public String countAndSay(int n) {
        return countAndSay_(n);
    }

    private String countAndSay_(int n) {
        if (n == 1)
            return "1";
        String rest = countAndSay_(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 1, i = 1;
        while (i < rest.length()) {
            if (rest.charAt(i) == rest.charAt(i - 1))
                count++;
            else {
                sb.append(count);
                sb.append(rest.charAt(i - 1));
                count = 1;
            }
            i++;
        }
        sb.append(count);
        sb.append(rest.charAt(rest.length() - 1));
        return sb.toString();
    }
}
