func topKFrequent(nums []int, k int) []int {
	container := make(map[int]int)
	for _,c := range nums {
		container[c]++
	}

	buckets := make([][]int,len(nums) + 1)
	for v,c := range container {
		if (len(buckets[c]) <= 0) {
			buckets[c] = make([]int,0)
		}
		buckets[c] = append(buckets[c],v)
	}

	res := make([]int,0)
	for i := len(buckets) - 1; i >= 0;i-- {
		if (len(buckets[i]) > 0) {
			res = append(res,buckets[i]...)
			if (len(res) >= k) {
				return res[0:k]
			}
		}
	}
	return res
}
