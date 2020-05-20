/**
 * LeetCode 1371 Find the Longest Substring Containing Vowels in Even Counts
 */
class Solution {
    private static final char[] source = new char[]{'a','e','i','o','u'};

    public int findTheLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character,Boolean> initContainer = new HashMap<>();
        for (char c : s.toCharArray()) {
            initContainer.put(c,!initContainer.getOrDefault(c,Boolean.TRUE));
        }
        Map<Character,Boolean> container = new HashMap<>();
        container.putAll(initContainer);
        int result = 0;
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if ((right - left) < (result - 1)) {
                break;
            }
            while (left <= right) {
                if (isCorrect(container)) {
                    result = Math.max(result,right - left + 1);
                    break;
                } else {
                    container.put(s.charAt(left),!container.getOrDefault(s.charAt(left),Boolean.TRUE));
                    left++;
                }
                if ((right - left) < (result - 1)) {
                    break;
                }
            }
            left = 0;
            initContainer.put(s.charAt(right),!initContainer.getOrDefault(s.charAt(right),Boolean.TRUE));
            right--;
            container = new HashMap<>();
            container.putAll(initContainer);
        }
        return result;
    }

    public boolean isCorrect(Map<Character,Boolean> container) {
        for (char c : source) {
            if (!container.getOrDefault(c,Boolean.TRUE)) {
                return false;
            }
        }
        return true;
    }
}
