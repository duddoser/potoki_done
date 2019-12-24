package potoki;

public class MyThread extends Thread {
    private String message;
    public boolean flag = true; 
    MyThread(String m) {
        this.message = m;
    }

    @Override
    public void run() {
        while(flag) {
            Main.test(message);
        }
    }
}