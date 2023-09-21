func collectTheCoins(coins []int, edges [][]int) int {
	n := len(coins)
	g := make([][]int, n)
	deg := make([]int, n)
	for _, e := range edges {
		x, y := e[0], e[1]
		g[x] = append(g[x], y)
		g[y] = append(g[y], x)
		deg[x]++
		deg[y]++
	}

	leftEdges := n - 1

	q := []int{}
	for i, d := range deg {
		if d == 1 && coins[i] == 0 {
			q = append(q, i)
		}
	}

	for len(q) > 0 {
		x := q[len(q) - 1]
		q = q[:len(q) - 1]
		leftEdges--
		for _, y := range g[x] {
			deg[y]--
			if deg[y] == 1 && coins[y] == 0 {
				q = append(q, y)
			}
		}
	}

	for i, d := range deg {
		if d == 1 && coins[i] > 0 {
			q = append(q, i)
		}
	}
	leftEdges -= len(q)

	for _, x := range q {
		for _, y := range g[x] {
			deg[y]--
			if deg[y] == 1 {
				leftEdges--
			}
		}
	}

	if leftEdges < 0 {
		return 0
	}
	return leftEdges * 2
}
