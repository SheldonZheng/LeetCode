func filterRestaurants(restaurants [][]int, veganFriendly int, maxPrice int, maxDistance int) []int {
	sort.Slice(restaurants, func(i, j int) bool {
		a, b := restaurants[i], restaurants[j]
		if a[1] != b[1] {
			return a[1] > b[1]
		}
		return a[0] > b[0]
	})
	res := make([]int, 0)
	for _, r := range restaurants {
		if r[2] >= veganFriendly && r[3] <= maxPrice && r[4] <= maxDistance {
			res = append(res, r[0])
		}
	}
	return res
}
