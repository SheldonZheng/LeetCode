func twoOutOfThree(nums1 []int, nums2 []int, nums3 []int) []int {
	mask := map[int]int{}
	for i,nums := range [][]int{nums1,nums2,nums3} {
		for _,v := range nums {
			mask[v] |= 1 << i
		}
	}
	res := []int{}

	for i,m := range mask {
		if m & (m - 1) > 0 {
			res = append(res,i)
		}
	}
	return res
}
