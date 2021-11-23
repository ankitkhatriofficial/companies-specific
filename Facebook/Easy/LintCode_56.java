package Facebook;

import java.util.*;

public class LintCode_56 {
    /** Solution */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int idx = 0; idx < numbers.length; idx++) {
            int num = numbers[idx];
            if (map.containsKey(target - num))
                return new int[] { map.get(target - num), idx };
            map.put(num, idx);
        }
        return new int[] { -1, -1 };
    }
}
