/**
 * LeetCode  1846 Maximum Element After Decreasing and Rearranging
 */
func maximumElementAfterDecrementingAndRearranging(arr []int) int {
    if len(arr) == 0 {
        return 0
    }
    n := len(arr)
    cnt := make([]int,n + 1)
    for _,i := range arr {
        cnt[min(i,n)]++
    }
    miss := 0
    for _,c := range cnt[1:] {
        if c == 0 {
            miss++
        } else {
            miss -= min(c - 1,miss)
        }
    }
    return n - miss
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
