package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Open {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        //Prodo님이 들어왔습니다., Ryan님이 들어왔습니다., Prodo님이 나갔습니다., Prodo님이 들어왔습니다.

        String[] result = solution(record);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> user = new HashMap<>();
        List<String> myList = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < record.length; i++) {
            String[] list = record[i].split(" ");
            if (list[0].equals("Enter")) {
                user.put(list[1], list[2]);
                myList.add("Enter");
                myList.add(list[1]);
                myList.add(list[2]);
                count++;
            }
            if (list[0].equals("Leave")) {
                myList.add("Leave");
                myList.add(list[1]);
                myList.add(user.get(list[1]));
                count++;
            }
            if (list[0].equals("Change")) {
                String uid = list[1];
                int size = myList.size();
                for (int j = 1; j < size; j+=3) {
                    if (myList.get(j).equals(uid)) {
                        user.put(uid, list[2]);
                        myList.set(j + 1, list[2]);
                    }
                }
            }
        }
        int size = myList.size();
        int index = 0;
        answer = new String[count];
        for (int i = 0; i < size; i+=3) {
            String result = "";
            if (myList.get(i).equals("Enter")) {
                result = user.get(myList.get(i + 1)) + "님이 들어왔습니다.";
                answer[index] = result;
                index++;
            }
            else {
                result = user.get(myList.get(i + 1)) + "님이 나갔습니다.";
                answer[index] = result;
                index++;
            }
        }
        return answer;
    }
}

