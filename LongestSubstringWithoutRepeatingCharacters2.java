/**
 * LeetCode 3 Longest Substring Without Repeating Characters
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0,right = 0;
        int res = 0;
        Map<Character,Integer> container = new HashMap<>();
        char[] chars = s.toCharArray();
        while (right < chars.length) {
            char c1 = chars[right];
            container.put(c1,container.getOrDefault(c1,0) + 1);
            right++;
            while (container.get(c1).compareTo(1) > 0) {
                char c2 = chars[left];
                container.put(c2,container.get(c2) - 1);
                left++;
            }
            res = Math.max(res,right - left);
        }
        return res;
    }
}
