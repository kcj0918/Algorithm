package zigzag;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AfterClock {
    public static void main(String[] args) {
        String P1 = "PM 01:00:00";
        int N1 = 10;
        String P2 = "PM 11:59:59";
        int N2 = 1;
        String P3 = "AM 12:10:00";
        int N3 = 40;

        String result1 = solution(P2, N2);
        System.out.println(result1);
    }

    static String solution(String p, int n) {
        int remainTime = n;
        StringBuilder sb = new StringBuilder();
        Pattern timePattern = Pattern.compile("([0-9]{2}):([0-9]{2}):([0-9]{2})");
        Matcher matcher = timePattern.matcher(p);
        matcher.find();
        String[] time = matcher.group(0).split(":");
        int plusHours = n / 3600;
        remainTime = remainTime - plusHours * 3600;
        int plusMinute = remainTime / 60;
        remainTime = remainTime - plusMinute * 60;
        int plusSecond = remainTime;

        int second = changeNumber(time[2]);
        second += plusSecond;
        int mok = second / 60;
        second = second % 60;
        plusMinute = plusMinute + mok;

        int minute = changeNumber(time[1]);
        minute += plusMinute;
        mok = minute / 60;
        minute = minute % 60;
        plusHours = plusHours + mok;

        int hours = changeNumber(time[0]);
        hours = hours + plusHours + 12;
        hours = hours % 24;

        String h = changeNumber(hours);
        String m = changeNumber(minute);
        String s = changeNumber(second);

        sb.append(h);
        sb.append(":");
        sb.append(m);
        sb.append(":");
        sb.append(s);

        return sb.toString();
    }

    static String changeNumber(int num) {
        String value = String.valueOf(num);
        if (value.length() == 1) {
            return "0" + value;
        }
        return value;
    }

    static int changeNumber(String num) {
        if (num.charAt(0) == 0) {
            return Integer.parseInt(String.valueOf(num.charAt(1)));
        }
        return Integer.parseInt(num);
    }

}
