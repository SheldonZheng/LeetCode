/**
 * LeetCode 1095 Find in Mountain Array
 */
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        if (mountainArr == null || mountainArr.length() < 3) {
            return -1;
        }
        int top = findMoutaintop(mountainArr,0,mountainArr.length() - 1);
        int res = findTargetInSorted(mountainArr,0,top,target);
        if (res != -1) {
            return res;
        } else {
            return findTargetInInversed(mountainArr,top,mountainArr.length() - 1,target);
        }
    }

    private int findMoutaintop(MountainArray mountainArray,int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (mountainArray.get(mid) < mountainArray.get(mid + 1)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private int findTargetInSorted(MountainArray mountainArray,int l,int r,int target) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (mountainArray.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (mountainArray.get(l) == target) {
            return l;
        }
        return -1;
    }

    private int findTargetInInversed(MountainArray mountainArray,int l,int r,int target) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (mountainArray.get(mid) > target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (mountainArray.get(l) == target) {
            return l;
        }
        return -1;
    }
}
