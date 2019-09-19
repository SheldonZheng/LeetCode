/**
 * LeetCode 17 Letter Combinations of a Phone Number
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");

        for (int i = 0; i < digits.length(); i++) {
            while (result.peek().length() == i) {
                String a = result.remove();
                int index = Integer.parseInt(String.valueOf(digits.charAt(i)));
                for (char c : mapping[index].toCharArray()) {
                    result.add(a+c);
                }
            }
        }
        return result;

    }
}
