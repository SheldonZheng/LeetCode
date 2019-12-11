/**
 * LeetCode 131 Palindrome Partitioning
 */
class Solution {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        boolean[][] status = new boolean[s.length()][s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;
                status[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || status[i + 1][j - 1]);
            }
        }
        List<List<String>> result = new ArrayList<>();
        dfs(result,s,0,status,new ArrayList<>());
        return result;
    }

    private void dfs (List<List<String>> result , String s,int start, boolean[][] status,List<String> temp) {
        if (start == s.length()) {
            //point
            result.add(new ArrayList<>(temp));
        }

       for (int i = start; i < s.length(); i++) {
            if (status[start][i]) {
                String l = s.substring(start,i + 1);
                temp.add(l);
                dfs(result,s,i + 1,status,temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
