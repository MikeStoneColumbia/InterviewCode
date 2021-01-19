import java.util.*;
public class CourseScheduleII{

	/*

		Very similar to Course Schedule but now you must return an arr of classes

	*/

	public static void main(String[] args){

		int[][] courses = new int[4][2];
		courses[0][0] = 1;
		courses[0][1] = 0;
		courses[1][0] = 2;
		courses[1][1] = 1;
		courses[2][0] = 3;
		courses[2][1] = 1;
		courses[3][0] = 4;
		courses[3][1] = 3;

		System.out.println(Arrays.toString(findOrder(5,courses)));

	}


	public static int[] findOrder(int numCourses, int[][] preReqs){

		int[] inDegree = new int[numCourses];
		Stack<Integer> stack = new Stack<>();
		int[] results = new int[numCourses];
		int count = 0;

		for(int i = 0; i < preReqs.length; i++){

			inDegree[preReqs[i][0]]++;

		}

		for(int i = 0; i < inDegree.length; i++){
			if(inDegree[i] == 0)
				stack.push(i);
		}

		while(!stack.isEmpty()){

			int curr = stack.pop();
			results[count++] = curr;

			for(int i = 0; i < preReqs.length; i++){

				if(preReqs[i][1] == curr){

					inDegree[preReqs[i][0]]--;
					if(inDegree[preReqs[i][0]] == 0)
						stack.push(preReqs[i][0]);

				}

			}

		}

		return count == numCourses ? results : new int[0];

	}


}