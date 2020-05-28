/**
 * LeetCode 394 Decode String
 */
class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return dfs(s.toCharArray(),0)[0];
    }

    public String[] dfs(char[] ss,int i ) {
        int nums = 0;
        StringBuilder sb = new StringBuilder();
        while (i < ss.length) {
            if (Character.isDigit(ss[i])) {
                nums = nums * 10 + (ss[i] - '0');
            } else if (ss[i] == '[') {
                String[] temp = dfs(ss,i + 1);
                //jump
                i = Integer.parseInt(temp[0]);
                while (nums > 0) {
                    sb.append(temp[1]);
                    nums--;
                }
            } else if (ss[i] == ']') {
                //Ìø³ö
                return new String[]{String.valueOf(i),sb.toString()};
            } else {
                sb.append(ss[i]);
            }
            i++;
        }
        return new String[]{sb.toString()};
    }
}
