import java.util.Scanner;

public class Stage2 {

    public static Scanner scanner= new Scanner(System.in);
    public static void main(String[] args) {
        int k =1;
        int c= 1;
        int rows = scanner.nextInt();
        int seats = scanner.nextInt();
        for (int i=0; i<=rows; i++){
            for ( int j=0; j<=seats; j++){
                if ( i == 0 &&  j==0) System.out.print("  ");
                else if(i==0) System.out.print((k++)+" ");
                else if(j==0) System.out.print((c++)+ " ");
                else System.out.print("S ");
            }
            System.out.println();
        }
    }
}
