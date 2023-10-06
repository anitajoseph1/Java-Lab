/**************************************************************************************************************
 * File        : MatrixMult.java
 * Description : To multiply two given matrices
 * Author      : Anita Mary Joseph
 * Version     : 1.0
 * Date        : 06/10/2023
 *************************************************************************************************************/
import java.util.Scanner;
public class MatrixMult {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int row1,col1,row2,col2,i,j;
		System.out.println("Enter order of 1st matrix:");
		row1=sc.nextInt();
		col1=sc.nextInt();
		System.out.println("Enter order of 2nd matrix:");
		row2=sc.nextInt();
		col2=sc.nextInt();
		int[][] mat1=new int[row1][col1];
		int[][] mat2=new int[row2][col2];
		int[][] mat3=new int[row1][col2];
		if(col1!=row2)
		{
			System.out.println("Matrix multiplication is not possible!");
		}
		else
		{
			System.out.println("Enter elements in 1st matrix:");
			for(i=0;i<row1;i++)
			{
				for(j=0;j<col1;j++)
				{
					mat1[i][j]=sc.nextInt();
				}
			}
			
			System.out.println("Enter elements in 2nd matrix:");
			for(i=0;i<row2;i++)
			{
				for(j=0;j<col2;j++)
				{
					mat2[i][j]=sc.nextInt();
				}
			}
			//multiplication
			System.out.println("Resulting matrix is:");
			for(i=0;i<row1;i++)
			{
				for(j=0;j<col2;j++)
				{
					mat3[i][j]=0;
					for(int k=0;k<row2;k++)
					{
						mat3[i][j]+=mat1[i][k]*mat2[k][j];
					}
					System.out.print(mat3[i][j]+"\t");
				}
				System.out.println();
			}
		}
	}
}
