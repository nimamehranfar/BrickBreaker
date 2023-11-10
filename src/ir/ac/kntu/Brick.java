
package ir.ac.kntu;



public abstract class Brick implements Constant{
    private int health;
    private double point;
    
    public void setHealth(int health){
        this.health=health;
    }
    
    public int getHealth(){
        return this.health;
    }
    
    public void setPoint(double point){
        this.point=point;
    }
    
    public double getPoint(){
     return this.point;   
    }

    
    
    
}
