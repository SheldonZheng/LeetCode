/**
 * LeetCode 969 Pancake Sorting
 */
class Solution {
    List<Integer> res = new LinkedList<>();

    public List<Integer> pancakeSort(int[] arr) {
        sort(arr,arr.length);
        return res;
    }

    public void sort(int[] cakes, int n) {
        if (n == 1) {
            return ;
        }
        int maxCake = 0;
        int maxCakeIndex = 0;
        for (int i = 0; i < n; i++) {
            if (cakes[i] > maxCake) {
                maxCake = cakes[i];
                maxCakeIndex = i;
            }
        }
        reverse(cakes,0,maxCakeIndex);
        reverse(cakes,0,n - 1);
        res.add(maxCakeIndex + 1);
        res.add(n);

        sort(cakes,n - 1);
    }

    public void reverse(int[] arr,int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

}
