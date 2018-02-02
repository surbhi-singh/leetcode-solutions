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
        String serialized = new String("");
        if(root == null) return serialized;
        else {
            List<String> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            Queue<TreeNode> res = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if(node == null) list.add(null);
                else {
                    list.add(Integer.toString(node.val));
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            while(list.get(list.size()-1) == null) list.remove(list.size()-1);
            serialized = String.join(",", list);
            return serialized;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        else {
            Queue<TreeNode> queue = new LinkedList<>();
            List<String> list = new ArrayList<>(Arrays.asList(data.split(",")));
            queue.offer(new TreeNode(Integer.parseInt(list.get(0))));
            TreeNode root = queue.peek();
            TreeNode curr = root;
            int i=1;
            while(i < list.size() && !queue.isEmpty()) {
                curr = queue.poll();
                if(i < list.size()) {
                    if(list.get(i).equals("null")) curr.left = null;
                    else curr.left = new TreeNode(Integer.parseInt(list.get(i)));
                    i++;
                }
                else break;
                if(curr.left != null) queue.offer(curr.left);
                if(i < list.size()) {
                    if(list.get(i).equals("null")) curr.right = null;
                    else curr.right = new TreeNode(Integer.parseInt(list.get(i)));
                    i++;
                }
                else break;
                if(curr.right != null) queue.offer(curr.right);
            }
            return root;
        }
    }
}
/*
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
        StringBuilder serialized = new StringBuilder("");
        if(root == null) return serialized.toString();
        else {
            buildString(root, serialized);
            return serialized.toString();
        }
    }
    private void buildString(TreeNode root, StringBuilder str) {
        if(root == null) str.append(null+",");
        else {
            str.append(root.val+",");
            buildString(root.left, str);
            buildString(root.right, str);
        }
    }

    private TreeNode buildTree(List<String> list) {
        String str = list.remove(0);
        if(str.equals("null")) return null;
        else {
            TreeNode root = new TreeNode(Integer.parseInt(str));
            root.left = buildTree(list);
            root.right = buildTree(list);
            return root;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        else {
            List<String> list = new ArrayList<>(Arrays.asList(data.split(",")));
            return buildTree(list);
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
*/
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
