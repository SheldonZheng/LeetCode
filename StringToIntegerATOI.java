/**
 * LeetCode 8 String to Integer(atoi)
 */
class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        if (str.trim().length() == 0) {
            return 0;
        }
        str = str.trim();
        if (!Character.isDigit(str.charAt(0)) && str.charAt(0) != '-' && str.charAt(0) != '+') {
            return 0;
        }
        if (str.length() > 1) {
            if (!Character.isDigit(str.charAt(0)) && !Character.isDigit(str.charAt(1))) {
                return 0;
            }
        }
        int flag = 1;
        char[] strs = str.toCharArray();
        for (int i = 0; i < strs.length; i++) {
            if (Character.isDigit(strs[i]) && i > 0 && strs[i - 1] == '-') {
                flag = -1;
                break;
            }
        }
        boolean init = false;
        if (flag == -1) {
            if (strs.length <= 1) {
                return 0;
            }
            int s = 0;
            for (int i = 0; i < strs.length; i++) {
                if (Character.isDigit(strs[i])) {
                    if (s == 0) {
                        s = 0 - Integer.valueOf(String.valueOf(strs[i]));
                        init = true;
                        continue;
                    }
                    int pop = Integer.valueOf(String.valueOf(strs[i]));
                    //0x80000000
                    if ((s < Integer.MIN_VALUE / 10) || (s == Integer.MIN_VALUE / 10 && pop > 8)) {
                        return Integer.MIN_VALUE;
                    } else {
                        s = s * 10 - pop;
                    }
                } else {
                    if (init) {
                        return s;
                    }
                }
            }
            return s;
        } else if (flag == 1) {
            int s = 0;
            for (int i = 0; i < strs.length; i++) {
                if (Character.isDigit(strs[i])) {
                    if (s == 0) {
                        s = Integer.valueOf(String.valueOf(strs[i]));
                        init = true;
                        continue;
                    }
                    int pop = Integer.valueOf(String.valueOf(strs[i]));
                    //0x7fffffff
                    if ((s > Integer.MAX_VALUE / 10) || (s == Integer.MAX_VALUE / 10 && pop > 7)) {
                        return Integer.MAX_VALUE;
                    } else {
                        s = s * 10 + pop;
                    }
                } else {
                    if (init) {
                        return s;
                    }
                }
            }
            return s;
        }
        return 0;
    }
}
