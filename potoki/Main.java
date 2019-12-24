package potoki;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception{
    	BankAccount ba1 = new BankAccount(1000, "Первый ");
    	ba1.start();
    	BankAccount ba2 = new BankAccount(1000, "Второй ");
    	ba2.start();
    }

    private static Object key = new Object();
    public static void test(String string) {
        try {
        	synchronized(key){
        		System.out.print("|");
        		System.out.print(string);
        		System.out.print("|");
        		Thread.sleep(1000);
        		key.notify();
        		key.wait();
        		}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
