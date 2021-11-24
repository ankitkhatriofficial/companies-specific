package Facebook.Medium;

import java.util.*;

public class LintCode_945 {

    /** Method 1 using MaxHeap and frequency */
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char ch : tasks)
            freq[ch - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0)
                pq.offer(freq[i]);
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            LinkedList<Integer> li = new LinkedList<>();
            while (!pq.isEmpty() && li.size() <= n)
                li.addLast(pq.poll() - 1);
            int size = li.size();
            while (li.size() > 0) {
                int f = li.removeFirst();
                if (f > 0)
                    pq.offer(f);
            }
            if (pq.size() > 0)
                ans += n + 1;
            else
                ans += size;
        }
        return ans;
    }

    /** Method 2 using HashMap only (faster) */
    public int leastInterval_02(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int maxUnitTime = 0;
        for (char task : tasks) {
            if (!map.containsKey(task))
                map.put(task, 0);
            int unitTime = map.get(task) + 1;
            map.put(task, unitTime);
            maxUnitTime = Math.max(maxUnitTime, unitTime);
        }
        int numTaskWithMaxUnitTime = 0;
        for (char task : map.keySet()) {
            if (map.get(task) == maxUnitTime)
                numTaskWithMaxUnitTime++;
        }
        return Math.max(tasks.length, (maxUnitTime - 1) * (n + 1) + numTaskWithMaxUnitTime);
    }

    /** Method 3 much in O(1) space using formula (much more efficient) */
    public int leastInterval_03(char[] tasks, int n) {
        int m = tasks.length;
        int[] freq = new int[26];
        for (int i = 0; i < m; i++) {
            freq[tasks[i] - 'A']++;
        }
        int maxFreq = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
            }
        }
        int maxCount = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == maxFreq) {
                maxCount++;
            }
        }
        int totalCyclesFree = (maxFreq - 1) * Math.max(0, n - maxCount + 1);
        int remainingTasks = m - maxFreq * maxCount;
        if (remainingTasks < totalCyclesFree)
            return totalCyclesFree + maxFreq * maxCount;
        else
            return m;
    }
}
