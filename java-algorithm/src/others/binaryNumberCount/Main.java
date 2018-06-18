package others.binaryNumberCount;

public class Main {
    public static void main(String[] args) {
        int A = 3;
        int B = 7;

        int result = solution(A, B);
        System.out.println(result);
    }

    static int solution(int A, int B) {
        int result = 0;
        String binaryNumber = Integer.toBinaryString(A * B);
        String[] myArray = new String[binaryNumber.length()];
        for(int i=0; i<myArray.length; i++) {
            myArray[i] = Character.toString(binaryNumber.charAt(i));
            if(myArray[i].equals("1")) {
                result++;
            }
        }
        return result;
    }
}
