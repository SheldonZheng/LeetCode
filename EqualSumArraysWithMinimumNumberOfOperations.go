func minOperations(nums1 []int, nums2 []int) int {
		if nums1 == nil || nums2 == nil {
			return -1
		}
		n := len(nums1)
		m := len(nums2)
		if 6 * n < m || 6 * m < n {
			return - 1
		}
		cnt1 := make([]int,7)
		cnt2 := make([]int,7)
        diff := 0
		for _,v := range nums1 {
			cnt1[v]++
			diff += v
		}
		for _,v := range nums2 {
			cnt2[v]++
			diff -= v
		}
		if diff == 0 {
			return 0
		}
		if diff > 0 {
			return help(cnt2,cnt1,diff)
		} else {
			return help(cnt1,cnt2,-diff)
		}
}

func help(h1 []int, h2 []int, diff int) int {
	h := [7]int{}
	for i := 1;i < 7;i++ {
		h[6 - i] += h1[i]
		h[i - 1] += h2[i]
	}
	res := 0
	for i := 5;i > 0 && diff > 0;i-- {
		t := min((diff + i - 1) / i,h[i])
		res += t
		diff -= t * i
	}
	return res
}

func min(a int,b int) int {
	if (a < b) {
		return a
	}
	return b
}
