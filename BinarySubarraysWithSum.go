/**
 * LeetCode 930 Binary Subarrays With Sum
 */
func numSubarraysWithSum(nums []int,goal int) (res int) {
  if nums == nil {
    return 0
  }
  l1,l2 := 0,0
  sum1,sum2 := 0,0
  for right,num := range nums {
    sum1 += num
    for l1 <= right && sum1 > goal {
      sum1 -= nums[l1]
      l1++
    }
    sum2 += num
    for l2 <= right && sum2 >= goal {
      sum2 -= nums[l2]
      l2++
    }
    res += l2 - l1
  }
  return res
}

