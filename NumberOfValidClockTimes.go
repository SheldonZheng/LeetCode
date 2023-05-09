func countTime(time string) int {
	countHour := 0
	countMinute := 0
	for i := 0;i < 24;i++ {
		hiHour := byte(i / 10)
		loHour := byte(i % 10)
		if (time[0] == '?' || time[0] == hiHour + '0') &&
			(time[1] == '?' || time[1] == loHour + '0') {
				countHour++
			}
	}
	for i := 0;i < 60;i++ {
		hiMinute := byte(i / 10)
		loMinute := byte(i % 10)
		if(time[3] == '?' || time[3] == hiMinute + '0') &&
			(time[4] == '?' || time[4] == loMinute + '0') {
				countMinute++
			}
	}
	return countHour * countMinute
}
