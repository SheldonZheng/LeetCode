/**
 * LeetCode 506 Relative Ranks 
 */
class Solution {
    String[] ss = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
    
    public String[] findRelativeRanks(int[] score) {
        if (score == null || score.length == 0) {
            return null;
        }
        String[] res = new String[score.length];
        int[] clone = score.clone();
        Arrays.sort(clone);
        Map<Integer,Integer> container = new HashMap<>();
        for (int i = score.length - 1; i >= 0; i--) {
            container.put(clone[i],score.length - 1 - i);
        }
        for (int i = 0; i < score.length; i++) {
            int cur = container.get(score[i]);
            res[i] = cur < 3 ? ss[cur] : String.valueOf(cur + 1);
        }
        
        return res;
    }
}
