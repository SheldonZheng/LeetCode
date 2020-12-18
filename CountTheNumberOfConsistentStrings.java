/**
 * LeetCode 1684 Count the Number Of Consistent Strings
 */
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        if (allowed == null || words == null) {
            return 0;
        }
        int res = 0;
        Set<Character> container = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            container.add(c);
        }
        for (String word : words) {
            Boolean flag = true;
            for (char c : word.toCharArray()) {
                if (!container.contains(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res++;
            }
        }
        return res;
    }
}
