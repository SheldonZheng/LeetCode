func passThePillow(n int, time int) int {
	time %= (n - 1) * 2
	if time < n {
		return time + 1
	}
	return n * 2 - time - 1
}
