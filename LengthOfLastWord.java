/**
 * @author Baiye
 * @since 2017-03-15
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0)
            return 0;

        String[] splited = s.split(" ");
        if(splited.length == 0)
            return 0;

        return splited[splited.length - 1].length();
    }
}
