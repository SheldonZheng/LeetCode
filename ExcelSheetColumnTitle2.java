/**
 * LeetCode 168 Excel Sheet Column Title Soulution 2
 */
class Solution {
    public String convertToTitle(int columnNumber) {
        if (columnNumber == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
