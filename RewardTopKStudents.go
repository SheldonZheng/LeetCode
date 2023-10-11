func topStudents(positive_feedback []string, negative_feedback []string, report []string, student_id []int, k int) []int {
	words := map[string]int{}
	for _, w := range positive_feedback {
		words[w] = 3
	}
	for _, w := range negative_feedback {
		words[w] = -1
	}
	type pair struct { score, id int}
	A := make([]pair, len(report))
	for i, r := range report {
		score := 0
		for _, w := range strings.Split(r," ") {
			score += words[w]
		}
		A[i] = pair{score, student_id[i]}
	}

	sort.Slice(A, func(i, j int) bool {
		a, b := A[i], A[j]
		return a.score > b.score || a.score == b.score && a.id < b.id
	})
	res := make([]int, k)
	for i, p := range A[:k] {
		res[i] = p.id
	}
	return res
}
