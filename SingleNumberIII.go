func singleNumber(nums []int) []int {
	xorSum := 0
	for _, num := range nums {
		xorSum ^= num
	}
	lsb := xorSum & - xorSum
	a := 0
	for _, x := range nums {
		if x & lsb != 0 {
			a ^= x
		}
	}
	b := xorSum ^ a
	return []int{a, b}
}
