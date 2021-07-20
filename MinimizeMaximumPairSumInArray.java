/**
 * LeetCode 1877 Minimize Maximum Pair Sum in Array
 */
func minPairSum(nums []int) int {
    if len(nums) == 0 {
        return 0
    }
    sort.Ints(nums)
    n := len(nums)
    res := 0
    for i, j := 0, n - 1;i <= j;i, j = i + 1, j - 1 {
        res = max(res,nums[i] + nums[j])
    }
    return res
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
