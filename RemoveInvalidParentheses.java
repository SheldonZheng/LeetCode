/**
 * LeetCode 301 Remove Invalid Parentheses
 */
class Solution {
    private Set<String> container = new HashSet<>();

    private void backtrack(String s, int index, int leftCount, int rightCount, int leftRem, int rightRem, StringBuilder str, int removeCount) {
        if (s.length() == index) {
            if (leftRem == 0 && rightRem == 0) {
                container.add(str.toString());
            }
        } else {
            char cr = s.charAt(index);
            int length = str.length();

            if (cr == '(' && leftRem > 0) {
                backtrack(s, index + 1, leftCount, rightCount, leftRem - 1, rightRem, str, removeCount);
            }
            if (cr == ')' && rightRem > 0) {
                backtrack(s, index + 1, leftCount, rightCount, leftRem, rightRem - 1, str, removeCount);
            }

            str.append(cr);
            if (cr != '(' && cr != ')') {
                backtrack(s, index + 1, leftCount, rightCount, leftRem, rightRem, str, removeCount);
            } else if (cr == '(') {
                backtrack(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, str, removeCount);
            } else if (rightCount < leftCount) {
                backtrack(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, str, removeCount);
            }

            str.deleteCharAt(length);

        }
    }

    public List<String> removeInvalidParentheses(String s) {

        int leftRem = 0;
        int rightRem = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftRem++;
            } else if (ch == ')') {
                rightRem = leftRem == 0 ? rightRem + 1 : rightRem;

                leftRem = leftRem > 0 ? leftRem - 1 : leftRem;
            }
        }

        backtrack(s, 0, 0, 0,leftRem,rightRem, new StringBuilder(), 0);
        return new ArrayList<>(container);
    }
}
