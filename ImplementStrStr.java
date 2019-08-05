/**
 * LeetCode 28 Implement strStr()
 */
class Solution {
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        char[] find = haystack.toCharArray();
        char[] str = needle.toCharArray();
        int e = -1;
        int p = 0;

        int i = 0;
        while (i < find.length) {
            if (find[i] == str[0]) {
                //find
                boolean result = true;
                if (find.length - i < str.length) {
                    return -1;
                } else {
                    for (int j = 0; j < str.length; j++) {
                        if (find[i + j] != str[j]) {
                            result = false;
                            break;
                        }
                    }
                    if (result) {
                        return i;
                    }
                }
            }
            i++;
        }
        return -1;
    }
}
