/**
 * LeetCode 1013 Partition Array Into Three Parts With Equal Sum
 */
class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int target = sum / 3;
        int cur = 0;
        int i = 0;
        for (int k = 0; k < A.length; k++) {
            cur += A[k];
            if (cur == target) {
                i = k;
                break;
            }
        }
        if (cur != target) {
            return false;
        }
        int j = i + 1;
        target = target * 2;
        for (int k = j; k < A.length - 1; k++) {
            cur += A[k];
            if (cur == target) {
                return true;
            }
        }
        return false;
    }
}
