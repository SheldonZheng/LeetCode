/**
 * Created by Baiye on 2016/11/2.
 */

/**
 * LeetCode.345.Reverse Vowels of a String
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {

        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        char temp;

        while(start < end)
        {
            if(checkVowel(chars[start]) && checkVowel(chars[end]))
            {
                temp = chars[end];
                chars[end] = chars[start];
                chars[start] = temp;
                start++;
                end--;
            }
            else
            {
                if(!checkVowel(chars[start]))
                    start++;
                if(!checkVowel(chars[end]))
                    end--;
            }
        }

        return new String(chars);

    }

    private static boolean checkVowel(char c) {
        if ('a' == c || 'e' == c || 'i' == c || 'o' == c || 'u' == c
                || 'A' == c || 'E' == c || 'I' == c || 'O' == c || 'U' == c) {
            return true;
        }
        return false;
    }
}
