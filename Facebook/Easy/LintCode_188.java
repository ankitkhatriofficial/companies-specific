package Facebook;

public class LintCode_188 {
    /** Solution */
    public int InsertFive(int a) {
        StringBuilder sb = new StringBuilder(a + "");
        boolean isPositive = true;
        if (a < 0) {
            isPositive = false;
            sb.deleteCharAt(0);
        }
        boolean isInserted = false;
        for (int i = 0; i < sb.length(); i++) {
            if (isPositive && sb.charAt(i) - '0' < 5) {
                sb.insert(i, '5');
                isInserted = true;
                break;
            } else if (!isPositive && sb.charAt(i) - '0' > 5) {
                sb.insert(i, '5');
                isInserted = true;
                break;
            }
        }
        if (!isInserted)
            sb.append(5);
        int ans = Integer.parseInt(sb.toString());
        if (isPositive)
            return ans;
        else
            return -ans;
    }
}
