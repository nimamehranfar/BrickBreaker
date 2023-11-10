package ir.ac.kntu;



public class MagicalBrick extends Brick{

    

    @Override
    public int doSpecial() {
        return 6;
    }

    @Override
    public void print() {
        System.out.print("MB");
    }
    
}
