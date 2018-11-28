import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class hp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HpPlayer2 extends Animal
{
    private int lifeCount;
    public void act() 
    {
        lifeCount = Player2.hp2;
        setImage(lifeCount);
        
    }
    void setImage(int lifeCount){
        if (lifeCount >= 0){
         setImage(lifeCount+"health2.png");       
        }
    }
}
