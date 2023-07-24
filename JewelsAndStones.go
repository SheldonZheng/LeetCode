func numJewelsInStones(jewels string, stones string) int {
	res := 0
	jewelsSet := map[byte]bool{}

	for i := range jewels {
		jewelsSet[jewels[i]] = true
	}

	for i := range stones {
		if jewelsSet[stones[i]] {
			res++
		}
	}
	return res
}
