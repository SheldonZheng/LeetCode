func maxSumDivThree(nums []int) int {
	f := []int{0,-0x3f3f3f3f,-0x3f3f3f3f}
	for _,num := range nums {
		g := make([]int,3)
		for i := 0;i < 3;i++ {
			g[(i + num) % 3] = max(f[(i + num) % 3],f[i] + num)
		}
		f = g
	}
	return f[0]
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
