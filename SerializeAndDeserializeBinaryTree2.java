/**
 * LeetCode 297 Serialize and Deserialize Binary Tree
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        reserialize(root,result);
        return result.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return redeserialize(dataList);
    }

    public StringBuilder reserialize(TreeNode root,StringBuilder str) {
        if (root == null) {
            str.append( "None,");
        } else {
            str.append( String.valueOf(root.val)).append( ",");
            str = reserialize(root.left,str);
            str = reserialize(root.right,str);
        }
        return str;
    }

    public TreeNode redeserialize(List<String> dataList) {
        if (dataList == null || dataList.size() == 0 || dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = redeserialize(dataList);
        root.right = redeserialize(dataList);

        return root;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
