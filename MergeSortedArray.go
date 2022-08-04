func merge(nums1 []int, m int, nums2 []int, n int)  {
	res := make([]int,m + n)

	p1 := 0
	p2 := 0

	cur := 0
	for (p1 < m && p2 < n) {
		if (nums1[p1] > nums2[p2]) {
			res[cur] = nums2[p2]
			p2++
		} else {
			res[cur] = nums1[p1]
			p1++
		}
		cur++
	}

	for (p1 < m) {
		res[cur] = nums1[p1]
		p1++
		cur++
	}

	for (p2 < n) {
		res[cur] = nums2[p2]
		p2++
		cur++
	}

	copy(nums1,res)
	return 
}
