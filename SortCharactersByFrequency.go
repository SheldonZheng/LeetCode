func frequencySort(s string) string {
	container := make(map[byte]int)
	maxFreq := 0
	for i := range s {
		container[s[i]]++
		maxFreq = max(maxFreq,container[s[i]])
	}
	buckets := make([][]byte,maxFreq + 1)
	for v,c := range container {
		buckets[c] = append(buckets[c],v)
	}

	res := make([]byte,0,len(s))

	for i := maxFreq;i > 0;i-- {
		for _,cnt := range buckets[i] {
			res = append(res,bytes.Repeat([]byte{cnt},i)...)
		}
	}
	return string(res)
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
