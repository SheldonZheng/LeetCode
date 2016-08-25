/**
 * Created by Baiye on 2016/8/24.
 */

/**
 * LeetCode.168.Excel Sheet Column Title
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 */

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        String result = "";
        while(n>0){
            result = (char)((n-1)%26 +'A') + result;
            n = (n-1)/26;
        }
        return result;

    }
}
