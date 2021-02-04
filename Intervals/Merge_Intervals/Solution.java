import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})));
    }

    public static int[][] merge(int[][] intervals){
        if(intervals.length <= 1){
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>(){
           public int compare(int[] a, int[] b){
               if(a[0] > b[0]){
                   return 1;
               }else if(a[0] < b[0]){
                   return -1;
               }
               return 0;
           } 
        });

        LinkedList<int[]> rows = new LinkedList<>();
        rows.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            merger(rows,intervals[i]);
        }

        return rows.toArray(new int[rows.size()][]);

    }

    public static void merger(LinkedList<int[]> rows, int[] row){
        if(rows.getLast()[0] <= row[0] && rows.getLast()[1] >= row[0]){
            rows.getLast()[1] = Math.max(row[1], rows.getLast()[1]);
        }else{
            rows.add(row);
        }
    }

}
