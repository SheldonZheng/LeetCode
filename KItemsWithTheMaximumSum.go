func kItemsWithMaximumSum(numOnes int, numZeros int, numNegOnes int, k int) int {
	res := 0
	if numOnes > k {
		return k
	} else {
		res += numOnes
		k -= numOnes
	}
	if numZeros > k {
		return res
	} else {
		k -= numZeros
	}
	return res - k
}
