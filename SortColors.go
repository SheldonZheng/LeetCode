func sortColors(nums []int)  {
	p0,p1 := 0,0
	for i,v := range nums {
		if (v == 0) {
			nums[i],nums[p0] = nums[p0],nums[i]
			if (p0 < p1) {
				nums[i],nums[p1] = nums[p1],nums[i]
			}
			p0++
			p1++
		} else if (v == 1) {
			nums[i],nums[p1] = nums[p1],nums[i]
			p1++
		}
	}
}
