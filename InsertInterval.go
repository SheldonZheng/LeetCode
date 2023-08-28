func insert(intervals [][]int, newInterval []int) [][]int {
		res := make([][]int,0)
	if intervals == nil || len(intervals) == 0 {
		res = append(res,newInterval)
		return res
	}
	l,r := newInterval[0], newInterval[1]
	insert := false
	for i := range intervals {
		if intervals[i][1] < l {
			res = append(res,intervals[i])
		} else if intervals[i][0] < l && intervals[i][1] > r {
			return intervals
		} else if (r < intervals[i][0]) {
			if !insert {
				res = append(res, []int{l,r})
				insert = true
			}
			res = append(res,intervals[i])
		} else {
			l = min(l,intervals[i][0])
			r = max(r,intervals[i][1])
		}
	}
	if !insert {
		res = append(res, []int{l,r})
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
