func eraseOverlapIntervals(intervals [][]int) int {
	if (intervals == nil || len(intervals) == 0) {
		return 0
	}

	sort.SliceStable(intervals, func(i,j int) bool {
		return intervals[i][1] < intervals[j][1]
	})

	res := 0
	cur := intervals[0][1]

	for i := 1;i < len(intervals);i++ {
		if (intervals[i][0] < cur) {
			res++
		} else {
			cur = intervals[i][1]
		}
	}
	return res
}
