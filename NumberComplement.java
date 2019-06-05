//leetcode 476
class Solution {
    public int findComplement(int num) {
        int mask = 1;
        int temp = num;
        while (temp > 0) {
            mask = mask << 1;
            temp = temp >> 1;
        }
        return num ^ (mask - 1);
    }
}
