/**
 * LeetCode 990 Satisfiabillity of Equality Equations
 */
class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int num1 = str.charAt(0) - 'a';
                int num2 = str.charAt(3) - 'a';
                union(parent,num1,num2);
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int num1 = str.charAt(0) - 'a';
                int num2 = str.charAt(3) - 'a';
                if (find(parent,num1) == find(parent,num2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void union(int[] parent,int index1,int index2) {
        parent[find(parent,index1)] = find(parent,index2);
    }

    public int find(int[] parent,int index) {
        while (parent[index] != index) {
            return find(parent,parent[index]);
        }
        return index;
    }
}
