func prevPermOpt1(arr []int) []int {
	for i := len(arr) - 2;i >= 0;i-- {
		if arr[i] > arr[i + 1] {
			j := len(arr) - 1
			for arr[j] >= arr[i] || arr[j] == arr[j - 1] {
				j--
			}
			arr[i],arr[j] = arr[j],arr[i]
			break
		}
	}
	return arr
}
