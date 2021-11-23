package Facebook;

public class LintCode_64 {
    /** Solution */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int idx = A.length - 1, i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j])
                A[idx--] = A[i--];
            else
                A[idx--] = B[j--];
        }
        while (j >= 0)
            A[idx--] = B[j--];
    }
}
