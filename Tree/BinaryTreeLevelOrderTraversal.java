import java.util.*;
public class BinaryTreeLevelOrderTraversal{

	public static void main(String[] args){

		 TreeNode root = new TreeNode(12);
   		 root.left = new TreeNode(7);
    	 root.right = new TreeNode(1);
    	 root.left.left = new TreeNode(9);
    	 root.right.left = new TreeNode(10);
    	 root.right.right = new TreeNode(5);
    	 List<List<Integer>> result = traverse(root);
    	 System.out.println("Level order traversal: " + result.toString());

	}

	public static List<List<Integer>> traverse(TreeNode root){

		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while(!q.isEmpty()){

			int level = q.size();
			List<Integer> vals = new ArrayList<>();

			for(int i = 0; i < level; i++){

				TreeNode n = q.poll();
				vals.add(n.val);
				
				if(n.left != null)
					q.offer(n.left);
				if(n.right != null)
					q.offer(n.right);

				
			}


			result.add(vals);

		}

		return result;

	}

}
