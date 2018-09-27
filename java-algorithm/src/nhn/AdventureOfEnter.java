package nhn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    NHN Ent Mock Test
 */
public class AdventureOfEnter {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        List<String> result = solution(input);
        if (result.size() == 0) {
            System.out.println(0);
        } else {
            for (String value : result) {
                System.out.println(value);
            }
        }
    }

    static List<String> solution(String s) {
        String[] arr = s.split(" ");
        final int MAX_SIZE = 3;
        List<String> backpack = new ArrayList<>();
        List<String> dropList = new ArrayList<>();


        for (String item : arr) {
            if (!backpack.contains(item)) {
                backpack.add(item);
                if (backpack.size() > MAX_SIZE) {
                    dropList.add(backpack.remove(0));
                }
            } else {
                int size = backpack.size();
                for (int i = 0; i < size; i++) {
                    if (backpack.get(i).equals(item)) {
                        backpack.remove(backpack.get(i));
                        break;
                    }
                }
                backpack.add(item);
            }
        }
        return dropList;
    }
}
