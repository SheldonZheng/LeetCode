/**
 * LeetCode 914 X of a Kind in a Deck of Cards
 */
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length < 2) {
            return false;
        }
        Map<Integer,Integer> container = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            int c = container.getOrDefault(deck[i],0);
            c++;
            container.put(deck[i],c);
        }
        int baseLine = -1;
        for (Map.Entry<Integer, Integer> entry : container.entrySet()) {
            if (entry.getValue() < 2) {
                return false;
            }
            if (baseLine == -1) {
                baseLine = entry.getValue();
            } else {
                baseLine = gcd(baseLine,entry.getValue());
            }

        }
        return baseLine >= 2;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y%x, x);
    }
}
