package Facebook;

import java.util.*;
import Structure.Interval;

public class LintCode_156 {
    /** Solution */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        if (intervals.size() == 0)
            return ans;
        Collections.sort(intervals, (a, b) -> (a.start - b.start));
        ans.add(intervals.get(0));
        int idx = 0, i = 1;
        while (i < intervals.size()) {
            if (intervals.get(i).start <= ans.get(idx).end) {
                int st = Math.min(intervals.get(i).start, ans.get(idx).start);
                int end = Math.max(intervals.get(i).end, ans.get(idx).end);
                ans.get(ans.size() - 1).start = st;
                ans.get(ans.size() - 1).end = end;
            } else {
                ans.add(intervals.get(i));
                idx++;
            }
            i++;
        }
        return ans;
    }
}
