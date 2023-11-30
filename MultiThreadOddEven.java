import java.util.Random;

class NumberManager{
	private int generatedNumber;
	private boolean isNumberGenerated=false;
	public synchronized void generateNumber() {
		generatedNumber=new Random().nextInt(99)+2;
		System.out.println("Generated Random Number:"+generatedNumber);
		isNumberGenerated=true;
		notifyAll();
	}
	public synchronized void printEvenNumbers() throws InterruptedException {
		while(!isNumberGenerated || generatedNumber%2!=0) {
			wait();
		}
		for(int i=2;i<=generatedNumber;i+=2) {
			System.out.print(i+" ");
		}
		isNumberGenerated=false;
	}
	public synchronized void printOddNumbers() throws InterruptedException {
		while(!isNumberGenerated || generatedNumber%2==0) {
			wait();
		}
		for(int i=1;i<=generatedNumber;i+=2) {
			System.out.print(i+" ");
		}
		isNumberGenerated=false;
	}
}

class NumberGenerator extends Thread{
	NumberManager num;
	public NumberGenerator(NumberManager num) {
		this.num=num;
	}
	public void run() {
		while(true) {
			num.generateNumber();
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	}
}

class EvenPrinterThread extends Thread{
	NumberManager num;
	public EvenPrinterThread(NumberManager num) {
		this.num=num;
	}
	public void run() {
		while(true) {
			try {
				num.printEvenNumbers();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			 
		}
	}
	
}

class OddPrinterThread extends Thread{
	NumberManager num;
	public OddPrinterThread(NumberManager num) {
		this.num=num;
	}
	public void run() {
		while(true) {
			try {
				num.printOddNumbers();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			 
		}
	}
}

public class MultiThreadOddEven {
	public static void main(String args[]) {
		NumberManager num=new NumberManager();
		NumberGenerator ng=new NumberGenerator(num);
		EvenPrinterThread ept=new EvenPrinterThread(num);
		OddPrinterThread opt=new OddPrinterThread(num);
		ng.start();
		ept.start();
		opt.start();
	}
}
