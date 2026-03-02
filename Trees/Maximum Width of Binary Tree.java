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
 class Pair{
    TreeNode node;
    long index;

    Pair(TreeNode node, long index){
        this.node = node;
        this.index = index;
    }

 }

class Solution {
    public int widthOfBinaryTree(TreeNode root) {

        if(root == null) return 0;
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root,0));
        int maxWidth = 0;

        while(!q.isEmpty()){
            int size = q.size();
            long first = 0;
            long last = 0; 

            for(int i=0;i<size;i++){
                Pair p = q.poll();
                TreeNode curr = p.node;
                long index = p.index;

                if(i==0){
                    first = index;
                }
                if(i == size-1){
                    last = index;
                }

                if(curr.left != null){
                    q.offer(new Pair(curr.left, 2*index));
                }
                if(curr.right != null){
                    q.offer(new Pair(curr.right, 2*index+1));
                }
            }

            maxWidth = Math.max(maxWidth, (int)(last-first+1));

        }

        return maxWidth;
        
    }
}
