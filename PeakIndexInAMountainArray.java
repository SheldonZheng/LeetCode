class Solution {
    public int peakIndexInMountainArray(int[] A) {
        if (A.length <= 0) {
            return 0;
        }
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                return i;
            }
        }
        return 0;
    }
}
