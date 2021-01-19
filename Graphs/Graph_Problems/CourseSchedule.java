import java.util.*;

public class CourseSchedule{

	/*

		Given a matrix of courses find out if it is possible to take all courses.
		Courses will have ids from 0 to numCourses-1.
		[1,0] -> implies you must take course 0 to take course 1
		[[1,0], [0,1]] -> this implies 0 is a pre-req for class 1 and 1 is a pre-req for class 0. This is not possible

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

		System.out.println(canFinish(5,courses));


	}

	/*

		Find the indegree for each class.
		Using this indegree attemp to create a top-sort of the edges
		If our topsort contains numCourses then we return true
		otherwise return false

	*/

	public static boolean canFinish(int numCourses, int[][] preReqs){

		int count = 0;
		int[] indegree = new int[numCourses];
		Stack<Integer> stack = new Stack<>();

		for(int i = 0; i < preReqs.length; i++)
			indegree[preReqs[i][0]]++;

		for(int i = 0; i < indegree.length; i++){
			if(indegree[i] == 0)
				stack.push(i);
		}

		while(!stack.isEmpty()){

			int curr = stack.pop();
			count++;

			for(int i =0; i <preReqs.length; i++){

				if(preReqs[i][1] == curr){

					indegree[preReqs[i][0]]--;

					if(indegree[preReqs[i][0]] == 0)
						stack.push(preReqs[i][0]);

				}

			}

		}

		return count == numCourses;
		

	}

}