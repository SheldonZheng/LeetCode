func maxSubarraySumCircular(nums []int) int {
	n := len(nums)
	leftMax := make([]int,n)

	leftMax[0] = nums[0]
	leftSum,pre,res := nums[0],nums[0],nums[0]
	for i := 1;i < n;i++ {
		pre = max(pre + nums[i],nums[i])
		res = max(res,pre)
		leftSum += nums[i]
		leftMax[i] = max(leftMax[i - 1],leftSum)
	}

	rightSum := 0
	for i := n - 1;i > 0;i-- {
		rightSum += nums[i]
		res = max(res,rightSum + leftMax[i - 1])
	}
	return res
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}

func min(a int,b int) int {
	if (a < b) {
		return a
	}
	return b
}
