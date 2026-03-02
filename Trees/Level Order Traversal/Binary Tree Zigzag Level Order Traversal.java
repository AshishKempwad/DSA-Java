/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> res = new ArrayList<>();

        boolean leftToRight = true;

        while(!q.isEmpty()){
            int size = q.size();
            Deque<Integer> dq = new ArrayDeque<>();

            for(int i=0;i<size;i++){
                 TreeNode curr = q.poll();

                 if(leftToRight){
                    dq.addLast(curr.val);
                 }else{
                    dq.addFirst(curr.val);
                 }

                 if(curr.left != null){
                    q.offer(curr.left);
                 }

                 if(curr.right != null){
                    q.offer(curr.right);
                 }
            }

            res.add(new ArrayList<>(dq));
            leftToRight = !leftToRight;
        }

        return res;

    }
}
