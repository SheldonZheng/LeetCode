func findMinHeightTrees(n int, edges [][]int) []int {
	if n == 1 {
		return []int{0}
	}

	container := make([][]int,n)
	for _,v := range edges {
		x,y := v[0],v[1]
		container[x] = append(container[x],y)
		container[y] = append(container[y],x)
	}

	parent := make([]int,n)
	maxDepth,node := 0,-1
	var dfs func(int,int,int)
	dfs = func(x,pa,depth int) {
		if depth > maxDepth {
			maxDepth,node = depth,x
		}
		parent[x] = pa
		for _,y := range container[x] {
			if y != pa {
				dfs(y,x,depth + 1)
			}
		}
	}
	dfs(0,-1,1)
	maxDepth = 0
	dfs(node,-1,1)

	path := []int{}
	for node != -1 {
		path = append(path,node)
		node = parent[node]
	}

	m := len(path)
	if m % 2 == 0 {
		return []int{path[m / 2 - 1],path[m / 2]}
	}
	return []int{path[m / 2]}
}
