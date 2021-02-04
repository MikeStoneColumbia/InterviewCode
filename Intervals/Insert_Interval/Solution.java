import java.util.Arrays;
import java.util.LinkedList;

public class Solution{
    public static void main(String[] args){
        System.out.println(Arrays.deepToString(insert(new int[][]{{1,3},{6,9}},new int[]{2,5})));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval){
        if(intervals.length == 0 || intervals[0].length == 0){
            return intervals;
        }

        LinkedList<int[]> rows = new LinkedList<>();
        int i = 0;
        for(; i < intervals.length; i++){
            if(intervals[i][0] < newInterval[0]){
                rows.add(intervals[i]);
            }else{
                break;
            }
        }

        merge(rows,newInterval);

        for(; i < intervals.length; i++){
            merge(rows,intervals[i]);
        }

        return rows.toArray(new int[rows.size()][]);
    }


    public static void merge(LinkedList<int[]> rows, int[] newInterval){
        if(rows.isEmpty() || rows.getLast()[1] < newInterval[0]){
            rows.add(newInterval);
        }else{
            rows.getLast()[1] = Math.max(rows.getLast()[1], newInterval[1]);
        }
    }

}