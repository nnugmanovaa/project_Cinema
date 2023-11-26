import java.util.Scanner;

public class Stage1 {

    public static Scanner scanner= new Scanner(System.in);

    public static void main(String[] args) {
        int k =1;
        int c= 1;
        int height = scanner.nextInt();
        int lenght = scanner.nextInt();
        for (int i=0; i<=height; i++){
            for ( int j=0; j<=lenght; j++){
                if ( i == 0 &&  j==0) System.out.print("  ");
                else if(i==0) System.out.print((k++)+" ");
                else if(j==0) System.out.print((c++)+ " ");
                else System.out.print("S ");
            }
            System.out.println();
        }
    }
}
