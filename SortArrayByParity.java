//LeetCode 905
class Solution {
    public int[] sortArrayByParity(int[] A) {
        if (A == null) {
            return null;
        }
        int[] one = new int[A.length];
        int[] two = new int[A.length];
        int oneP = 0;
        int twoP = 0;
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & 1) != 0) {
                one[oneP++] = A[i];
            } else {
                two[twoP++] = A[i];
            }
        }
        for (int i = 0; i < oneP; i++) {
            two[twoP++] = one[i];
        }

        return two;
    }
}
