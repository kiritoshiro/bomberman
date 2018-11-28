import greenfoot.*;

/**
 * Write a description of class fire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fire extends Animal
{

    private int fireTimeDelay;
    private int fireReloadTime = 15;

    public void act() 
    {
        fireTimeDelay++;
        removeTouching(Beast.class);
        if (fireTimeDelay >= fireReloadTime ){
            getWorld().removeObject(this); 
            fireTimeDelay = 0;
        }
    }    

}
