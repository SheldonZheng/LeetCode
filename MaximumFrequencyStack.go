type FreqStack struct {
	freq map[int]int
	group map[int][]int
	maxFreq int
}


func Constructor() FreqStack {
	return FreqStack{map[int]int{},map[int][]int{},0}
}


func (this *FreqStack) Push(val int)  {
	this.freq[val]++
	this.group[this.freq[val]] = append(this.group[this.freq[val]],val)
	this.maxFreq = max(this.maxFreq,this.freq[val])
}


func (this *FreqStack) Pop() int {
	val := this.group[this.maxFreq][len(this.group[this.maxFreq]) - 1]
	this.group[this.maxFreq] = this.group[this.maxFreq][:len(this.group[this.maxFreq]) - 1]
	this.freq[val]--
	if len(this.group[this.maxFreq]) == 0 {
		this.maxFreq--
	}
	return val
}

func max(a int,b int) int {
	if (a > b) {
		return a
	}
	return b
}
