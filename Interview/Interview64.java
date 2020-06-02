/**
 * LeetCode Interview 64 Çó 1+2+...+n
 * /
 class Solution {
    public int sumNums(int n) {
        boolean flag = (n > 0) && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
