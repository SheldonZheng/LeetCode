func maxDistToClosest(seats []int) int {
	first, last := -1,-1
	maxDis := -1
	for i,v := range seats {
		if v == 1 {
			if last != -1 {
				maxDis = max(maxDis,i - last)
			}
			if first == -1 {
				first = i
			}
			last = i
		}
	}
	return max(max(first,len(seats) - last - 1),maxDis / 2)
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
