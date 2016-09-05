import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Baiye on 2016/9/5.
 */

/**
 * LeetCode.387.First Unique Character in a String
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * 水题  一个list保存，一个map记录下标，解决；
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        char[] cs=s.toCharArray();
        List<Character> list = new ArrayList<Character>();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0; i < cs.length; i++) {
            Character c=cs[i];
            if (map.containsKey(c)) {
                list.remove(c);
            }else{
                list.add(c);
                map.put(c,i);
            }
        }
        return list.size()==0?-1:map.get(list.get(0));
    }
}
