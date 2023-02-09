type AuthenticationManager struct {
	mp map[string]int
	ttl int
}


func Constructor(timeToLive int) AuthenticationManager {
	return AuthenticationManager{map[string]int{},timeToLive}
}


func (this *AuthenticationManager) Generate(tokenId string, currentTime int)  {
	this.mp[tokenId] = currentTime
}


func (this *AuthenticationManager) Renew(tokenId string, currentTime int)  {
	if v,ok := this.mp[tokenId];ok && v + this.ttl > currentTime {
		this.mp[tokenId] = currentTime
	}
}


func (this *AuthenticationManager) CountUnexpiredTokens(currentTime int) int {
	res := 0
	for _,t := range this.mp {
		if t + this.ttl > currentTime {
			res++
		}
	}
	return res
}


/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * obj := Constructor(timeToLive);
 * obj.Generate(tokenId,currentTime);
 * obj.Renew(tokenId,currentTime);
 * param_3 := obj.CountUnexpiredTokens(currentTime);
 */
