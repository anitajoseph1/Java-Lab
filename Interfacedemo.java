
public class Interfacedemo{
		public static void main(String args []) {
			Fishes fish =new Fishes();
			Cats cat =new Cats("Fluffy");
			Spiders spider =new Spiders();
			
			System.out.println("FISH");
			fish.setName("Mimi");
			System.out.println("The fish's name is "+fish.getName());
			fish.eat();
			fish.walk();
			fish.setName("Momo");
			System.out.println("The fish's name is "+fish.getName());
			
			
		    System.out.println("\nCAT");
		    System.out.println("The cat's name is "+cat.getName());
		    cat.walk();
		    cat.eat();
		    cat.setName("Moose");
		    System.out.println("The cat's name is "+cat.getName());
		    
			System.out.println("\nSPIDER");
			spider.eat();
			spider.walk();
		}
	}
		


	abstract class Animals{
		protected int legs;
		protected Animals(int legs) {
			this.legs=legs;
		}
		public abstract void eat();
		public void walk() {
			System.out.println("This animal walks by "+legs+" legs");
		}
	}

	class Spiders extends Animals{
		public Spiders(){
			super(8);
		}
		public void eat() {
			System.out.println("Spider eats insects");
		}
	}

	interface Pets{
		public String getName();
		public void setName(String name);
		public void play();
	}

	class Cats extends Animals implements Pets{
		private String name;
		public Cats(String name) {
			super(4);
			this.name=name;
		}
		Cats(){
			this("");
		}
		public void eat() {
			System.out.println("Cat eat fishes");
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name=name;
		}
		public void play() {
			System.out.println("The Cat is playing");
		}	
	}

	class Fishes extends Animals implements Pets{
		String name;
		public Fishes() {
			super(0);
		}
		public void eat() {
			System.out.println("Fish eats plants");
		}
		public void play() {
			System.out.println("The Fish is playing");
	    }
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name=name;
		}
		
		public void walk() {
			System.out.println("Fish has no legs");
		}
	}


	