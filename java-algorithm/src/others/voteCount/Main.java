package others.voteCount;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] votes = {
                "Victor",
                "Veronica",
                "Ryan",
                "Dave",
                "Maria",
                "Maria",
                "Farah",
                "Farah",
                "Ryan",
                "Veronica"};

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (String name : votes) {
            if (map.get(name) == null) {
                map.put(name, 1);
            } else {
                map.put(name, map.get(name) + 1);
            }
        }

        List<Person> array = new ArrayList<>();
        Set setOfKey = map.keySet();
        Iterator it = setOfKey.iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            Integer value = map.get(key);
            array.add(new Person(key, value));
        }
        Collections.sort(array, new AscendingObj());

        List<Person> resultPerson = new ArrayList<Person>();
        resultPerson.add(new Person(array.get(0).name,
                array.get(0).voteNum));
        int compareIndex = 1;
        while (true) {
            if (array.get(0).getVoteNum() == array.get(compareIndex).getVoteNum()) {
                resultPerson.add(new Person(array.get(compareIndex).name,
                        array.get(compareIndex).voteNum));
                compareIndex++;
                if(compareIndex == array.size()) {
                    break;
                }
            } else {
                break;
            }
        }
        for (Person p : resultPerson) {
            System.out.println("result : " + p.getName() + " : " + p.getVoteNum());
        }
    }
}
class Person {
    String name;
    Integer voteNum;

    public Person() {
        super();
    }

    public Person(String name, Integer voteNum) {
        this.name = name;
        this.voteNum = voteNum;
    }

    public String getName() {
        return name;
    }

    public Integer getVoteNum() {
        return voteNum;
    }
}

class AscendingObj implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if(p1.getVoteNum() == p2.getVoteNum()) {
            return p1.getName().compareTo(p2.getName());
        }
        return p2.getVoteNum().compareTo(p1.getVoteNum());
    }
}
