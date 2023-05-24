func frogPosition(n int, edges [][]int, t int, target int) float64 {
	G := make([][]int,n + 1)
	for i := 0;i <= n;i++ {
		G[i] = make([]int,0)
	}
	for _,e := range edges {
		G[e[0]] = append(G[e[0]],e[1])
		G[e[1]] = append(G[e[1]],e[0])
	}
	seen := make([]bool,n + 1)
	return dfs(G,seen,1,t,target)
}

func dfs(G [][]int,seen []bool,i int,t int,target int) float64 {
	nxt := len(G[i])
	if i > 1 {
		nxt -= 1
	}
	if t == 0 || nxt == 0 {
		if i == target {
			return 1.0
		} else {
			return 0.0
		}
	}

	seen[i] = true
	res := 0.0
	for _,j := range G[i] {
		if !seen[j] {
			res += dfs(G,seen,j,t - 1,target)
		}
	}
	return res / float64(nxt)
}
