func minTaps(n int, ranges []int) int {
	rightMost := make([]int,n + 1)
	for i := range rightMost {
		rightMost[i] = i
	}
	for i,r := range ranges {
		start := max(0, i - r)
		end := min(n,i + r)
		rightMost[start] = max(rightMost[start],end)
	}

	last,res,pre := 0,0,0
	for i := 0;i < n;i++ {
		last = max(last,rightMost[i])
		if i == last {
			return -1
		}
		if i == pre {
			res++
			pre = last
		}
	}
	return res
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}

func min(a int,b int) int {
	if (a < b) {
		return a
	}
	return b
}
