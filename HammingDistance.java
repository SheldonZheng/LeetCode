//Leetcode 461
class Solution {
    public int haammingDistance(int x, int y) {
        int count = 0;
        int i = x ^ y;
        while (i a!= 0) {
            count++;
            //remove last i
            i = i & (i - 1);
        }
        return count;
    }
}
