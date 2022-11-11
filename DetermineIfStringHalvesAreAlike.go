func halvesAreAlike(s string) bool {
	container := map[byte]bool{
        'a': true,
        'e': true,
        'i': true,
        'o': true,
        'u': true,
        'A': true,
        'E': true,
        'I': true,
        'O': true,
        'U': true,
    }
	n := len(s)
	cnt := 0
	half := n / 2
	for i := 0;i < half;i++ {
		if container[s[i]] {
			cnt++
		}
		j := i + half
		if container[s[j]] {
			cnt--
		}
	}
	return cnt == 0
}
