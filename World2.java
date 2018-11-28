import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World2 extends Actor
{
    private boolean clicked; 
     public void act() 
    {
        setImage(new GreenfootImage("World2.png"));
        if(Greenfoot.mouseClicked(this)){
            clicked=true;
            Greenfoot.setWorld(new BrightWorld());
        }
    }    

    public boolean gotClicked()
    {
        boolean wasClicked=clicked;
        clicked=false;
        return wasClicked;
    } 
}
