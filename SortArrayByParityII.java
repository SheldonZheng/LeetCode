/**
    LeetCode 922 Sort Array By Parity II
 */
 class Solution {
    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int[] result = new int[A.length];
        int leftP = 0;
        int rightP = 0;
        for (int i = 0; i < A.length; i++) {
            int temp = 0;
            if (i % 2 == 0) {
                while (leftP < A.length) {
                    if (A[leftP] % 2 == 0) {
                        break;
                    } else {
                        leftP++;
                    }
                }
                temp = A[leftP];
                leftP++;
            } else {
                while (rightP < A.length) {
                    if (A[rightP] % 2 != 0) {
                        break;
                    } else {
                        rightP++;
                    }
                }
                temp = A[rightP];
                rightP++;
            }
            result[i] = temp;
        }
        return result;
    }
}