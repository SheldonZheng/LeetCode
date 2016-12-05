/**
 * Created by Baiye on 2016/12/5.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode.438.Find All Anagrams in a String
 */
public class FindAllAnagramsIinAString {
    private boolean check(int counter[],int tmp[]){
        for(int i=0;i<26;i++)
            if (counter[i] != tmp[i])
                return false;
        return true;
    }

    /**
     * 滑动窗口+每滑动一次就检查一次
     * */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if(s.length() < p.length()) return res;
        char S[] = s.toCharArray();
        char P[] = p.toCharArray();
        int counter[] = new int[26];
        int tmp[] = new int[26];
        for(char c:P)
            counter[c-'a']++;
        for(int i=0;i<P.length;i++)
            tmp[S[i]-'a']++;
        if(check(counter,tmp))
            res.add(0);
        for(int i=P.length;i<S.length;i++){
            tmp[S[i-P.length]-'a']--;
            tmp[S[i]-'a']++;
            if(check(counter,tmp)) res.add(i-P.length+1);
        }
        return res;


    }
}
