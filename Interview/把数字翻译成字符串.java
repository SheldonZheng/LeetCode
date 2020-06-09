/**
 * LeetCode Interview 46 °ÑÊý×Ö·­Òë³É×Ö·û´®
 */
class Solution {
    public int translateNum(int num) {
		if (num <= 0) {
			return 1;
		}
		return find(num);
	}

	private int find(int num) {
		if (num < 10) {
			return 1;
		}
		int mod = num % 100;
		if (mod <= 25 && mod >= 10) {
			return find(num / 10) + find(num / 100);
		} else {
			return find(num / 10);
		}
	}
}
