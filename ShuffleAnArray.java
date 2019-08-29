/**
 * LeetCode 384 Shuffle an Array
 */
class Solution {

    int []source;
    int []shuffle;

    private Random random = new Random();

    public Solution(int[] nums) {
        source = nums;
        shuffle = nums.clone();

    }

    private int randRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = shuffle[i];
        shuffle[i] = shuffle[j];
        shuffle[j] = temp;
    }


    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return source;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < shuffle.length; i++) {
            swapAt(i,randRange(i,shuffle.length));
        }
        return shuffle;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
