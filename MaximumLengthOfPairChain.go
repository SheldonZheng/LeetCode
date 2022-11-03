func findLongestChain(pairs [][]int) int {
	if pairs == nil {
		return 0
	}
	sort.Slice(pairs,func(i,j int) bool {
		return pairs[i][1] < pairs[j][1]
	})
	cur = math.MinInt32
	res := 0
	for _,v := range pairs{
		if cur < v[0] {
			cur = v[1]
			res++
		}
	}
	return res
}
