/*
 * LeetCode 275 H-Index II
 */
func hIndex(citations []int) int {
    if len(citations) == 0 {
        return 0
    }
    n := len(citations)
    return n - sort.Search(n,func (x int) bool { return citations[x] >= n - x})
}
func hIndex(citations []int) int {
	n := len(citations)
	l ,r := 0, n
	for l < r {
		mid := (l + r + 1) / 2
		if citations[n - mid] >= mid {
			l = mid
		} else {
			r = mid - 1
		}
	}
	return l
}
