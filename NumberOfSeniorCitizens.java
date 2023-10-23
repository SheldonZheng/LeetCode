class Solution {
    public int countSeniors(String[] details) {
        return (int) Arrays.stream(details).filter(o -> o.substring(11, 13).compareTo("60") > 0).count();
    }
}
