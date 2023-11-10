/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.kntu;

import java.util.Arrays;

/**
 *
 * @author MM
 */
public class Ball implements Movable {

    private int x;
    private int[] game;
    private boolean change;
    private boolean back = false;
    private int speed;
    private int speedLimit = 0;

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public void setGameBoardCopy(int[] game) {
        this.game = game;
    }

    public int[] giveCopyOfGameBoard() {
        return game;
    }

    public void speed(int speed) {
        this.speed = speed;
    }

    @Override
    public void move() {

        if (this.x == game.length - 1) {
            goBackward();
        } else if (game[this.x + 1] == -2) {
            goForward();
        } else if (game[0] != 10) {
            if (game[this.x - 1] == -3) {
                goBackward();
            } else if (true) {
                goSumForward();
            }
        }

    }

    private void goBackward() {
        if (this.back) {
            game[this.x - 1] = 10;
            if (change) {
                game[this.x] = 3;
                this.change = false;
            } else {
                game[this.x] += -10;
            }

            try {
                game[this.x - 2] = -3;
            } catch (Exception e) {
                game[this.x] = -2;
            } finally {
                setX(this.x - 1);
                this.back=false;
            }
        } else {
            game[this.x - 1] = 10;
            if (change) {
                game[this.x] = 3;
                this.change = false;
            } else {
                game[this.x] = -1;
            }

            try {
                game[this.x - 2] = -3;
            } catch (Exception e) {
                game[this.x] = -2;
            } finally {
                setX(this.x - 1);
            }
        }
    }

    private void goForward() {
        game[this.x + 1] = 10;
        game[this.x] = -1;

        if (game[this.x + 2] == -1) {
            game[this.x + 2] = -2;
        }
        setX(this.x + 1);
    }

    private void goSumForward() {
        game[this.x + 1] += 10;
        game[this.x] = -3;
        setX(this.x + 1);
    }

    @Override
    public void specialMove() {
        if (this.speed == 2) {

            if (this.x - 1 == 0) {
                game[this.x - 1] = 10;
                game[this.x] = -2;
                setX(this.x - 1);
            } else {
                game[this.x - 2] = 10;
                try {
                    game[this.x - 3] = -3;
                    game[this.x - 1] = -1;
                } catch (Exception e) {
                    game[this.x - 1] = -2;
                } finally {
                    setX(this.x - 2);
                }
            }
        } else {
            this.speedLimit += 0.5;
            if (this.speedLimit == 1.0) {
                goBackward();
            }
        }
    }

    public void ballChanger() {
        this.change = true;
    }

    public void setBack(){
        this.back=true;
    }
}
