package ir.ac.kntu;



public class DeceleratorBrick extends Brick{
    
    public DeceleratorBrick(){
    setPoint(0.5);
    }  
    
    
    

    @Override
    public int doSpecial() {
        return 7;
    }

    @Override
    public void print() {
        System.out.print("DB");
    }
    
}
