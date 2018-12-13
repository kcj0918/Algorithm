package goormtest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemoSort {
    public static void main(String[] args) {
        String[] memo = {
                "2018/7/03 배민은행의 구조도를 손에 넣었다. 필요한 장비는 이런거 저런거 해서 각자 준비해야한다.",
                "타깃 은행은 12번지이고 잠실에 있는 배민은행으로 간다. 18년06월13일",
                "배민은행앞 별다방에서 18-06-12에 만나기로 함"
        };
        String[] result = solution(memo);
        for (String value : result) {
            System.out.println(value);
        }
    }

    static String[] solution(String[] memo) {
        int size = memo.length;
        String[] result = new String[size];
        List<Data> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Pattern datePattern = Pattern.compile("([0-9]{2,})[^0-9]([0-9]{1,2})[^0-9]([0-9]{1,2})");
            Matcher match = datePattern.matcher(memo[i]);
            if (match.find()) {
                String[] strDate = match.group(0).toString().split("[^0-9]");
                int year = (strDate[0].length() == 2) ?
                        Integer.parseInt("20" + strDate[0]) : Integer.parseInt(strDate[0]);
                int month = (strDate[1].charAt(0) == 0) ?
                        Integer.parseInt(String.valueOf(strDate[1].charAt(1))) : Integer.parseInt(strDate[1]);
                int day = (strDate[2].charAt(0) == 0) ?
                        Integer.parseInt(String.valueOf(strDate[2].charAt(1))) : Integer.parseInt(strDate[2]);
                list.add(new Data(memo[i], LocalDate.of(year, month, day)));
            }
        }
        Collections.sort(list);
        for (int i = 0; i < size; i++) {
            result[i] = list.get(i).memo;
        }
        return result;
    }
}

class Data implements Comparable<Data> {
    String memo;
    LocalDate date;

    public Data(String memo, LocalDate date) {
        this.memo = memo;
        this.date = date;
    }

    @Override
    public int compareTo(Data data) {
        return date.compareTo(data.date);
    }
}
