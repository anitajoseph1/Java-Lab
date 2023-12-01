import java.util.Random;

class NumberManager{
	private int generatedNumber;
	private boolean isNumberGenerated=false;
	
	public synchronized void generateNumber() {
		generatedNumber=new Random().nextInt(99)+1;
		System.out.println("Generated Random Number:"+generatedNumber);
		isNumberGenerated=true;
		notifyAll();
	}
	
	public synchronized void printSquare() throws InterruptedException {
		while(!isNumberGenerated || generatedNumber%2!=0) {
			wait();
		}
		System.out.println("Square of "+generatedNumber+" : "+Math.pow(generatedNumber, 2));
		isNumberGenerated=false;
	}
	
	public synchronized void printCube() throws InterruptedException {
		while(!isNumberGenerated || generatedNumber%2==0) {
			wait();
		}
		System.out.println("Cube of "+generatedNumber+" : "+(Math.pow(generatedNumber,3)));
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

class SquarePrinterThread extends Thread{
	NumberManager num;
	public SquarePrinterThread(NumberManager num) {
		this.num=num;
	}
	public void run() {
		while(true) {
			try {
				num.printSquare();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			 
		}
	}
	
}

class CubePrinterThread extends Thread{
	NumberManager num;
	public CubePrinterThread(NumberManager num) {
		this.num=num;
	}
	public void run() {
		while(true) {
			try {
				num.printCube();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			 
		}
	}
}

public class MultiThreadSquareCube {
	public static void main(String args[]) {
		NumberManager num=new NumberManager();
		NumberGenerator ng=new NumberGenerator(num);
		SquarePrinterThread spt=new SquarePrinterThread(num);
		CubePrinterThread cpt=new CubePrinterThread(num);
		ng.start();
		spt.start();
		cpt.start();
	}
}









