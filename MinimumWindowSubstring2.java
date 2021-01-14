/**
 * LeetCode 76 Minimum Window Substring solution 2
 */
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }
        int start = 0;
        int minLength = -1;
        int left = 0 ,right = 0;
        Map<Character,Integer> cur = new HashMap<>();
        Map<Character,Integer> needs = new HashMap<>();
        for (char c : t.toCharArray()) {
            needs.put(c,needs.getOrDefault(c,0) + 1);
        }

        int match = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (needs.containsKey(c)) {
                cur.put(c,cur.getOrDefault(c,0) + 1);
                if (cur.get(c).equals(needs.get(c))) {
                    match++;
                }
            }
            right++;

            while (match == needs.size()) {
                if (right - left < minLength || minLength == -1) {
                    start = left;
                    minLength = right - left;
                }
                char ci = s.charAt(left);
                if (needs.containsKey(ci)) {
                    if (cur.get(ci).equals(needs.get(ci))) {
                        match--;
                    }
                    cur.put(ci,cur.get(ci) - 1);
                }
                left++;
            }
        }

        return minLength != -1 ? s.substring(start,start + minLength) : "";
    }
}
