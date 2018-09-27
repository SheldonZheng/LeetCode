//LeetCode 496
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        int[] result = new int[nums1.length];
        int maxR = 0;
        Map<Integer,Integer> location = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            maxR = Math.max(nums2[i],maxR);
            location.put(nums2[i],i);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] >= maxR) {
                result[i] = -1;
            }
            boolean flag = true;
            for (int j = location.get(nums1[i]) + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result[i] = -1;
            }
        }
        return result;
    }
}
