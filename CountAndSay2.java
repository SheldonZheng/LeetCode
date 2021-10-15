/**
 * LeetCode 38 Count and Say
 */
public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int cur = 0;

            while (cur < str.length()) {
                while (cur < str.length() && str.charAt(cur) == str.charAt(start)) {
                    cur++;
                }
                sb.append(cur - start);
                sb.append(str.charAt(start));
                start = cur;
            }
            str = sb.toString();
        }
        return str;
    }
