package Facebook.Medium;

import java.util.*;

public class LintCode_911 {
    /** Solution */
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0, csum = 0;
        for (int i = 0; i < nums.length; i++) {
            csum += nums[i];
            if (map.containsKey(csum - k) && i - map.get(csum - k) > ans)
                ans = i - map.get(csum - k);
            if (!map.containsKey(csum))
                map.put(csum, i);
        }
        return ans;
    }
}
