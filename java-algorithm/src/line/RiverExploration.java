package line;

import java.util.*;

public class RiverExploration {
    public static void main(String[] args) {
        String river =
                "1 2 4 7\n" +
                        "3 4 7 9\n" +
                        "5 8 9\n" +
                        "6 8\n" +
                        "10 12 14\n" +
                        "11 12 14 17\n" +
                        "15 17\n" +
                        "13 16 17";

        String river2 =
                "3 8 11 12\n" +
                        "2 7 11\n" +
                        "1 6 7\n" +
                        "10 12\n" +
                        "3 8\n" +
                        "4 8 11\n" +
                        "5 9 11 12\n" +
                        "3 8 11";

        String river3 = "1 5 8 10\n" +
                "2 3 7";

        String result = solution(river);
        System.out.println("result : " + result);
    }

    static String solution(String river) {
        String[] explorationList = river.split("\n");
        List<Node> heads = new ArrayList<>();
        List<Node> tails = new ArrayList<>();

        for (int i = 0; i < explorationList.length; i++) {
            String[] oneExploration = explorationList[i].split(" ");
            Node head = new Node(Integer.parseInt(oneExploration[0]));
            heads.add(head);
            for (int j = 1; j < oneExploration.length; j++) {
                head.next = new Node(Integer.parseInt(oneExploration[j]));
                head = head.next;
                if (j == oneExploration.length - 1) {
                    tails.add(head);
                }
            }
        }
        boolean check = true;
        for (int i = 0; i < heads.size() - 1; i++) {
            if(check == false ) {
                break;
            }
            Node head1 = heads.get(i);
            for (int j = i + 1; j < heads.size(); j++) {
                if(check == false ) {
                    break;
                }
                if (heads.get(i).data <= tails.get(j).data ||
                        heads.get(j).data <= tails.get(i).data) {
                    while (head1 != null && check) {
                        Node head2 = heads.get(j);
                        while (head2 != null && check) {
                            if (head1.data == head2.data) {
                                if (head1.next == null) {
                                    head1.next = head2.next;
                                } else if (head2.next == null) {
                                    head2.next = head1.next;
                                } else if (head1.next.data != head2.next.data) {
                                    check = false;
                                    break;
                                } else {
                                    if (tails.get(i).data > tails.get(j).data) {
                                        head2.next = head1.next;
                                    } else {
                                        head1.next = head2.next;
                                    }
                                }
                            }
                            head2 = head2.next;
                        }
                        head1 = head1.next;
                    }
                    head1 = heads.get(i);
                } else {
                    break;
                }
            }
        }
        if (check == false) {
            return "-1";
        }
        Set<Integer> mySet = new HashSet<>();
        for(int i=0; i<heads.size(); i++) {
            Node node = heads.get(i);
            while(node != null) {
                System.out.print(node.data + " ");
                if(node.next == null) {
                    mySet.add(node.data);
                }
                node = node.next;
            }
            System.out.println();
        }
        List<Integer> result = new ArrayList<>(mySet);
        Collections.sort(result);
        StringBuilder sb = new StringBuilder("");
        for(int value : result) {
            sb.append(value).append(" ");
        }
        sb.toString().trim();
        return sb.toString();
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
