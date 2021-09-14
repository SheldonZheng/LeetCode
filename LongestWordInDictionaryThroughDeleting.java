/**
 * LeetCode 524 Longest Word in Dictionary through Deleting
 */
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        if (s == null || s.length() == 0 || dictionary == null || dictionary.size() == 0) {
            throw new IllegalArgumentException();
        }
        Collections.sort(dictionary, (a,b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }
            return a.compareTo(b);
        });
        for (String cur : dictionary) {
            int i = 0,j = 0;
            while (i < s.length() && j < cur.length()) {
                if (s.charAt(i) == cur.charAt(j)) {
                    j++;
                }
                i++;
            }
            if (j == cur.length()) {
                return cur;
            }
        }
        return "";
    }
}
