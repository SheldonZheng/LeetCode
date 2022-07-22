func canPlaceFlowers(flowerbed []int, n int) bool {
	if (flowerbed == nil || len(flowerbed) == 0) {
		return false
	}
	if (n <= 0) {
		return true
	}

    if(len(flowerbed) == 1) {
        if (flowerbed[0] == 0 && n == 1) {
            return true
        } else {
            return false
        }
    } else if (len(flowerbed) == 2) {
        if (n == 1 && flowerbed[0] == 0 && flowerbed[1] == 0) {
            return true
        } else {
            return false
        }
    }
	
	plant := 0

    if (flowerbed[0] == 0 && flowerbed[1] == 0) {
        flowerbed[0] = 1
        plant++
    }

	for i := 1;i < len(flowerbed) - 1;i++ {
		if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
			plant++
			flowerbed[i] = 1
		}
	}

    if (flowerbed[len(flowerbed) - 1] == 0 && flowerbed[len(flowerbed) - 2] == 0) {
        plant++
    }
	return plant >= n
}
