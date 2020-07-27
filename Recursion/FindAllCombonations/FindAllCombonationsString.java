import java.util.*;

public class FindAllCombonationsString{

	public static void main(String[] args){

		String name = "racecar";
		List<String> results = new LinkedList<>();
		findAllCombonationsString(name,0,results,"");
		System.out.println(results.toString());


	}

	private static void findAllCombonationsString(String s, int index, List<String> results, String path){

		if(index == s.length()){

			results.add(path);
			return;

		}

		String curr = path;
		curr += s.substring(index, index+1);

		findAllCombonationsString(s,index+1,results,path);
		findAllCombonationsString(s,index+1,results,curr);

	}


}