/**
 * LeetCode 22 Generate Parentheses
 */
class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        backtrack(result,"",0,0,n);
        return result;
    }

    private void backtrack(List<String> result, String cur, int left, int right, int max) {
        if (cur.length() == max * 2) {
            result.add(cur);
            return ;
        }

        if (left < max) {
            backtrack(result,cur + "(",left + 1,right,max);
        }
        if (right < left) {
            backtrack(result,cur + ")",left,right + 1,max);
        }
    }
}
