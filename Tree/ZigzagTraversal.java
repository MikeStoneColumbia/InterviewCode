import java.util.*;
public class ZigzagTraversal{

	public static void main(String[] args){

		 TreeNode root = new TreeNode(12);
    	 root.left = new TreeNode(7);
    	 root.right = new TreeNode(1);
    	 root.left.left = new TreeNode(9);
    	 root.right.left = new TreeNode(10);
    	 root.right.right = new TreeNode(5);
    	 List<List<Integer>> result = traverse(root);
    	 System.out.println("Zigzag order traversal: " + result);

	}

	public static List<List<Integer>> traverse(TreeNode root){

		List<List<Integer>> result = new LinkedList<>();
		if(root == null)
			return result;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		boolean right = false;

		while(!q.isEmpty()){

			int level = q.size();
			List<Integer> vals = new LinkedList<>();

			for(int i = 0; i < level; i++){

				TreeNode n = q.poll();

				if(right)
					vals.add(0,n.val);
				else
					vals.add(n.val);

				if(n.right != null)
					q.offer(n.right);
				if(n.left != null)
					q.offer(n.left);


			}

			result.add(vals);
			right = !right;

		}

		return result;

	}

}