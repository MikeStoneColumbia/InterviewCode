import java.util.*; 
public class BinaryPrefixDivisableBy5 {

    //Given an araay of 1's and 0's find out if the ith subarray is divisable by 5 [0,1,0,1] would return {true,false,false,true}

    public static void main(String[] args){

        System.out.println(binaryPrefixDivisableBy5(new int[]{0,1,1,1,1,1}).toString());

    }

    public static List<Boolean> binaryPrefixDivisableBy5(int[] A){

        List<Boolean> ans = new ArrayList();
        int start = A[0];

        ans.add(start == 0 ? true : false); // check to see if the first element is 1 or 0

        for(int i = 1; i < A.length; i++){

            start = A[i] == 1 ? start *2 + 1: start * 2; // if A[i] that means we multiply whatever we have by 2 and add one [0,1,1]. Start is first 0. we encounter 01 0 * 2 + 1 = 1. 
            // we encounter another 1 hence 1 * 2 + 1 = 3. If we encounter 0 we are just shifting everything over to the left. [0,1,1,0] 011 is 3 0110 is 6

            ans.add(start % 5 == 0 ? true : false);
            start %= 5; // this helps us avoid overflow

        }

        return ans;

    }

}
