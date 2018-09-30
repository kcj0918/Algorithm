package nhn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DisplayBoardRotation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        int matrix_size = Integer.parseInt(arr[0]);
        int rotation_count = Integer.parseInt(arr[1]);
        String[][] names = new String[matrix_size][matrix_size];
        for (int i = 0; i < matrix_size; i++) {
            String[] myList = br.readLine().split(" ");
            for (int j = 0; j < matrix_size; j++) {
                names[i][j] = myList[j];
            }
        }

        String[][] result = solution(names, matrix_size, rotation_count);
        System.out.println();

        for (int i = 0; i < matrix_size; i++) {
            for (int j = 0; j < matrix_size; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static String[][] solution(String[][] names, int matrix_size, int rotation_count) {
        String[][] answer = new String[matrix_size][matrix_size];
        int cycle_count;
        if (matrix_size % 2 == 0) {
            cycle_count = matrix_size / 2;
        } else {
            cycle_count = (matrix_size / 2) + 1;
        }
        int current_size = matrix_size;
        for (int i = 0; i < cycle_count; i++) {
            int x = i;
            int y = i;
            String[] arr = rotation(names, x, y, current_size, rotation_count);
            int arr_index = 0;

            if(arr.length == 1) {
                answer[i][i] = arr[0];
            } else {
                do {
                    if (x == i && y == i) {
                        for (int j = i; j < current_size -1; j++) {
                            answer[x][j] = arr[arr_index];
                            arr_index++;
                        }
                        y = current_size - 1;
                    } else if (x == i && y == current_size - 1) {
                        for (int j = i; j < current_size-1; j++) {
                            answer[j][y] = arr[arr_index];
                            arr_index++;
                        }
                        x = current_size - 1;
                    } else if (x == current_size - 1 && y == current_size - 1) {
                        for (int j = current_size - 1; j > i; j--) {
                            answer[x][j] = arr[arr_index];
                            arr_index++;
                        }
                        y = i;
                    } else if (x == current_size - 1 && y == i) {
                        for (int j = current_size - 1; j > i; j--) {
                            answer[j][y] = arr[arr_index];
                            arr_index++;
                        }
                        x = i;
                    }
                } while (!(x == i && y == i));
            }
            current_size--;
            rotation_count *= -1;
        }
        return answer;
    }

    static String[] rotation(String[][] names, int startX, int startY, int matrix_size, int rotation_count) {
        List<String> myList = new ArrayList<>();
        int x = startX;
        int y = startY;
        int x_max = matrix_size - 1;
        int y_max = matrix_size - 1;
        do {
            if (x == startX && y == startY) {
                for (int i = startY; i < y_max; i++) {
                    myList.add(names[startX][i]);
                }
                y = y_max;
            } else if (x == startX && y == y_max) {
                for (int i = startX; i < y_max; i++) {
                    myList.add(names[i][y_max]);
                }
                x = x_max;
            } else if (x == x_max && y == y_max) {
                for (int i = y_max; i > startY; i--) {
                    myList.add(names[x_max][i]);
                }
                y = startY;
            } else if (x == x_max && y == startY) {
                for (int i = x_max; i > startX; i--) {
                    myList.add(names[i][startY]);
                }
                x = startX;
            }
        } while (!(x == startX && y == startY));

        String[] result = new String[myList.size()];
        if (result.length == 0) {
            result = new String[1];
            result[0] = names[startX][startY];
            return result;
        }

        int totalNum = (matrix_size - 1) * 4;
        int rotationNum = Math.abs(rotation_count) % totalNum;

        if (rotation_count < 0) {
            for (int i = 0; i < rotationNum; i++) {
                String name = myList.remove(0);
                myList.add(name);
            }
        } else if (rotation_count > 0) {
            for (int i = 0; i < rotationNum; i++) {
                String name = myList.remove(myList.size() - 1);
                myList.add(0, name);
            }
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = myList.get(i);
        }
        return result;
    }
}
