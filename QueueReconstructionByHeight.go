func reconstructQueue(people [][]int) [][]int {
	res := make([][]int, 0)
	if (people == nil || len(people) == 0) {
		return res
	}
	sort.Slice(people ,func(i ,j int) bool {
		if (people[i][0] == people[j][0]) {
			return people[i][1] < people[j][1]
		} else {
			return people[j][0] < people[i][0]
		}
	})

	for _,cur := range people {
		idx := cur[1]
		res = append(res[:idx],append([][]int{cur}, res[idx:]...)...)
	}
	return res
}
