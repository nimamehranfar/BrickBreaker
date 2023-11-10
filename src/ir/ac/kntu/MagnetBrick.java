package ir.ac.kntu;

import java.util.Random;



public class MagnetBrick extends Brick{

    public MagnetBrick(){
    setPoint(1.0);
    }

    @Override
    public int doSpecial() {
        Random random=new Random();
        int Rand = random.nextInt(4) + 2;
        return Rand;
    }

    @Override
    public void print() {
        System.out.print("SB");
    }
    
}
