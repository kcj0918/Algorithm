package others.maxDistance;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args){
        int result = solution(1,1,2,3);
        System.out.println(result);
    }
    static int solution(int A, int B, int C, int D) {
        int result=0;
        ArrayList<Integer> array = new ArrayList<>();
        array.add(A);
        array.add(B);
        array.add(C);
        array.add(D);
        Collections.sort(array);

        result = ((array.get(0) - array.get(2))*(array.get(0) - array.get(2))) + ((array.get(1) - array.get(3))*(array.get(1) - array.get(3)));

        return result;
    }
}
