package trees.tests.javacollectionsframework;

import java.util.TreeMap;
//TreeMap is a collection that does hard use of a red-black tree
//as the underlying data structure to improve performance on
//all operations that handle the data.

public class TestingTreeMap {
    public static void main(String[] args) {
        TreeMap<Integer, Person> people = new TreeMap<>();
        people.put(100, new Person("Jorge"));
        people.put(98, new Person("Lana"));
        people.put(14, new Person("Lara"));
        people.put(16, new Person("Marianna"));
        people.put(678, new Person("Lia"));
        people.put(44, new Person("Marshall"));
        people.put(19, new Person("James"));
        people.put(1, new Person("Rebecca"));
        people.put(99, new Person("Michael"));
        people.put(445, new Person("Bill"));
        people.forEach((k, v) -> System.out.println(v));
        System.out.println(people.size());
        System.out.println(people.get(678));
    }
}
