func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	sumLen := len(nums1) + len(nums2)
	if sumLen % 2 == 1 {
		mid := sumLen / 2
		return float64(getKthElement(nums1,nums2,mid + 1))
	} else {
		mid := sumLen / 2
		return float64(getKthElement(nums1,nums2,mid) + getKthElement(nums1,nums2,mid + 1)) / 2.0
	}
}

func getKthElement(nums1 []int,nums2 []int, k int) int {
	i,j := 0,0
	for {
		if i == len(nums1) {
			return nums2[j + k - 1]
		}
		if j == len(nums2) {
			return nums1[i + k - 1]
		}
		if k == 1 {
			return min(nums1[i],nums2[j])
		}

		mid := k / 2
		newI := min(i + mid,len(nums1)) - 1
		newJ := min(j + mid,len(nums2)) - 1
		p1,p2 := nums1[newI],nums2[newJ]
		if p1 <= p2 {
			k -= (newI - i + 1)
			i = newI + 1
		} else {
			k -= (newJ - j + 1)
			j = newJ + 1
		}
	}
	return 0
}

func min(x, y int) int {
    if x < y {
        return x
    }
    return y
}
