func maximumSum(arr []int) int {
	f0,f1,res := arr[0],0,arr[0]
	for i := 1;i < len(arr);i++ {
		f0,f1 = max(f0,0) + arr[i],max(f1 + arr[i],f0)
		res = max(res,max(f0,f1))
	}
	return res
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
