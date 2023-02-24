func minimumOperations(nums []int) int {
	container := make(map[int]int)
	for _,v := range nums {
		if v > 0 {
			container[v] = 0
		}
	}
	return len(container)
}
