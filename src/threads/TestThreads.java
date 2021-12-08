package threads;

public class TestThreads {
    public static void main(String[] args) {
        op("sub");
    }

    private static void op(String type) {
        switch(type.toUpperCase()) {
            case "SUM" -> new Thread(new MathSum()).start();
            case "SUB" -> new Thread(new MathSub()).start();
        }
    }
}
