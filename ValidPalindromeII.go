func validPalindrome(s string) bool {
	l, r := 0, len(s)-1
	for l < r {
		if s[l] == s[r] {
			l++
			r--
		} else {
			return isPalindrome(s[l:r]) || isPalindrome(s[l+1:r+1])
		}
	}
	return true
}

func isPalindrome(s string) bool {
	l, r := 0, len(s)-1
	for l < r {
		if s[l] == s[r] {
			l++
			r--
		} else {
			return false
		}
	}
	return true
}
