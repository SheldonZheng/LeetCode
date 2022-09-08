func findLadders(beginWord string, endWord string, wordList []string) [][]string {
	container := map[string]int{beginWord:0}
	wordMap := map[string]bool{}
	res := [][]string{}
	for _,v := range wordList {
		wordMap[v] = true
	}

	if !wordMap[endWord] {
		return res
	}

	q := []string{beginWord}
	steps := 0
	wordMap[beginWord] = false
	isFound := false
	for len(q) > 0 {
		steps++

		newq := []string{}
		for _,curWord := range q {
			//canReach := map[string]bool{}
			for nextWord,v := range wordMap {
				if !v {
					continue
				}
				if isSimilar(curWord,nextWord) {
					if nextWord == endWord {
						isFound = true
					}
					container[nextWord] = container[curWord] + 1
					newq = append(newq,nextWord)
					//canReach[nextWord] = true
					wordMap[nextWord] = false
				}
			}
			//graph[curWord] = canReach
		}


		if isFound {
			break
		}

		q = newq
	}

	var dfs func(string,[]string)
	dfs = func(curWord string,cur []string) {
		cur = append(cur,curWord)
		if container[curWord] == 1 {
			cur = append(cur,beginWord)
			tmp := cur
			for i,j := 0,len(tmp) - 1;i < j;i,j = i + 1,j - 1 {
				tmp[i],tmp[j] = tmp[j],tmp[i]
			}
			res = append(res,tmp)
			cur = cur[0:len(cur) - 2]
            return
		}

		for _,nextWord := range wordList {
			if _,have := container[nextWord]; have && isSimilar(curWord,nextWord) && container[curWord] == container[nextWord] + 1 {
				dfs(nextWord,cur)
			}
		}
		cur = cur[:len(cur) - 1]
	}
	dfs(endWord,[]string{})
	return res
}

func isSimilar(a,b string) bool {
	res := 0
	for i,_ := range a {
		if a[i] != b[i] {
			res++
		}
	}
	return res == 1
}
