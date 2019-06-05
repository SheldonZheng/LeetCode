class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] newL = new int[A.length][];
        for (int i = 0; i < A.length; i++) {
            newL[i] = new int[A[i].length];
            for (int j = 0; j < A[i].length; j++) {
                newL[i][A[i].length-j-1] = (A[i][j] == 1?0:1);
            }
        }
        return newL;
    }
}
