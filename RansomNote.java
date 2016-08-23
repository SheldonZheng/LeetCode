import java.util.HashMap;
import java.util.Map;

/**
 * Created by Baiye on 2016/8/23.
 */

/**
 * LeetCode 383 RansomNote
 *  Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  write  a  function  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;  otherwise,  it  will  return  false.   

 Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> tempMap = new HashMap<>();

        char[]  after = ransomNote.toCharArray();
        char[] source = magazine.toCharArray();
        for (char c : source) {
            if(tempMap.get(c) != null)
            {
                int i = tempMap.get(c);
                i++;
                tempMap.put(c,i);

            }
            else
            {
                tempMap.put(c,1);
            }
        }

        for (char c : after) {
            if(tempMap.get(c) != null)
            {
                int i = tempMap.get(c);
                i--;
                if(i < 0)
                    return false;
                tempMap.put(c,i);
            }
            else
                return false;
        }

        return true;
    }


}
