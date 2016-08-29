/**
 * Created by Baiye on 2016/8/29.
 */

import java.util.Arrays;

/**
 * LeetCode.242.Valid Anagram
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int[] temp = new int[128];
        for (char c : sArr) {
            temp[c]++;
        }
        for (char c : tArr) {
            temp[c]--;
            if (temp[c] < 0)
                return false;
        }

        return true;
    }

}
