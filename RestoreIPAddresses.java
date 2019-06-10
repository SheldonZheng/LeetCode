/**
 * LeetCode 93 Restore IP Addresses
 */

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        if (s.length() < 4 || s.length() > 12) {
            return result;
        }

        dfs(s,"",result,3);
        return result;
    }

    private void dfs (String s,String temp, List<String> res , int count) {
        if (count == 0 && isValid(s)) {
            res.add(temp + s);
            return ;
        }
        for (int i = 1; i < 4 && i < s.length(); i++) {
            String c = s.substring(0,i);
            if (isValid(c)) {
                dfs(s.substring(i), temp.concat(c).concat("."), res, count - 1);
            }
        }
    }

    private boolean isValid(String str) {
        if (str.startsWith("0")) {
            return str.equals("0");
        }
        int n = Integer.parseInt(str);
        return n > 0 && n < 256;
    }
}
