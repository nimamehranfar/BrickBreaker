package ir.ac.kntu;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BrickBreaker {

    public static void main(String[] args) {
        double inf = Double.POSITIVE_INFINITY;

        System.out.println("Enter Game Lenght:");
        Scanner scanner = new Scanner(System.in);
        int lenght = scanner.nextInt();

        Page page = new Page(lenght);
        page.setLeanght(lenght);

        System.out.println("Enter How Many Rounds:");
        int continueGame = scanner.nextInt();
        for (int i = 0; i < continueGame; i++) {
            System.out.println("");
            System.out.println("Round " + (i + 1));
            page.giveCopyOfGameBoard();
            if (page.checkMagic()) {
                page.randomizeMagicalBrick(lenght);
            } else {
                if (!page.checkNextRandom()) {
                    page.randomizeBrick(lenght);
                } else {
                    page.changeNextRandom();
                }
            }
            if (page.checkGameEnd()) {
                break;
            }
            page.printGameBoard(lenght);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
            }
            while (!page.endThisTour()) {
                if (page.checkBallSpeed() != 1) {
                    page.specialBallMove();
                } else {
                    page.moveBall();
                }
                page.setWholeArray();
                page.printGameBoard(lenght);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {

                }
                if (page.checkMagic()) {
                    page.randomizeMagicalBrick(lenght);
                }
                if (page.checkBallSpeed() > 0) {
                    page.specialBallMove();
                }
                page.checkTourEnd();
            }
            page.resetTourEnd();
        }
        System.out.println("Your Final Point Is:" + page.getPoint());
    }

}
