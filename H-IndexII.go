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
