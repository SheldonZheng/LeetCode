/**
 * LeetCode 17.10 Find Majority Element LCCI
 */
func majorityElement(nums []int) int {
	candidate := -1
	count := 0
	for _,num := range nums {
		if (count == 0) {
			candidate = num
		}
		if (num == candidate) {
			count++
		} else {
			count--
		}
	}
	reCount := 0
	for _,num := range nums {
		if (num == candidate) {
			reCount++
		}
	}
	if (reCount * 2 > len(nums)) {
		return candidate
	}
	return -1
}
