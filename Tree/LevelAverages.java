import java.util.*;
public class LevelAverages{

	public static void main(String[] args){

		 TreeNode root = new TreeNode(12);
    	 root.left = new TreeNode(7);
    	 root.right = new TreeNode(1);
    	 root.left.left = new TreeNode(9);
    	 root.right.left = new TreeNode(10);
    	 root.right.right = new TreeNode(5);
    	 List<Double> result = traverse(root);
    	 System.out.println("Level averages: " + result);

	}

	public static List<Double> traverse(TreeNode root){

		List<Double> result = new LinkedList<>();
		if(root == null)
			return result;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		double avg = 0.0;

		while(!q.isEmpty()){

			double level = q.size();

			for(int i = 0; i < level; i++){

				TreeNode n = q.poll();
				avg += n.val;

				if(n.left != null)
					q.offer(n.left);
				if(n.right != null)
					q.offer(n.right);

			}

			result.add(avg/level);
			avg = 0.0;

		}

		return result;

	}

}