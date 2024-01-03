import java.util.Scanner;

public class TextAdventureGame {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        System.out.println("Welcome to the Text Adventure Game!");
        System.out.println("You find yourself in a mysterious place...");

        while (true) {
            System.out.println("\nChoose your action:");
            System.out.println("1. Go to the left");
            System.out.println("2. Go to the right");
            System.out.println("3. Quit");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    goToLeft();
                    break;
                case 2:
                    goToRight();
                    break;
                case 3:
                    quitGame();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            System.out.print("Enter your choice: ");
            scanner.next(); // consume invalid input
        }
        return scanner.nextInt();
    }

    private static void goToLeft() {
        System.out.println("You went to the left and found a treasure chest!");
        System.out.println("What would you like to do?");
        System.out.println("1. Open the chest");
        System.out.println("2. Go back");

        int choice = getUserChoice();

        if (choice == 1) {
            System.out.println("Congratulations! You found a valuable treasure!");
            quitGame();
        } else if (choice == 2) {
            System.out.println("You decided to go back to the main path.");
        } else {
            System.out.println("Invalid choice. You go back to the main path.");
        }
    }

    private static void goToRight() {
        System.out.println("You went to the right and encountered a fierce dragon!");
        System.out.println("What would you like to do?");
        System.out.println("1. Fight the dragon");
        System.out.println("2. Run away");

        int choice = getUserChoice();

        if (choice == 1) {
            System.out.println("You tried to fight the dragon, but it was too powerful!");
            System.out.println("Game over!");
            quitGame();
        } else if (choice == 2) {
            System.out.println("You wisely decided to run away from the dragon.");
        } else {
            System.out.println("Invalid choice. You panic and run away from the dragon.");
        }
    }

    private static void quitGame() {
        System.out.println("Thanks for playing the Text Adventure Game!");
        System.exit(0);
    }
}
