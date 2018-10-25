package kakao;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpStatusCode {
    public static void main(String[] args) {
        String[] str = {
                "unicom6.unicomp.net - - [01/Jul/1995:00:00:06 -0400] \"GET /shuttle/contdown/test.gif HTTP/1.0\" 200 3985",
                "burger.letters.com - - [01/Jul/1995:00:00:06 -0400] \"GET /shuttle/contdown/liftoff.html HTTP/1.0\" 304 3985",
                "burget.letters.com - - [01/Jul/1995:00:00:06 -0400] \"GET /shuttle/contdown/liftoff.gif HTTP/1.0\" 304 3985",
                "burget.letters.com - - [01/Jul/1995:00:00:06 -0400] \"GET /shuttle/contdown/liftoff.gif HTTP/1.0\" 200 3985"
        };
        List<String> result = solution(str);
        for (String v : result) {
            System.out.println(v);
        }
    }

    static List<String> solution(String[] str) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            Pattern pattern1 = Pattern.compile("\"(.*?)$");
            Matcher matcher = pattern1.matcher(str[i]);
            matcher.find();
            String[] slice = matcher.group(0).toString().split(" ");
            if (slice[1].matches("^([\\S]+(\\.(gif))$)") && slice[3].matches("^200$")) {
                result.add(str[i]);
            }
        }
        return result;
    }
}
