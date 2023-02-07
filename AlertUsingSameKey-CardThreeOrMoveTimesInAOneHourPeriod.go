func alertNames(keyName []string, keyTime []string) []string {
	container := map[string][]int{}
	for i,name := range keyName {
		t := keyTime[i]
		hour := int(t[0] - '0') * 10 + int(t[1] - '0')
		minute := int(t[3] - '0') * 10 + int(t[4] - '0')
		container[name] = append(container[name],hour * 60 + minute)
	}
	res := []string{}
	for name,times := range container {
		sort.Ints(times)
		for i,t := range times[2:] {
			if t - times[i] <= 60 {
				res = append(res,name)
				break
			}
		}
	}
	sort.Strings(res)
	return res
}
