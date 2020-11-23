/**
 * LeetCode 5605 Check If Two String Arrays are Equivalent
 */
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1 == null || word2 == null) {
            return false;
        }
        int count1 = 0,count2 = 0;
        int index = 1;
        for (String s : word1) {
            for (char c : s.toCharArray()) {
                count1 += (index * c);
                index++;
            }
        }
        index = 1;
        for (String s : word2) {
            for (char c : s.toCharArray()) {
                count2 += (index * c);
                index++;
            }
        }
        return count1 == count2;
    }
}
