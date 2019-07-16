/**
 * LeetCode 350 Intersection of Two Arrays II
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer,Integer> container = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (!container.containsKey(nums1[i])) {
                container.put(nums1[i],1);
            } else {
                container.put(nums1[i],container.get(nums1[i]) + 1);
            }
        }
        int[] result = new int[container.size()];
        int j = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (container.containsKey(nums2[i])) {
                int count = container.get(nums2[i]);
                if (count == 1) {
                    container.remove(nums2[i]);
                } else {
                    container.put(nums2[i],--count);

                }
                result[j++] = nums2[i];
            }
        }

        int[] lresult = new int[j];
        for (int i = 0; i < j; i++) {
            lresult[i] = result[i];
        }

        return lresult;

    }
}
