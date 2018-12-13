package line;

import java.util.HashMap;
import java.util.Map;

public class HttpRestAPI {
    public static void main(String[] args) {
        String[] requests = {
                "POST /users/CONY",
                "POST /users/BROWN",
                "POST /users/CONY/data value=WHERE_IS_SALLY",
                "GET /users/CONY/data",
                "GET /users/BROWN/data",
                "GET /users/EDWARD/data",
                "GET /abc",
                "GET /users/CONY"
        };
        String[] result = solution(requests);
        for (String value : result) {
            System.out.println(value);
        }
    }

    static String[] solution(String[] requests) {
        Map<String, String> users = new HashMap<>();
        String[] responses = new String[requests.length];
        for (int i = 0; i < requests.length; i++) {
            String[] slice = requests[i].split(" "); // "GET" "/users/CONY/data" "value=WHERE_IS_SALLY"
            if (slice[0].equals("POST")) {
                String[] url = slice[1].split("/"); //"" "users" "CONY" "data"
                if (url[1].equals("users")) {
                    if (slice.length == 2) {
                        if (users.containsKey(url[2])) {
                            responses[i] = "403 FORBIDDEN"; // 존재하는 사용자를 또 삽입하려고 할 시
                        } else {
                            users.put(url[2], "");
                            responses[i] = "201 CREATED"; // 사용자 생성 성공
                        }
                    } else {
                        if (users.containsKey(url[2])) {
                            String[] value = slice[2].split("="); // "value" "WHERE_IS_SALLY"
                            if (url[3].equals("data") && value[0].equals("value")) {
                                users.put(url[2], value[1]);
                                responses[i] = "200 OK"; // 사용자 데이터 저장 성공
                            } else {
                                responses[i] = "405 METHOD_NOT_ALLOWED"; // DATA 삽입 시도시 잘못된 url 형식
                            }
                        } else {
                            responses[i] = "403 FORBIDDEN"; // 존재하지 않는 사용자 데이터 삽입하려고 할 경우
                        }
                    }
                } else {
                    responses[i] = "404 NOT_FOUND";
                }
            } else {
                String[] url = slice[1].split("/");
                if (url[1].equals("users")) {
                    if (url.length == 4) {
                        if (url[3].equals("data") && users.containsKey(url[2])) {
                            if (users.get(url[2]).equals("")) {
                                responses[i] = "404 NOT_FOUND";
                            } else {
                                responses[i] = "200 OK " + users.get(url[2]);
                            }
                        } else {
                            responses[i] = "403 FORBIDDEN";
                        }
                    } else {
                        responses[i] = "405 METHOD_NOT_ALLOWED"; // 지원하지 않는 METHOD 호출
                    }
                } else {
                    responses[i] = "404 NOT_FOUND";
                }
            }
        }
        return responses;
    }
}
