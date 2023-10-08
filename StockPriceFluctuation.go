type StockPrice struct {
	timePriceMap map[int]int
	maxTimestamp int
	prices	     *redblacktree.Tree
}


func Constructor() StockPrice {
	return StockPrice{map[int]int{}, 0, redblacktree.NewWithIntComparator()}
}


func (this *StockPrice) Update(timestamp int, price int)  {
	if prevPrice := this.timePriceMap[timestamp]; prevPrice > 0 {
		if times, _ := this.prices.Get(prevPrice); times.(int) > 1 {
			this.prices.Put(prevPrice, times.(int) - 1)
		} else {
			this.prices.Remove(prevPrice)
		}
	}
	times := 0
	if val, ok := this.prices.Get(price); ok {
		times = val.(int)
	}
	this.prices.Put(price, times + 1)
	this.timePriceMap[timestamp] = price
	if timestamp > this.maxTimestamp {
		this.maxTimestamp = timestamp
	}
}


func (this *StockPrice) Current() int {
	return this.timePriceMap[this.maxTimestamp]
}


func (this *StockPrice) Maximum() int {
	return this.prices.Right().Key.(int)
}


func (this *StockPrice) Minimum() int {
	return this.prices.Left().Key.(int)
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Update(timestamp,price);
 * param_2 := obj.Current();
 * param_3 := obj.Maximum();
 * param_4 := obj.Minimum();
 */
