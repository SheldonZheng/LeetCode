func findTheArrayConcVal(nums []int) int64 {
	res := 0
	i, j := 0, len(nums) - 1
	for i <= j {
		if i != j {
			val, _ := strconv.Atoi(strconv.Itoa(nums[i]) + strconv.Itoa(nums[j]))
			res += val
		} else {
			res += nums[j]
		}
		i++
		j--
	}
	return int64(res)
}
