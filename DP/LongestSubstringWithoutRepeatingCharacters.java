package DP;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Baiye
 * @since 2017-04-05
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;

        int maxLen = 0;
        int start = 0;
        int len = 0;
        Map<Character,Integer> temp = new HashMap<>(256);
        for (int i = 0;i < s.length();i++) {
            if(!temp.containsKey(s.charAt(i))) {
                len++;
                if (maxLen < len) {
                    maxLen = len;
                }
                temp.put(s.charAt(i),i);
            } else {
                int index = temp.get(s.charAt(i));
                for (int j = start;j <= index;j++) {
                    temp.remove(s.charAt(j));
                }
                temp.put(s.charAt(i),i);
                start = index + 1;
                len = i - index;
            }
        }
        return maxLen;
    }
}
