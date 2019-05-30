/**
 * LeetCode Permutation in String 567
 */

 public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null)
            return false;
        if (s1.length() == 0) {
            return true;
        }
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] ba = new int[26];
        int[] slideArray = new int[26];

        int slideWidth = s1.length();

        int slideS = 0;
        int slideE = slideWidth;

        //init ba
        for (int i = 0; i < s1.length(); i++) {
            ba[s1.charAt(i) - 'a']++;
        }

        //init sideArray
        for (int i = 0; i < s1.length(); i++) {
            slideArray[s2.charAt(i) - 'a']++;
        }

        if (isEqual(ba,slideArray)) {
            return true;
        }

        while (slideE < s2.length()) {
            slideArray[s2.charAt(slideS) - 'a']--;
            slideArray[s2.charAt(slideE) - 'a']++;
            //iteration
            slideS++;
            slideE++;
            if (isEqual(ba,slideArray)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEqual(int[] a,int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
