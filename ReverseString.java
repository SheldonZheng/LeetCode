//LeetCode 344

public class Solution {
    public String reverseString(String s) {
        int length = s.length();
		if(length <= 1)
			return s;
		String left = s.substring(0,length / 2);
		String right = s.substring(length / 2,length);
		return reverseString(right) + reverseString(left);
    }
}