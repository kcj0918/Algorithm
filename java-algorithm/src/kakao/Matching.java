package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matching {
    public static void main(String[] args) {
        String word = "blind";
        String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlindBlind Blind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>",
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>",
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
        int result = solution(word, pages);
        System.out.println(result);
        String[] pages1 = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.Muzi.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>",
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
//        int result1 = solution("Muzi", pages1);
//        System.out.println(result1);
    }

    static int solution(String word, String[] pages) {
        int result = 0;
        word = word.toLowerCase();
        List<Score> scores = new ArrayList<>();
        Map<Integer, List<String>> outerLinkMap = new HashMap<>();
        for (int i = 0; i < pages.length; i++) {
            String page = pages[i].toLowerCase();
            page = page.replaceAll("\n", " ");
            Pattern patternUrl = Pattern.compile("content=\"(.+?)\"/>");
            Matcher matcher = patternUrl.matcher(page);
            matcher.find();
            String url = matcher.group(1);

            Pattern patternBody = Pattern.compile("<body>(.+?)</body>");
            matcher = patternBody.matcher(page);
            matcher.find();
            String body = matcher.group(1).trim();

            Pattern patternOuterLink = Pattern.compile("<a href=\"(.+?)\"|<a href=\"(.+?)\">");
            matcher = patternOuterLink.matcher(body);
            List<String> outerUrls = new ArrayList<>();
            while (matcher.find()) {
                outerUrls.add(matcher.group(1));
            }
            outerLinkMap.put(i, outerUrls);
            body = body.replaceAll("[^(a-z)]", " ");
            String[] words = page.split(" {2,}| ");
            double baseScore = 0.0;
            for (String s : words) {
                if (s.equals(word)) {
                    baseScore++;
                }
            }
            scores.add(new Score(url, baseScore, outerUrls.size()));
        }

        for (int i = 0; i < pages.length; i++) {
            double linkScore = 0.0;
            for (int j = 0; j < pages.length; j++) {
                if (i != j) {
                    int size = outerLinkMap.get(j).size();
                    double currentLinkScore = 0.0;
                    for (int k = 0; k < size; k++) {
                        if(scores.get(i).url.equals(outerLinkMap.get(j).get(k))) {
                            currentLinkScore = scores.get(j).baseScore / scores.get(j).linkCount;
                        }
                    }
                    linkScore += currentLinkScore;
                }
            }
            scores.get(i).MatchingScore = scores.get(i).baseScore + linkScore;
            if(scores.get(result).MatchingScore < scores.get(i).MatchingScore) {
                result = i;
            }
        }

        return result;
    }
}

class Score {
    String url;
    double baseScore;
    double linkCount;
    double MatchingScore = 0.0;

    public Score(String url, double baseScore, double linkCount) {
        this.url = url;
        this.baseScore = baseScore;
        this.linkCount = linkCount;
    }
}
