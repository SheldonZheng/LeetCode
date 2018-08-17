// LeetCode 821 
class Solution {
     public int[] shortestToChar(String S, char C) {
        if (S == null) {
            return null;
        }
        int[] result = new int[S.length()];
        List<Integer> cl = new ArrayList<>();
        for (int i = 0; i < S.toCharArray().length; i++) {
            if (S.charAt(i) == C) {
                cl.add(i);
            }
        }
        for (int i = 0; i < S.toCharArray().length; i++) {
            int min = 20000;
            for (Integer j : cl) {
                int tempR = (i - j) > 0 ? (i - j) : (j - i);
                if (tempR < min) {
                    min = tempR;
                }
            }
            result[i] = min;
        }
        return result;
    }
}
