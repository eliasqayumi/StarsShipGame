
import java.io.IOException;
import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);
    private static String input;
    private static String shipsPosition = "\n\n\t\t#";
    private static final int CONST = 3;
    private static int leftCount = 0;
    private static int rightCount = 0;
    private static int centerCount = 0;

    public static void main(String[] args) {
        ship();
    }
    public static void stars() {
        clear();
        System.out.println("sola gitmek icin a \n saga gitmek icin b\n ortaya gitmek icin herhangi bir tus\n ates yapmak icin c basiniz");
        for (int row = 0; row < CONST; row++) {
            for (int column = 0; column < CONST; column++) {
                if (row >= CONST - leftCount && column == 0) {
                    System.out.print("\t");
                    continue;
                }
                if (row >= CONST - centerCount && column == 1) {
                    System.out.print("\t");
                    continue;
                }
                if (row >= CONST - rightCount && column == 2) {
                    System.out.print("\t");
                    continue;
                }
                System.out.print("\t*");
            }
            System.out.println();
        }
    }

    public static void ship() {
        while (true) {
            stars();
            System.out.println(shipsPosition);
            if (leftCount == 3 && centerCount == 3 && rightCount == 3)
                break;
            else
                input = scanner.next();
            if (input.equals("a")) {
                shipsPosition = "\n\n\t#";
            } else if (input.equals("b")) {
                shipsPosition = "\n\n\t\t\t#";
            } else if (input.equals("c")) {
                if (shipsPosition.equals("\n\n\t#")) {
                    if (leftCount != 3)
                        leftCount++;
                    else
                        break;
                } else if (shipsPosition.equals("\n\n\t\t\t#")) {
                    if (rightCount != 3)
                        rightCount++;
                    else
                        break;
                } else if (shipsPosition.equals("\n\n\t\t#") && centerCount !=3) {
                    if (centerCount != 3)
                        centerCount++;
                    else
                        break;
                }
            } else
                shipsPosition = "\n\n\t\t#";
        }
        if (leftCount == 3 && centerCount == 3 && rightCount == 3) {
            System.out.println("Congratulations You won");
        } else
            System.out.println("Game Over");
    }

    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {}
    }
}
