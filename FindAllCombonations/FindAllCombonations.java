import java.util.*;

public class FindAllCombonations{

	public static void main(String[] args){

		int[] test = new int[]{1,2,3};
		List<List<Integer>> results = new LinkedList();
		findAllCombonations(test,0,results,new LinkedList<Integer>());
		System.out.println(results.toString());

	}

	/**
	*
	*	arr is the array we want to find combonations of
	*	index keeps track where in the array we are.
	*	results contains all of the sub arrays and arrays
	*	path keeps track of previously processed elements
	*
	*	The idea of the algorithm is we initially put an empty path list.
	*	Current copies path and adds whatever index is pointing to
	*	Then we recursively call with index+1 and we reuse path. This will exclude whatever current new number current has.
	*	We recursively call again with index+1 and now we use current for the path parameter. This includes the new number added to current.
	*
	*/

	private static void findAllCombonations(int[] arr, int index, List<List<Integer>> results, List<Integer> path){

		if(index == arr.length){ // break case: index is the size of the array add path and return

			results.add(path);
			return;

		}

		List<Integer> current = new LinkedList(path); // current makes copy of whatever is inside path
		current.add(arr[index]); // then we add whatever the index is currently pointing to.

		findAllCombonations(arr,index+1,results,path); //Find all combos that exclude the current arr[index]
		findAllCombonations(arr,index+1,results,current); //Find all combos that include current arr[index]

	}

	

}