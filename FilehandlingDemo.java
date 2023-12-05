
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
public class FilehandlingDemo {
	public static void main(String [] args) {
		  String data="This is my first file experiment";
		   FileWriter input=null;
		   FileReader output=null;
		   char [] data1=new char[50];
		   try {
			   input=new FileWriter("input.txt");
			   input.write(data);
			   System.out.println("input.txt");
			   System.out.println(data);
			   input.flush();
			   input.close();
			   output=new FileReader("inp.txt");
			   int bytes = output.read(data1);
			   input.close();
			   input=new FileWriter("output.txt");
			   input.write(data1,0,bytes);
			   System.out.println("output.txt");
			   System.out.println(data1);
			   input.flush();
			   input.close();
		   }
		   catch(IOException e) {
			   e.printStackTrace();
		   }
		   
			
		}

}
