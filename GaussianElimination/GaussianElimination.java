package GaussianElimination;

import java.util.Scanner;

public class GaussianElimination
{
    public void solve(double[][]A,double[]b)
    {
        int n=b.length;
        for(int i=0;i<n;i++)
        {
           int max=i;
           for(int j=i+1;j<n;j++)
           {
               if(Math.abs(A[j][i])>Math.abs(A[max][i]));
               {
                   max=i;
               }
           }

           double[] temp=A[i];
           A[i] = A[max];
           A[max]= temp;

           double t = b[i];
           b[i] = b[max];
           b[max]= t;

           for(int l=i+1;l<n;l++)
           {
               double p= A[l][i]/A[i][i];
               b[l] = b[l]-p* b[i];
               for(int m=i;m<n;m++)
               {
                   A[l][m]=A[l][m]-p*A[i][m];
               }
           }
        }

        printRowCanonicalForm(A,b);

        double[] solution = new double[n];
        for(int i= n-1;i>=0;i--)
        {
            double sum=0.0;
            for(int j=i+1;j<n;j++)
            sum= sum+ A[i][j]*solution[j];
            solution[i] =(b[i]-sum)/A[i][i];
        }

        printSolution(solution);
    }
    public void printRowCanonicalForm(double[][]A,double[]b)
    {
        int n=b.length;
        System.out.println("Row Canonical Form :");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            System.out.print(A[i][j]);
            System.out.print("| "+ b[i]);
            
            System.out.println();
        }
    }
    public void printSolution(double[]solution)
    {
        int n= solution.length;
        System.out.println("Solution : ");
        for(int i=0;i<n;i++)
        {
            System.out.print(solution[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        GaussianElimination gauss=new GaussianElimination();
        System.out.println("Enter the number of variables");
        int n= sc.nextInt();

        double[] b=new double[n];
        double[][] A =new double[n][n];

        System.out.println("Enter the coefficients of "+n+ " number of equations");
        for(int i=0;i<n;i++)
        {
          for(int j=0;j<n;j++)
          {
            A[i][j]=sc.nextDouble();
          }
        }
         System.out.println("Enter the "+n+" solutions of the equations");
         
         for(int i=0;i<n;i++ )
         {
             b[i]=sc.nextDouble();

         }
         gauss.solve(A, b);
      sc.close();    
    }
    
}