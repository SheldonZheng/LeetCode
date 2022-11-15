func maximumUnits(boxTypes [][]int, truckSize int) int {
	if boxTypes == nil || truckSize <= 0 {
		return 0
	}
	sort.Slice(boxTypes,func(i,j int) bool {
		return boxTypes[i][1] > boxTypes[j][1] 
	})
	maxSize := 0
	for _,v := range boxTypes {
		if truckSize == 0 {
			return maxSize
		}
		if truckSize > v[0] {
			maxSize += (v[1] * v[0])
		} else {
			maxSize += (truckSize * v[1])
			return maxSize
		}
		truckSize -= v[0]
	}
	return maxSize
}
