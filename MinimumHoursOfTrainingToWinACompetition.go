func minNumberOfHours(initialEnergy int, initialExperience int, energy []int, experience []int) int {
	sum := 0
	for _,v := range energy {
		sum += v
	}
	trainingHours := 0
	if initialEnergy <= sum {
		trainingHours = sum + 1 - initialEnergy
	}
	for _,v := range experience {
		if initialExperience <= v {
			trainingHours += 1 + (v - initialExperience)
			initialExperience = 2 * v + 1
		} else {
			initialExperience += v
		}
	}
	return trainingHours
}
