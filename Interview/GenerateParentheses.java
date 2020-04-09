/**
 * LeetCode 22 Generate Parentheses
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result,new StringBuilder(),0,0,n);
        return result;
    }

    public void backtrack(List<String> result, StringBuilder cur,int left,int right,int max) {
        if (cur.length() == max * 2) {
            result.add(cur.toString());
            return;
        }

        if (left < max) {
            cur.append('(');
            backtrack(result,cur,left + 1,right,max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (right < left) {
            cur.append(')');
            backtrack(result,cur,left,right + 1,max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
