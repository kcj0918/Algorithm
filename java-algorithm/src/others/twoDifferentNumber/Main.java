package others.twoDifferentNumber;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] A = {5, 4, 4, 5, 0, 12};
//        int[] A = {4, 4, 4, 4, 4, 5};
//        int[] A = {4, 4, 4, 4, 4, 4};
        int result = solution(A);
        System.out.println(result);
    }
    static int solution(int[] A) {
        int count=0;
        int maxCount=0;
        for(int i=0; i<=A.length-2; i++) {
            for(int j=i+1; j<=A.length-1; j++) {
                Map<Integer, Integer> myMap = new HashMap<>();
                for(int k=i; k<=j-i; k++) {
                    myMap.put(A[k], 0);
                }
                if(myMap.size()==2 || myMap.size()==1) {
                    count = j-i+1;
                    if(count>maxCount) {
                        maxCount = count;
                    }
                }
                myMap.clear();
            }
        }
        return maxCount;
    }
}
