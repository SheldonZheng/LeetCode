func repairCars(ranks []int, cars int) int64 {
	return int64(sort.Search(ranks[0] * cars * cars, func(t int) bool {
		cnt := 0
		for _, v := range ranks {
			cnt += int(math.Sqrt(float64(t / v)))
		}
		return cnt >= cars
	}))
}
