func maxSumAfterPartitioning(arr []int, k int) int {
	n := len(arr)
	d := make([]int,n)
	for i := 0;i < n;i++ {
		maxValue := arr[i]
		for j := i;j >= max(0,i - k + 1);j-- {
			maxValue = max(maxValue,arr[j])
			if j > 0 {
				d[i] = max(d[i], d[j - 1] + maxValue * (i - j + 1))
			} else {
				d[i] = max(d[i], 0 + maxValue * (i - j + 1))
			}
			
		}
	}
	return d[n - 1]
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
