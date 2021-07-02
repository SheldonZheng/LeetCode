/**
 * LeetCode 1833 Maximum Ice Cream Bars
 */
func maxIceCream(costs []int,coins int) (ans int) {
    const mx int = 1e5
    freq := [mx + 1] int{}
    for _,c := range costs {
        freq[c]++
    }
    for i := 1; i <= mx && coins >= i;i++ {
        c := min(freq[i], coins / i)
        ans += c
        coins -= i * c
    }
    return 
}
func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}

