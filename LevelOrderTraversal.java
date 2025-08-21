//Time Complexity: O(n)
//Space Complexity: O(n)  // queue + output list in the worst case
//Did this code run in leetcode: Yes

//Approach - 
// 1. Use a queue for BFS; for each level, record the current queue size,
// 2. Pop exactly that many nodes, collect their values, and push their children;
// 3. Append each level’s list to the result.


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> levelList = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                levelList.add(node.val);

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            result.add(levelList);
        }
        return result;
    }
}
