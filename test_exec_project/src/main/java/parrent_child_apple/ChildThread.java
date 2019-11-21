package parrent_child_apple;

public class ChildThread extends Thread {
    private GlobalStorage globalStorage;

    public ChildThread(GlobalStorage globalStorage) {
        this.globalStorage = globalStorage;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Child: " + globalStorage.getValue());
                Thread.sleep(100);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
