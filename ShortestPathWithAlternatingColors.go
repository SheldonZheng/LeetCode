func shortestAlternatingPaths(n int, redEdges [][]int, blueEdges [][]int) []int {
	type pair struct { x,color int }
	g := make([][]pair,n)
	for _,e := range redEdges {
		g[e[0]] = append(g[e[0]],pair{e[1],0})
	}

	for _,e := range blueEdges {
		g[e[0]] = append(g[e[0]],pair{e[1],1})
	}

	dis := make([]int,n)
	for i := range dis {
		dis[i] = -1
	}

	vis := make([][2]bool,n)
	vis[0] = [2]bool{true,true}

	q := []pair{{0,0},{0,1}}

	for level := 0;len(q) > 0;level++ {
		tmp := q
		q = nil

		for _,node := range tmp {
			x := node.x
			if dis[x] < 0 {
				dis[x] = level
			}
			for _,nxt := range g[x] {
				if nxt.color != node.color && !vis[nxt.x][nxt.color] {
					vis[nxt.x][nxt.color] = true
					q = append(q,nxt)
				}
			}
		}
	}
	return dis
}
