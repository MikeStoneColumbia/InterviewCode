public class RangeSumBST{

	/*

	*Check if we have a null node and if we do return 0: This is our break case
	*If current value is within the range [L,R] then we need to check both left and right nodes
	*If val is smaller than L then we need to check the right node for a bigger val
	*If val is larger than R then we need to check the left node for a smaller val

	*/

	public static void main(String[] args){

	}

	public int  rangeSumBST(TreeNode root, int L, int R){

		if(root == null) // reach the end return 0
			return 0;

		if(root.val >= L){ // is in the left bound

			if(root.val <= R) // is also within the right bound
				return root.val + rangeSumBST(root.left,L,R) + rangeSumBST(root.right,L,R); //return sum of both sides

			else
				return rangeSumBST(root.left,L,R); // val is too big need to check a smaller val

		}else
			return rangeSumBST(root.right,L,R); // val is too small find a bigger val

	}

}
