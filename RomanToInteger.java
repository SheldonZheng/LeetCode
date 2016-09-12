import java.util.HashMap;
import java.util.Map;

/**
 * Created by Baiye on 2016/9/12.
 */

/**
 * LeetCode.13. Roman to Integer
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 */
public class RomanToInteger {
    public int romanToInt(String s) {

        if (s.length() == 0)
            return -1;

        Map<String, Integer> maps = new HashMap<String, Integer>();
        maps.put("I", 1);
        maps.put("II", 2);
        maps.put("III", 3);
        maps.put("IV", 4);
        maps.put("V", 5);
        maps.put("VI", 6);
        maps.put("VII", 7);
        maps.put("VIII", 8);
        maps.put("IX", 9);
        maps.put("X", 10);
        maps.put("XX", 20);
        maps.put("XXX", 30);
        maps.put("XL", 40);
        maps.put("L", 50);
        maps.put("LX", 60);
        maps.put("LXX", 70);
        maps.put("LXXX", 80);
        maps.put("XC", 90);
        maps.put("C", 100);
        maps.put("CC", 200);
        maps.put("CCC", 300);
        maps.put("CD", 400);
        maps.put("D", 500);
        maps.put("DC", 600);
        maps.put("DCC", 700);
        maps.put("DCCC", 800);
        maps.put("CM", 900);
        maps.put("M", 1000);
        maps.put("MM", 2000);
        maps.put("MMM", 3000);


        int count = 0;
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            while (flag < s.length()
                    && maps.get(s.substring(i, flag + 1)) != null) {
                flag++;
            }
            count = count + maps.get(s.substring(i, flag));
            i = flag - 1;
        }
        return count;
    }
}
