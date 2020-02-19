/**
 * LeetCode 20 Valid Parentheses
 */
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if ((s.length() & 1) == 1) {
            return false;
        }
        Map<Character,Character> container = new HashMap<>();
        container.put('{','}');
        container.put('(',')');
        container.put('[',']');
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (container.containsKey(c)) {
                stack.addLast(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if (container.get(stack.removeLast()) != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
