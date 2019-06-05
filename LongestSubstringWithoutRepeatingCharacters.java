/**
 * LeetCode 3 Longest Substring Without Repeating Characters
 */

public class Solution {
      public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        Map<Character,Integer> map = new HashMap<>(256);
        int i = 0;
        int ans = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)),i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
