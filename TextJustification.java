/**
 * LeetCode 68 Text Justification
 */
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0) {
            throw new IllegalArgumentException();
        }
        List<String> res = new ArrayList<>();
        int right = 0;
        int n = words.length;
        while (true) {
            int left = right;
            int sumLen = 0;

            while (right < n && sumLen + words[right].length() + right - left <= maxWidth) {
                sumLen += words[right++].length();
            }

            if (right == n) {
                StringBuffer sb = join(words,left,right," ");
                sb.append(blank(maxWidth - sb.length()));
                res.add(sb.toString());
                return res;
            }

            int numWords = right - left;
            int numSpace = maxWidth - sumLen;

            if (numWords == 1) {
                StringBuffer sb = new StringBuffer(words[left]);
                sb.append(blank(numSpace));
                res.add(sb.toString());
                continue;
            }

            int avgSpace = numSpace / (numWords - 1);
            int extraSpace = numSpace % (numWords - 1);
            StringBuffer sb = new StringBuffer();
            sb.append(join(words,left,left + extraSpace + 1,blank(avgSpace + 1)));
            sb.append(blank(avgSpace));
            sb.append(join(words,left + extraSpace + 1,right,blank(avgSpace)));
            res.add(sb.toString());
        }
    }

    public String blank(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i < n;i++) {
            sb.append(' ');
        }
        return sb.toString();
    }

    public StringBuffer join(String[] word,int left ,int right,String sep) {
        StringBuffer sb = new StringBuffer(word[left]);
        for (int i = left + 1; i < right; i++) {
            sb.append(sep);
            sb.append(word[i]);
        }
        return sb;
    }
}
