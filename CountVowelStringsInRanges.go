func vowelStrings(words []string, queries [][]int) []int {
	n := len(words)
	prefixSums := make([]int,n + 1)
	for i := 0;i < n;i++ {
		value := 0
		if isVowelString(words[i]) {
			value = 1
		}
		prefixSums[i + 1] = prefixSums[i] + value
	}

	res := make([]int,len(queries))
	for i := 0;i < len(queries);i++ {
		start := queries[i][0]
		end := queries[i][1]
		res[i] = prefixSums[end + 1] - prefixSums[start]
	}
	return res
}

func isVowelString(word string) bool {
	return isVowelLetter(word[0]) && isVowelLetter(word[len(word) - 1])
}

func isVowelLetter(c byte) bool {
	return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
}
