/**
 * LeetCode 151 Reverse Words in a String
 */
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int left = 0;
        int right = s.length() - 1;

        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }

        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        Deque<String> queue = new ArrayDeque<>();
        StringBuilder cur = new StringBuilder();

        while (left <= right) {
            if (cur.length() > 0 && s.charAt(left) == ' ') {
                queue.offerFirst(cur.toString());
                cur = new StringBuilder();
            } else if (s.charAt(left) != ' ') {
                cur.append(s.charAt(left));
            }
            left++;
        }
        queue.offerFirst(cur.toString());
        return String.join(" ",queue);
    }
}
