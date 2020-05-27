import java.util.*;
public class FindCommonCharacters{

    //I Struggled with this one. It is a good problem that makes use of some cool String and char
    //tricks

    public static void main(String[] args){

        System.out.println(findCommonCharacters(new String[]{"bella","label","roller"}).toString());

    }

    private static List<String> findCommonCharacters(String[] A){

        List<String> ans = new ArrayList();
        int[] minCharFreq = new int[26]; //the idea here is we have 26 letters. Find out min freq
        Arrays.fill(minCharFreq,Integer.MAX_VALUE);//we are looking for mins

        for(String currStr: A){
            int[] charFreq = new int[26]; // holds the # of times each char appers in all words
            //notice charFreq gets reset after each loop

            for(char c: currStr.toCharArray())// make each word into char array and loop    
                charFreq[c-'a']++; //clever trick a-a = 0, b-a = 1, c-a = 2 etc
             
             for(int i = 0; i < 26; i++)//we do this for each word
                 minCharFreq[i] = Math.min(minCharFreq[i],charFreq[i]); //store min freq found
        }

        for(int i = 0; i < 26; i++){// figure out which letters belong in the ans
            while(minCharFreq[i] > 0){//if freq is 0 no need to add it
                ans.add("" + (char)(i+'a'));// this handles duplicates
                minCharFreq[i]--;
                
            }

        }

        return ans;

    }

}
