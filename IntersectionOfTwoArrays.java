//LeetCode 349
class Solution {
     public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Set<Integer> container = new HashSet<>();
        Set<Integer> resultContainer = new HashSet<>();
        for (int i : nums1) {
            container.add(i);
        }
        for (int i : nums2) {
            if (container.contains(i)) {
                resultContainer.add(i);
            }
        }
        int p = 0;
        int[] result = new int[resultContainer.size()];
        for (int i : resultContainer) {
            result[p] = i;
            p++;
        } 
        return result;
    }
}
