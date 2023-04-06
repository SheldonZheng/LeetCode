func commonFactors(a int, b int) int {
	g := gcd(a,b)
	res := 0
	for i := 1;i * i <= g;i++ {
		if g % i == 0 {
			res++
			if i != g / i {
				res++
			}
		}
	}
	return res
}

func gcd(a,b int) int {
	for a != 0 {
		a,b = b % a,a
	}
	return b
}
