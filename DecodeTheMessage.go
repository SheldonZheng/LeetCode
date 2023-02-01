func decodeMessage(key string, message string) string {
	cur := byte('a')
	con := map[rune]byte{}

	for _,c := range key {
		if c != ' ' && con[c] == 0 {
			con[c] = cur
			cur++
		}
	}

	m := []byte(message)
	for i,c := range message {
		if c != ' ' {
			m[i] = con[c]
		}
	}
	return string(m)
}
