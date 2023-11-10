package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Random;

public class Page {

    private ArrayList<Movable> movables = new ArrayList<>();
    private ArrayList<Constant> bricks = new ArrayList<>();
    private static int[] game;
    Random random = new Random();
    private boolean gameEnd = false;
    private boolean tourEnd = false;
    private boolean changeNextRandom = false;
    private boolean magical = false;
    private double point;
    private int specialNumber;
    private int firstRandom, secondRandom;
    private int lenght;
    private int ballSpeed = 1;

    Ball ball = new Ball();

    QuickBurnBrick quickBurnBrick = new QuickBurnBrick();
    LateBurnBrick lateBurnBrick = new LateBurnBrick();
    MagicalBrick magicalBrick = new MagicalBrick();
    MagnetBrick magnetBrick = new MagnetBrick();
    AcceleratorBrick acceleratorBrick = new AcceleratorBrick();
    DeceleratorBrick deceleratorBrick = new DeceleratorBrick();

    public Page(int lenght) {

        this.movables.add(ball);
        this.giveCopyOfGameBoard();
        this.bricks.add(quickBurnBrick);
        this.bricks.add(magnetBrick);
        this.bricks.add(lateBurnBrick);
        this.bricks.add(acceleratorBrick);
        this.bricks.add(deceleratorBrick);
        this.bricks.add(magicalBrick);

        Page.game = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            game[i] = -1;
        }
        game[0] = 10;
        game[1] = -2;
        point = 0.0;
        ball.setX(0);
    }

    public void setWholeArray() {
        Page.game = ball.giveCopyOfGameBoard();
    }

    public void printGameBoard(int lenght) {
        for (int i = 0; i < lenght; i++) {

            switch (Page.game[i]) {

                case -3:
                    System.out.print("<");
                    break;
                case -2:
                    System.out.print(">");
                    break;
                case -1:
                    System.out.print("#");
                    break;
                case 10:
                    System.out.print("o");
                    break;
                case 11:
                    System.out.print("oq");
                    earnPoint(0);
                    doSprcialBrick(0);
                    doWorkOfSpecialNumber(this.specialNumber);
                    break;
                case 12:
                    System.out.print("om");
                    earnPoint(1);
                    doSprcialBrick(1);
                    doWorkOfSpecialNumber(this.specialNumber);
                    break;
                case 13:
                    System.out.print("ol");
                    earnPoint(2);
                    doSprcialBrick(2);
                    doWorkOfSpecialNumber(this.specialNumber);
                    break;
                case 14:
                    System.out.print("oa");
                    earnPoint(3);
                    doSprcialBrick(3);
                    doWorkOfSpecialNumber(this.specialNumber);
                    break;
                case 15:
                    System.out.print("od");
                    earnPoint(4);
                    doSprcialBrick(4);
                    doWorkOfSpecialNumber(this.specialNumber);
                    break;
                case 16:
                    System.out.print("og");
                    earnPoint(5);
                    doSprcialBrick(5);
                    doWorkOfSpecialNumber(this.specialNumber);
                    break;
                default:
                    printSpecialBrickSymbol(Page.game[i]);
                    break;
            }

            System.out.print(",");
        }
        System.out.println("");
    }

    public void giveCopyOfGameBoard() {
        ball.setGameBoardCopy(game);
    }

    public void randomizeMagicalBrick(int lenght) {
        game[this.firstRandom] = random.nextInt(6) + 1;
    }

    public void randomizeBrick(int lenght) {
        this.firstRandom = random.nextInt(lenght - 1) + 1;
        this.secondRandom = random.nextInt(6) + 1;
        game[this.firstRandom] = this.secondRandom;
        if (this.firstRandom == 1) {
            gameEnd();
        }
    }

    public void gameEnd() {
        this.gameEnd = true;
    }

    public boolean checkGameEnd() {
        return this.gameEnd;
    }

    public ArrayList<Movable> getMovables() {
        return movables;
    }

    public void moveBall() {
        this.getMovables().forEach((movable) -> {
            movable.move();
        });
        Page.game = ball.giveCopyOfGameBoard();
    }

    public double getPoint() {
        return this.point;
    }

    public void clear() {
        for (int i = 0; i < 100; i++) {
            System.out.println();

        }

    }

    private void printSpecialBrickSymbol(int element) {
        Constant constant = (Brick) bricks.get(element - 1);
        constant.print();
    }

    public boolean endThisTour() {
        return tourEnd;
    }

    public void checkTourEnd() {
        if (game[0] == 10) {
            this.tourEnd = true;
        }
    }

    public void resetTourEnd() {
        this.tourEnd = false;
    }

    public void doSprcialBrick(int element) {
        Constant constant = (Brick) bricks.get(element);
        this.specialNumber = constant.doSpecial();
    }

    public void earnPoint(int element) {
        this.point = ((Brick) bricks.get(element)).getPoint();
    }

    public void doWorkOfSpecialNumber(int number) {
        switch (number) {
            case 0:
                break;
            case 1:
                this.changeNextRandom = true;
                ball.ballChanger();
                break;
            case 2:
                printGameLoop(2);
                break;
            case 3:
                printGameLoop(3);
                break;
            case 4:
                printGameLoop(4);
                break;
            case 5:
                printGameLoop(5);
                break;

            case 6:
                this.changeNextRandom = true;
                ball.setX(ball.getX() - 1);
                game[ball.getX()] = 16;
                game[ball.getX()+1]=-1;
                giveCopyOfGameBoard();
                printGameLoop(1);
                this.magical = true;
                ball.setBack();
                break;
            case 7:
                this.ballSpeed = 3;
                break;
            case 8:
                this.ballSpeed = 2;
                break;

        }
    }

    public boolean checkNextRandom() {
        return this.changeNextRandom;
    }

    void changeNextRandom() {
        if (this.specialNumber == 1) {
            game[firstRandom] = 2;
        } else {
            game[this.firstRandom] = 5;
        }
    }

    public void setLeanght(int lenght) {
        this.lenght = lenght;
    }

    public boolean checkMagic() {
        return this.magical;
    }

    public double checkBallSpeed() {
        return ballSpeed;
    }

    public void specialBallMove() {
        ball.speed(this.ballSpeed);
        ball.specialMove();
    }

    private void printGameLoop(int number) {
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < this.lenght; j++) {

                switch (Page.game[i]) {

                    case -3:
                        System.out.print("<");
                        break;
                    case -2:
                        System.out.print(">");
                        break;
                    case -1:
                        System.out.print("#");
                        break;
                    case 10:
                        System.out.print("o");
                        break;
                    case 11:
                        System.out.print("oq");

                        break;
                    case 12:
                        System.out.print("om");

                        break;
                    case 13:
                        System.out.print("ol");

                        break;
                    case 14:
                        System.out.print("oa");

                        break;
                    case 15:
                        System.out.print("od");
                        break;
                    case 16:
                        System.out.print("og");
                        break;
                    default:
                        printSpecialBrickSymbol(Page.game[i]);
                        break;
                }

                System.out.print(",");
            }
            System.out.println("");
        }
    }
}
