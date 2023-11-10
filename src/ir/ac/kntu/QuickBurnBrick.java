package ir.ac.kntu;



public class QuickBurnBrick extends Brick{

    public QuickBurnBrick(){
    setPoint(1.0);
    }

    @Override
    public int doSpecial() {
        return 0;
    }

    @Override
    public void print() {
        System.out.print("LB");
    }
    
}
