package ir.ac.kntu;



public class LateBurnBrick extends Brick
{

    public LateBurnBrick(){
    setPoint(2.0);
    }

    @Override
    public int doSpecial() {
        return 1;
    }

    @Override
    public void print() {
        System.out.print("WB");
    }
    
}
