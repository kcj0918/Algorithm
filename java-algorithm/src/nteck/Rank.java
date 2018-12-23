package nteck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Rank {
    public static void main(String[] args) {
        int[] grade = {3,2,1,3,2,2};
        int[] result = solution(grade);
        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    static int[] solution(int[] grade) {
        int[] result = new int[grade.length];
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < grade.length; i++) {
            students.add(new Student(i, grade[i]));
        }
        Collections.sort(students);

        int rank = 1;
        int score = students.get(0).score;
        for (int i = 0; i < grade.length; i++) {
            Student st = students.get(i);
            if (score == st.score) {
                students.get(i).rank = rank;
            } else {
                rank = i+1;
                score = students.get(i).score;
                students.get(i).rank = rank;
            }
        }
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.index < o2.index) {
                    return -1;
                } else if(o1.index > o2.index) {
                    return 1;
                }
                return 0;
            }
        });

        for(int i=0; i<grade.length; i++) {
            result[i] = students.get(i).rank;
        }
        return result;
    }
}

class Student implements Comparable<Student> {
    int index;
    int score;
    int rank;

    public Student(int index, int score) {
        this.index = index;
        this.score = score;
        this.rank = 0;
    }

    @Override
    public int compareTo(Student o) {
        if (this.score < o.score) {
            return 1;
        } else if (this.score > o.score) {
            return -1;
        }
        return 0;
    }
}
