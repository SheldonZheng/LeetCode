/**
 * LeetCode Interview Question 10.01 Sorted Merge LCCI
 */
class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        int tail = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[tail--] = A[i];
                i--;
            } else {
                A[tail--] = B[j];
                j--;
            }
        }
        while (j >= 0) {
            A[tail--] = B[j];
            j--;
        }
        return ;
    }
}
