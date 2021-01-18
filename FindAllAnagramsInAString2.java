/**
 * LeetCode 438 Find All Anagrams in a String
 * /
class Solution {
    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> res = new ArrayList<>();
        if (s == null || t == null) {
            return res;
        }
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
                if (right - left == t.length()) {
                    res.add(left);
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

        return res;
    }
}
