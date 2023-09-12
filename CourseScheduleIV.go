func checkIfPrerequisite(numCourses int, prerequisites [][]int, queries [][]int) []bool {
	n := numCourses
	f := make([][]bool, n)
	for i := range f {
		f[i] = make([]bool, n)
	}
	for _, p := range prerequisites {
		f[p[0]][p[1]] = true
	}

	for k := 0;k < n;k++ {
		for i := 0;i < n;i++ {
			for j := 0;j < n;j++ {
				f[i][j] = f[i][j] || (f[i][k] && f[k][j])
			}
		}
	}

	res := make([]bool, 0)
	for _, q := range queries {
		res = append(res, f[q[0]][q[1]])
	}
	return res
}
