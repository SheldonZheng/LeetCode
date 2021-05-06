/**
 * LeetCode 1720 Decode XORed Array
 */
class Solution {
    public int[] decode(int[] encoded, int first) {
		if (encoded == null || encoded.length == 0) {
			return null;
		}
		int sourceLength = encoded.length + 1;
		int[] result = new int[sourceLength];
		result[0] = first;
		for (int i = 1; i < sourceLength; i++) {
			result[i] = encoded[i - 1] ^ result[i - 1];
		}
		return result;
	}
}
