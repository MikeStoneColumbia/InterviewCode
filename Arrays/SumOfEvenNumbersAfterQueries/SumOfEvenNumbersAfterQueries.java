public class SumOfEvenNumbersAfterQueries{

    public static void main(String[] args){
       
       int[] response = sumEvenAfterQueries(new int[] {1,2,3,4}, new int[][] {{1,0},{-3,1},{-4,0},{2,3}});
       System.out.println('[');
       for(int i = 0; i < response.length; i++)
           System.out.print(" " + response[i]);
       System.out.println(" ]");

     }

     private static int[] sumEvenAfterQueries(int[] A, int[][] queries){

        int evenSum = 0;
        int[] ans = new int[queries.length];

        for(int i = 0; i < A.length; i++){
            if(A[i] % 2 == 0)
                evenSum += A[i]; // find the sum of even numbers before any modifications
        }

         for(int row = 0; row < queries.length; row++){

                if(A[queries[row][1]] % 2 == 0)
                    evenSum -= A[queries[row][1]]; // if the index we are currently checking is even remove it from the sum

                 A[queries[row][1]] += queries[row][0]; // quries[i][0] has the value we will ad to A[queries[i][1]]

                 if(A[queries[row][1]] % 2 == 0) //We are checking to see if after adding the value if A[queries[i][1]] is now even
                     evenSum += A[queries[row][1]];
                 
                 ans[row] = evenSum;

          }

          return ans;

     }

}
