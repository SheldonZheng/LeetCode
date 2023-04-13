func mostFrequentEven(nums []int) int {
	container := map[int]int{}
	for _,v := range nums {
		if v % 2 == 0 {
			container[v]++
		}
	}
	res, ct := -1,0
	for k,v := range container {
		if res == -1 || ct < v || (ct == v && k < res) {
			res = k
			ct = v
		}
	}
	return res
}
