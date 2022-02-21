package trees.tests.javacollectionsframework;

public class Person implements Comparable<Person>{
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Person p) {
        return this.name.compareToIgnoreCase(p.name);
        //It provides the natural ordering of this type of object being lexicographically
    }
}
