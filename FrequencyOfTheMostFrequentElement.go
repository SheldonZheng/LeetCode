/**
 * LeetCode 1838 Frequency of the Most Frequent Element
 */
func maxFrequency(nums[] int,k int) int {
    if len(nums) == 0 {
        return 0
    }
    sort.Ints(nums)
    res := 1
    for l,r,total := 0,1,0; r < len(nums) ; r++ {
        total += (nums[r] - nums[r - 1]) * (r - l)
        for total > k {
            total -= (nums[r] - nums[l])
            l++
        }
        res = max(res,r - l + 1)
    }
    return res
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
