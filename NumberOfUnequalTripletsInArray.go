func unequalTriplets(nums []int) int {
	count := map[int]int{}
	for _,v := range nums {
		count[v]++
	}
	res ,n ,t := 0,len(nums),0
	for _,v := range count {
		res,t  = res + t * v * (n - t - v),t + v
	}
	return res
}
