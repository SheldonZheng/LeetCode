func hardestWorker(n int, logs [][]int) int {
	maxValue := logs[0][1]
	maxId := logs[0][0]
	for i := 1;i < len(logs);i++ {
		curValue := logs[i][1] - logs[i - 1][1]
		if curValue > maxValue || (curValue == maxValue && logs[i][0] < maxId){
			maxValue = curValue
			maxId = logs[i][0]
		}
	}
	return maxId
}
