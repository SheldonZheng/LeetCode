/**
 * LeetCode 495 Teemo Attacking
 */
func findPoisonedDuration(timeSeries []int, duration int) int {
	if timeSeries == nil || len(timeSeries) == 0 || duration < 0 {
		panic("param error")
	}
	total := 0
	for i := 0;i < len(timeSeries) - 1;i++ {
		total += min(duration,timeSeries[i + 1] - timeSeries[i])
	}
	return total + duration
}

func min(a int,b int) int {
	if a < b {
		return a
	}
	return b
}
