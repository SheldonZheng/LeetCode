// LeetCode 867
class Solution {
    public int[][] transpose(int[][] A) {
        if (A == null) {
            return null;
        }
        int lenA = A.length;
        int lenB = A[0].length;
        int[][] result = new int[lenB][];
        for (int i = 0; i < lenB; i++) {
            result[i] = new int[lenA];
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }
}
