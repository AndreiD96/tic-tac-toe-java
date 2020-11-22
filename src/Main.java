import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sessionCheck = 0;
        int turnCheck = 0;
        int count = 0;
        int numOfX = 0;
        int numOfO = 0;
        int numOfEmptyField = 0;
        int numOfXRow = 0;
        int numOfORow = 0;
        String fieldString = null;

        String topBottom = "---------";
        Character[][] field = new Character[3][3];

        while (true) {

            if (sessionCheck == 0) {
                fieldString = "_________";
            }
            if (sessionCheck == 0) {

                for (int i = 0; i < field.length; i++) {
                    for (int j = 0; j < field[i].length; j++) {
                        field[i][j] = fieldString.charAt(count);
                        count++;
                    }
                }
                System.out.println(topBottom);

                for (Character[] characters : field) {
                    System.out.print("| ");
                    for (Character character : characters) {
                        System.out.print(character + " ");
                    }
                    System.out.println("|");
                }
                System.out.println(topBottom);
                sessionCheck++;

            } else if (sessionCheck > 0) {
                System.out.println("Enter the coordinates: ");
                int a;
                int b;
                int turn = turnCheck % 2;

                coordinates:
                if (input.hasNextInt()) {
                    a = input.nextInt();
                    b = input.nextInt();
                    a = a - 1;
                    b = b - 1;

                    if ((a <= 2 && b <= 2) && (a >= 0 && b >= 0)) {

                        if (field[field.length - b - 1][a] == ' ' || field[field.length - b - 1][a] == '_') {

                            switch (turn) {
                                case 0 -> field[field.length - b - 1][a] = 'X';
                                case 1 -> field[field.length - b - 1][a] = 'O';
                            }
                            System.out.println(topBottom);

                            for (Character[] characters : field) {
                                System.out.print("| ");
                                for (Character character : characters) {
                                    System.out.print(character + " ");
                                }
                                System.out.println("|");
                            }
                            System.out.println(topBottom);
                            turnCheck++;

                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                            break coordinates;
                        }
                    } else {
                        System.out.println("Coordinates should be from 1 to 3!");
                        break coordinates;
                    }
                } else {
                    System.out.println("You should enter numbers!");
                    break coordinates;
                }
            } else {
                System.out.println("Please enter all cells!");
            }
            for (Character[] characters : field) {
                for (Character character : characters) {
                    if (character == 'X') {
                        numOfX++;
                    }
                    if (character == 'O') {
                        numOfO++;
                    }
                    if (character == ' ' || character == '_') {
                        numOfEmptyField++;
                    }
                }
            }
            if (field[0][0] == 'X' && field[0][1] == 'X' && field[0][2] == 'X') {
                numOfXRow++;
            }
            if (field[0][0] == 'O' && field[0][1] == 'O' && field[0][2] == 'O') {
                numOfORow++;
            }
            if (field[1][0] == 'X' && field[1][1] == 'X' && field[1][2] == 'X') {
                numOfXRow++;
            }
            if (field[1][0] == 'O' && field[1][1] == 'O' && field[1][2] == 'O') {
                numOfORow++;
            }
            if (field[2][0] == 'X' && field[2][1] == 'X' && field[2][2] == 'X') {
                numOfXRow++;
            }
            if (field[2][0] == 'O' && field[2][1] == 'O' && field[2][2] == 'O') {
                numOfORow++;
            }
            if (field[0][0] == 'X' && field[1][0] == 'X' && field[2][0] == 'X') {
                numOfXRow++;
            }
            if (field[0][0] == 'O' && field[1][0] == 'O' && field[2][0] == 'O') {
                numOfORow++;
            }
            if (field[0][1] == 'X' && field[1][1] == 'X' && field[2][1] == 'X') {
                numOfXRow++;
            }
            if (field[0][1] == 'O' && field[1][1] == 'O' && field[2][1] == 'O') {
                numOfORow++;
            }
            if (field[0][2] == 'X' && field[1][2] == 'X' && field[2][2] == 'X') {
                numOfXRow++;
            }
            if (field[0][2] == 'O' && field[1][2] == 'O' && field[2][2] == 'O') {
                numOfORow++;
            }
            if (field[0][0] == 'X' && field[1][1] == 'X' && field[2][2] == 'X') {
                numOfXRow++;
            }
            if (field[0][0] == 'O' && field[1][1] == 'O' && field[2][2] == 'O') {
                numOfORow++;
            }
            if (field[0][2] == 'X' && field[1][1] == 'X' && field[2][0] == 'X') {
                numOfXRow++;
            }
            if (field[0][2] == 'O' && field[1][1] == 'O' && field[2][0] == 'O') {
                numOfORow++;
            }
            boolean check = numOfX - 1 == numOfO || numOfO - 1 == numOfX || numOfX == numOfO;
            if (!check) {
                System.out.println("Impossible");
                break;
            } else if (numOfORow > 1) {
                System.out.println("Impossible");
                break;
            } else if (numOfXRow > 1) {
                System.out.println("Impossible");
                break;
            } else if (numOfORow == 1 && numOfXRow == 0) {
                System.out.println("O wins");
                break;
            } else if (numOfXRow == 1 && numOfORow == 0) {
                System.out.println("X wins");
                break;
            } else if (numOfORow == 1 && numOfXRow == 1) {
                System.out.println("Impossible");
                break;
            } else if (numOfORow == 0 && numOfXRow == 0 && numOfEmptyField == 0) {
                System.out.println("Draw");
                break;
            } else if (numOfORow == 0 && numOfXRow == 0) {

                if (sessionCheck != 1) {
                    System.out.println("Game not finished");
                }
                count = 0;
                numOfX = 0;
                numOfO = 0;
                numOfEmptyField = 0;
                numOfXRow = 0;
                numOfORow = 0;
            }
        }
    }
}
