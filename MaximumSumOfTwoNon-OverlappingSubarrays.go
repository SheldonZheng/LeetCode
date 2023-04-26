func maxSumTwoNoOverlap(nums []int, firstLen int, secondLen int) int {
	n := len(nums)
	s := make([]int,n + 1)
	for i,v := range nums {
		s[i + 1] = s[i] + v
	}
	f := func(a,b int) (res int) {
		for i,t := a,0;i + b - 1 < n;i++ {
			t = max(t, s[i] - s[i - a])
			res = max(res,t + s[i + b] - s[i])
		}
		return
	}
	return max(f(firstLen,secondLen),f(secondLen,firstLen))
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
