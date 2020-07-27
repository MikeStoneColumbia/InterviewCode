import java.util.*;
public class AddToArrayFormOfInteger {

    public static void main(String[] args){

        System.out.println(addToArrayFrom(new int[]{9,9,9,9,9,9,9,9,9},1).toString());

    }

    private static List<Integer> addToArrayFrom(int[] A, int K){

        LinkedList<Integer> ans = new LinkedList<Integer>();
        int carry = K;

        for(int i = A.length-1; i >= 0; i--){
            int sum = carry + A[i]; // the idea here is that we find out how much K + a digit is
            ans.addFirst(sum % 10); // this is incase the digit overflows example like 11. 11 % 10 is 1
            carry = sum/10; // now we have a remaining carry of 1

        }

        while(carry != 0){
            ans.addFirst(carry % 10);
            carry /= 10;

        }

        return ans;

    }

}
