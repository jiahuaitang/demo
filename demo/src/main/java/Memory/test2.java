package Memory;

/**
 * -Xss128k
 */
public class test2 {
    private int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        test2 oom = new test2();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e; }
    }
}
