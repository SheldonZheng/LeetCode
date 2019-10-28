/**
 * LeetCode 60 Permutation Sequence
 */
class Solution {
    public String getPermutation(int n, int k) {
        if (n == 0 || n < 0 || k == 0 || k < 0) {
            return null;
        }
        int[] nums = new int[n];
        boolean[] flag = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            flag[i] = false;
        }
        List<String> container = new ArrayList<>();
        return dfs(nums,flag,n,k,0,container);
    }

    private String dfs(int[] nums,boolean[] flag,int n,int k,int depth,List<String> container) {
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for (String s : container) {
                sb.append(s);
            }
            return sb.toString();
        }
        int fr = factorial(n - 1 - depth);
        for (int i = 0; i < n; i++) {
            if (flag[i]) {
                continue;
            }
            if (fr < k) {
                k -= fr;
                continue;
            }
            container.add(String.valueOf(nums[i]));
            flag[i] = true;
            return dfs(nums,flag,n,k,depth + 1,container);
        }
        return null;
    }

    private int factorial(int n) {
        int res = 1;
        while (n > 0) {
            res *= n;
            n--;
        }
        return res;
    }
}
