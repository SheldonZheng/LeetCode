func angleClock(hour int, minutes int) float64 {
	var oneMinAngle,oneHourAngle,minAngle,hourAngle,diff float64
	oneMinAngle = 6
	oneHourAngle = 30

	minAngle = oneMinAngle * float64(minutes)
	hourAngle = (float64(hour % 12) + float64(minutes) / 60.0) * oneHourAngle

	diff = math.Abs(hourAngle - minAngle)
	return math.Min(diff,360 - diff)
}
