/**
 * LeetCode 387 First Unique Character in a String
 */
class Solution {
    public int firstUniqChar(String s) {
        if (s == null) {
            return -1;
        }
        char[] strs = s.toCharArray();
        if (strs.length == 0) {
            return -1;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (map.containsKey(strs[i])) {
                map.put(strs[i],map.get(strs[i]) + 1);
            } else {
                map.put(strs[i],1);
            }
        }

        for (int i = 0; i < strs.length; i++) {
            if (map.get(strs[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
