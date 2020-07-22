/**
 * ��ָ Offer 11 ��ת�������С���� LCOF
 */
class Solution {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int p = left + (right - left) / 2;
            if (numbers[p] > numbers[right]) {
                left = p + 1;
            } else if (numbers[p] < numbers[right]) {
                right = p;
            } else {
                right--;
            }
        }
        return numbers[left];
    }
}
