//LeetCode 274
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int[] hash = new int[citations.length + 1];
        for (int i : citations) {
            if (i >= citations.length) {
                hash[citations.length]++;
            } else {
                hash[i]++;
            }
        }

        for (int i = hash.length - 1; i > 0; i--) {
            if (hash[i] >= i) {
                return i;
            }
            hash[i - 1] += hash[i];
        }
        return 0;
    }
}
