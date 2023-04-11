func isRobotBounded(instructions string) bool {
	direList := [][]int{{0,1},{1,0},{0,-1},{-1,0}}
	direcIndex := 0
	x,y := 0,0
	n := len(instructions)
	for i := 0;i < n;i++ {
		cur := instructions[i]
		if cur == 'G' {
			x += direList[direcIndex][0]
			y += direList[direcIndex][1]
		} else if cur == 'L' {
			direcIndex += 3
			direcIndex %= 4
		} else {
			direcIndex++
			direcIndex %= 4
		}
	}
	return direcIndex != 0 || (x == 0 && y == 0)
}
