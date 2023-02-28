func mergeSimilarItems(items1 [][]int, items2 [][]int) [][]int {
	container := map[int]int{}
	for _,v := range items1 {
		container[v[0]] += v[1]
	}
	for _,v := range items2 {
		container[v[0]] += v[1]
	}
	var res [][]int
	for v,w := range container {
		res = append(res,[]int{v,w})
	}
	sort.Slice(res,func (i,j int) bool {
		return res[i][0] < res[j][0]
	})
	return res
}
