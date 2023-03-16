func countSubarrays(nums []int, k int) int {
	kIndex := -1
	for i,num := range nums {
		if num == k {
			kIndex = i
			break
		}
	}
	res := 0
	counts := map[int]int{}
	counts[0] = 1
	sum := 0
	for i ,num := range nums {
		if num > k {
			sum++
		} else if num < k {
			sum--
		}
		if i < kIndex {
			counts[sum]++
		} else {
			res += (counts[sum] + counts[sum - 1])
		}
	}
	return res
}
