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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serialize(root,"");
    }

    private String serialize(TreeNode root,String str) {
        if (root == null) {
            return str += "null,";
        } else {
            str += String.valueOf(root.val) + ",";
            str = serialize(root.left,str);
            str = serialize(root.right,str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] datas = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(datas));
        return deserialize(data_list);
    }
    
    private TreeNode deserialize(List<String> data) {
        if (data.get(0).equals("null")) {
            data.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(data.get(0)));
        data.remove(0);
        root.left = deserialize(data);
        root.right = deserialize(data);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
