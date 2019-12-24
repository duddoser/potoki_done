package potoki;

import java.util.Random;

public class BankAccount extends Thread{
	public StringBuffer message = new StringBuffer();
	public boolean flag = true;
	volatile double account;
	public String s;
	
	BankAccount(double money, String s){
		this.account = money;
		this.s = s;
	}
	
	public void ModifyBalance(double x){
		this.account += x;
		if (check()){
			if (x < 0){
				this.message.append(s + "снятие: ");
			} else {
				this.message.append(s + "пополнение: ");
			}
		}
	}
	
	public boolean check(){
		if (this.account < 0){
			System.out.println("Ошибка: баланс меньше нуля");
			flag = false;
			return false;
		}
		return true;
	}
	
	public void run(){
		while(flag) {
			double l = -100 + Math.random() * 1000;
			ModifyBalance(l);
            Main.test(this.message + " " + l);
            message = new StringBuffer("");
        }
	}

}
