func removeComments(source []string) []string {
	res := []string{}
	newLine := []byte{}
	inBlock := false

	for _,line := range source {
		for i := 0;i < len(line);i++ {
			if inBlock {
				if i + 1 < len(line) && line[i] == '*' && line[i + 1] == '/' {
					inBlock = false
					i++
				}
			} else {
				if i + 1 < len(line) && line[i] == '/' && line[i + 1] == '*' {
					inBlock = true
					i++
				} else if i + 1 < len(line) && line[i] == '/' && line[i + 1] == '/'  {
					break
				} else {
					newLine = append(newLine,line[i])
				}
			}
		}
		if !inBlock && len(newLine) > 0 {
			res = append(res, string(newLine))
			newLine = []byte{}
		}
	}
	return res
}
