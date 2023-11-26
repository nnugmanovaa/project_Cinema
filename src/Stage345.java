import java.util.Scanner;

public class Stage345 {

    public static Scanner scanner= new Scanner(System.in);

    public static int rows;
    public static int seats;
    public static String[][] cinema;
    public static void main(String[] args) {
        System.out.println("Enter rows number: ");
        rows = scanner.nextInt();

        System.out.println("Enter seats number: ");
        seats = scanner.nextInt();
        createCinema(rows,seats);

        while (true) {
            System.out.println("\n1. Show seats\n2. Buy a ticket\n3. Show statistics\n0. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showSeats();
                    break;
                case 2:
                    purchaseSeat();
                    break;
                case 3:
                    showStatistics();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    public static void createCinema( int rows, int seats){
        System.out.println("Cinema: ");
        cinema = new String[rows+1][seats+1];
        for (int i=0; i<=rows; i++) {
            for (int j = 0; j <=seats; j++) {
                if (i == 0 && j == 0) System.out.print("  ");
                else if (i == 0) System.out.print(j  + " ");
                else if (j == 0) System.out.print(i + " ");
                else {
                        cinema[i][j]="S ";
                        System.out.print(cinema[i][j]);

                    }
            }
            System.out.println();
        }
    }

    public static void showSeats() {
        System.out.println("Cinema: ");
        for (int i=0; i<=rows; i++) {
            for (int j = 0; j <=seats; j++) {
                if (i == 0 && j == 0) System.out.print("  ");
                else if (i == 0) System.out.print(j  + " ");
                else if (j == 0) System.out.print(i + " ");
                else {
                    System.out.print(cinema[i][j]);
                }
            }
            System.out.println();
        }
    }


    public static void purchaseSeat(){
        if(allSeatsAreBooked(cinema)) {
            System.out.println("All seats are booked!");
            return;
        }
        System.out.println("Enter row: ");
        int selectedRow = scanner.nextInt();

        System.out.println("Enter seat: ");
        int selectedSeat = scanner.nextInt();

        if (selectedRow < 1 || selectedRow > cinema.length || selectedSeat < 1 || selectedSeat > cinema[0].length) {
            System.out.println("Wrong input! Please try again.");
            return;
        }


        if (cinema[selectedRow][selectedSeat] == "B ") {
            System.out.println("This seat is already booked!");
        } else {
            int price = 10;
            System.out.println("Ticket price: $" + price);
            cinema[selectedRow][selectedSeat] = "B "; // Место забронировано
            System.out.println("Booked successfully!");
        }
    }

    public static boolean allSeatsAreBooked ( String [][] cinema){
        for (int i=1; i<=rows; i++) {
            for (int j = 1; j <=seats; j++) {
                if (cinema[i][j] !="B ") return false;
            }
        }
        return true;
    }

    public static void showStatistics(){
        int income = 0;
        int totalIncome = rows*seats*10;
        int totslNumberOfSeats = rows*seats;
        int bookedseats = 0;
        for (int i=1; i<=rows; i++) {
            for (int j = 1; j <=seats; j++) {
                if (cinema[i][j] =="B ") {
                    income+=10;
                    bookedseats++;
                }
            }
        }

        System.out.println("Currennt income: $" + income);
        System.out.println("Total income: $" + totalIncome);
        System.out.println("Number of free seats: " + (totslNumberOfSeats-bookedseats));
        System.out.println("Total number of seats: " + totslNumberOfSeats);
    }

}
