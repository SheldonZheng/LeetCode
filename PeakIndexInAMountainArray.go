/**
 * LeetCode 852 Peak Index in a Mountain Array
 */
func peakIndexInMountainArray(arr []int) int {
	if arr == nil || len(arr) == 0 {
		panic("param error")
	}
	return sort.Search(len(arr) - 1,func (i int) bool { return arr[i] > arr[i + 1]})
}
