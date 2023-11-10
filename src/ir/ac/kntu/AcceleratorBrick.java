package ir.ac.kntu;



public class AcceleratorBrick extends Brick{

    public AcceleratorBrick(){
    setPoint(0.5);
    }

    @Override
    public int doSpecial() {
        return 8;
    }

    @Override
    public void print() {
        System.out.print("AB");
    }
    
}
