package trees.tests.javacollectionsframework;

import java.util.TreeSet;

public class TestingTreeSet {
    public static void main(String[] args) {
        TreeSet<Person> people = new TreeSet<>();
        people.add(new Person("Jorge"));
        people.add(new Person("Lana"));
        people.add(new Person("Lara"));
        people.add(new Person("Marianna"));
        people.add(new Person("Lia"));
        people.add(new Person("Marshall"));
        people.add(new Person("James"));
        people.add(new Person("Rebecca"));
        people.add(new Person("Michael"));
        people.add(new Person("Bill"));
        System.out.println(people.contains(new Person("JAMES")));
        System.out.println(people.size());
        System.out.println(people.first());
        System.out.println(people.last());
        System.out.println(people.remove(new Person("JAMES")));
        System.out.println(people.contains(new Person("JAMES")));
        System.out.println(people.size());
    }
}
