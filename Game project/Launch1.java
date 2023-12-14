import java.util.Scanner;

class Guesser {
    int guessNum;

    int guessingNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Guesser! Kindly guess the number");
        guessNum = sc.nextInt();
        return guessNum;
    }
}

class Player {
    int guessNum;

    int guessingNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Guesser! Kindly guess the number👨");
        guessNum = sc.nextInt();
        return guessNum;
    }
}

class Umpire {
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;

    void collectNumberFromGuesser() {
        Guesser g = new Guesser();
        numFromGuesser = g.guessingNumber();
    }

    void collectNumberFromPlayers() {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();

        numFromPlayer1 = p1.guessingNumber();
        numFromPlayer2 = p2.guessingNumber();
        numFromPlayer3 = p3.guessingNumber();

    }

    void compare() {
        if (numFromGuesser == numFromPlayer1) {

            if (numFromGuesser == numFromPlayer2 && numFromGuesser == numFromPlayer3) {
                System.out.println("All you are win ");
            } else if (numFromGuesser == numFromPlayer2) {
                System.out.println("Player 1 aur Player 2 jeet gaye👨");
            } else if (numFromGuesser == numFromPlayer3) {
                System.out.println("Player 1 aur Player 3 jeet gaye👨");
            } else {
                System.out.println("Player 1 won the game👨");
            }

        } else if (numFromGuesser == numFromPlayer2) {
            if (numFromGuesser == numFromPlayer3) {
                System.out.println("Player 2 aur Player 3 jeet gaye^_^");
            } else {
                System.out.println("Player 2  won the game^_^");
            }
        } else if (numFromGuesser == numFromPlayer3) {
            System.out.println("player3 won the game👨");
        } else {
            System.out.println("You loss the game!.😒");
        }
    }
}

public class Launch1 {

    public static void main(String[] args) {
        System.out.println("Game started");
        Umpire u = new Umpire();
        u.collectNumberFromGuesser();
        u.collectNumberFromPlayers();
        u.compare();

    }
}