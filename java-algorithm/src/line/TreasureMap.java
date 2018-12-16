package line;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreasureMap {
    public static void main(String[] args) {
        String map1 = "F1 B1 R1 L2 F1 F1 L2 L1 L2 F1 F1 B1 B1 L2 F1 F1 L2 R1 L2 F1 L3 L1 B2 L3 B1";
        String map2 = "F4 B1 R1 L2 F1 F1 R1 R1 R1 F1 F1 R1 F1 R1 L2 F1 R1 R1 R1 F1 L4 L1 B2 R3 L2";
        int n = 5;
        guide = new HashMap<>();
        guide.put("FF", "F");
        guide.put("FR", "R");
        guide.put("FL", "L");
        guide.put("FB", "B");
        guide.put("RF", "R");
        guide.put("RR", "B");
        guide.put("RL", "F");
        guide.put("RB", "L");
        guide.put("LF", "L");
        guide.put("LR", "F");
        guide.put("LL", "B");
        guide.put("LB", "R");
        guide.put("BF", "B");
        guide.put("BR", "L");
        guide.put("BL", "R");
        guide.put("BB", "F");
        String result = solution(map2, n);
        System.out.println(result);
    }

    static String solution(String mapInfo, int n) {
        visit = new boolean[n][n];
        String[][] map = new String[n][n];
        int index = 0;
        String[] info = mapInfo.split(" ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = info[index];
                index++;
            }
        }

        int x = 0;
        int y = 0;
        while (visit[x][y] == false) {
            Pattern nodeInfoPattern = Pattern.compile("[A-Z]");
            Matcher matcher = nodeInfoPattern.matcher(map[x][y]);
            matcher.find();
            String nodeInfo = matcher.group(0);
            int gravity = Integer.parseInt(map[x][y].replace(nodeInfo, ""));
            visit[x][y] = true;
            currentDirection = guide.get(currentDirection + nodeInfo);
            if (currentDirection.equals("F")) {
                x -= gravity;
            } else if (currentDirection.equals("B")) {
                x += gravity;
            } else if (currentDirection.equals("L")) {
                y -= gravity;
            } else {
                y += gravity;
            }
            if (visit[x][y] == true) {
                break;
            }
        }
        return y + " " + x;
    }

    static String currentDirection = "B";
    static boolean[][] visit;
    static Map<String, String> guide;
}
