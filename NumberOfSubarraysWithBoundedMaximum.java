//LeetCode 795
class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        if (A == null || A.length == 0) {
            return 0;
        }
        //left point
        int lp = 0;
        int res = 0;

        int maxL = 0;
        //right point
        for (int rp = 0; rp < A.length; rp++) {
            if (A[rp] >= L && A[rp] <= R) {
                res += (rp - lp + 1);
                maxL = (rp - lp + 1);
            } else if (A[rp] < L) {
                res += maxL;
            } else {
                //reset maxL
                maxL = 0;
                //move left point
                lp = rp + 1;
            }
        }
        return res;
    }
}
