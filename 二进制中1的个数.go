/**
 * LeetCode 剑指 Offer 15 二进制中1的个数
 */
func hammingWeight(num uint32) (ones int) {
	for ; num > 0; num &= num - 1 {
		ones++
	}
	return ones
}
