package exercises;

public class Test {
    public static void main(String[] args) {
        Obj obj1 = new Obj();
        obj1.value = 1000;
        change(obj1);
        System.out.println(obj1.value);
    }

    private static void change(Obj object) {
        Obj newObj = new Obj();
        newObj.value = 100;
        object = newObj;
    }
}
