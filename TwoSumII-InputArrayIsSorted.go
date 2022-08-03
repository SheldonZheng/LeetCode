func twoSum(numbers []int, target int) []int {
	if (numbers == nil || len(numbers) == 0) {
		return nil
	}

	l := 0
	r := len(numbers) - 1
	for (l < r) {
		cur := numbers[l] + numbers[r]
		if (cur < target) {
			l++
		} else if (cur == target) {
			res := []int{l + 1,r + 1}
			return res
		} else {
			r--
		}
	}
	return nil	
}
