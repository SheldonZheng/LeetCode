//LeetCode 816
class Solution {
     public List<String> ambiguousCoordinates(String S) {
        int l = S.length();
        List<String> res = new ArrayList<>();
        for (int i = 1; i < l - 2; i++) {
            List<String> tempA = find(S.substring(1, i + 1));
            List<String> tempB = find(S.substring(i + 1,l - 1));

            //merge
            tempA.forEach((a) -> {
                tempB.forEach((b) -> {
                    res.add("(".concat(a).concat(", ").concat(b).concat(")"));
                });
            });
        }
        return res;
    }

    public List<String> find(String s) {
        int l = s.length();
        List<String> res = new ArrayList<>();
        //0XXX0
        if (l == 0 || (l > 1 && s.charAt(0) == '0' && s.charAt(l - 1) == '0')) {
            return res;
        }

        //0XXX
        if (l > 1 && s.charAt(0) == '0') {
            res.add("0.".concat(s.substring(1,l)));
            return res;
        }
        res.add(s);
        //X
        if (l == 1) {
            return res;
        }
        //XXX0
        if (s.charAt(l - 1) == '0') {
            return res;
        }

        for (int i = 1; i < l; i++) {
            res.add(s.substring(0,i).concat(".").concat(s.substring(i,l)));
        }
        return res;

    }
}
