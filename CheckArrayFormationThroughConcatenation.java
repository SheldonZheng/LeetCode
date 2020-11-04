/**
    LeetCode 1640 Check Array Formation Through Concatenation
 */
 class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        if (arr == null || pieces == null) {
            return false;
        }
        Map<Integer,int[]> container = new HashMap<>();
        for (int[] piece : pieces) {
            container.put(piece[0],piece);
        }
        for (int i = 0; i < arr.length; ) {
            if (container.containsKey(arr[i])) {
                int[] piece = container.get(arr[i]);
                for (int j : piece) {
                    if (arr[i] == j) {
                        i++;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }
}