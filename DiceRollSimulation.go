func dieSimulator(n int, rollMax []int) int {
	const mod int = 1e9 + 7
	const m =  6
	f := make([][m][]int,n)
	for i := range f {
		for j := range f[i] {
			f[i][j] = make([]int,rollMax[j])
		}
	}

	for j := range f[0] {
		for k := range f[0][j] {
			f[0][j][k] = 1
		}
	}

	res := 0
	for i := 1;i < n;i++ {
		for last,mx0 := range rollMax {
			for left := 0;left < mx0;left++ {
				curRes := 0
				for j,mx := range rollMax {
					if j != last {
						curRes += f[i - 1][j][mx - 1]
					} else if left > 0 {
						curRes += f[i - 1][j][left - 1]
					}
				}
				f[i][last][left] = curRes % mod
			}
		}
	}

	for j,mx := range rollMax {
		res += f[n - 1][j][mx - 1]
	}
	return res % mod
}
