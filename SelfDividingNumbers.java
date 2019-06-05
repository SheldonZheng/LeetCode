class Solution {
 public List<Integer> selfDividingNumbers(int left, int right) {
        if (left < 0 || right < 0 || right < left) {
            return null;
        }
        List<Integer> result = new ArrayList<>(20);
        for (int i = left;i <= right;i++) {
            int temp = i;
            boolean r = true;
            while (temp > 0) {
                int num = temp % 10;
                if (num == 0) {
                    r = false;
                    break;
                }
                if (i % num != 0) {
                    r = false;
                    break;
                }
                temp = temp / 10;
            }
            if (r) {
                result.add(i);
            }
        }
        return result;
    }
}
