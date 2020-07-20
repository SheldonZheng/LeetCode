/**
 * LeetCode 167 Two Sum II - Input array is sorted
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        int left = 0;
        int right = numbers.length - 1;
        while (numbers[left] + numbers[right] != target && left < right) {
            if ((numbers[left] + numbers[right]) < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{left + 1,right + 1};
    }
}
