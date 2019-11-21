package parrent_child_apple;

public class ChildParentAppleTest {
    public static void main(String[] args) {
        GlobalStorage globalStorage = new GlobalStorage();
        new ParentThread(globalStorage).start();
        new ChildThread(globalStorage).start();
    }
}
