// LeetCode 904
class Solution {
     public int totalFruit(int[] tree) {
        int res = 0;
        if (tree == null || tree.length < 1) {
            return res;
        }
        if (tree.length < 3) {
            return tree.length;
        }
        Map<Integer,Integer> container = new HashMap<>();
        int i = 0; // left pointer
        int cur = 1;
        container.put(tree[0],1);
        for (int k = 1; k < tree.length; k++) {
            cur ++;
           /* if (container.containsKey(tree[k])) {
                Integer t = container.get(tree[k]);
                t += 1;
                container.put(tree[k],t);
            } else {
                container.put(tree[k],1);
            }*/
           container.put(tree[k],container.getOrDefault(tree[k],0) + 1);
            // left pointer go
            
            while (container.size() > 2) {
                container.put(tree[i],container.get(tree[i]) - 1);
                if (container.get(tree[i]) == 0) {
                    container.remove(tree[i]);
                }
                i++;
                cur--;
            }
            res = Math.max(cur,res);

        }
        return res;
    }

