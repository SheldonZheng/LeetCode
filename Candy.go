func candy(ratings []int) int {
	if (ratings == nil || len(ratings) == 0) {
		return 0
	}
	
	res := make([]int,len(ratings))
	for i := 0;i < len(ratings);i++ {
		res[i] = 1
	}
	
	for i := 0;i < len(res) - 1;i++ {
		if (ratings[i + 1] > ratings[i]) {
			res[i + 1] = res[i] + 1
		}
	}

	result := 0
	for i := len(res) - 1;i > 0;i-- {
		if (ratings[i - 1] > ratings[i]) {
			if (res[i] + 1 > res[i - 1]) {
				res[i - 1] = res[i] + 1;
			}
		}
		
	}
	
	for i := 0;i < len(ratings);i++ {
		result += res[i]
	}

	return result
}

