/**
 * LeetCode Interview 62 ԲȦ�����ʣ�µ�����
 */
class Solution {
    public int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        //xx[ans]
        return ans;
    }
}
