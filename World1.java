import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World1 extends Actor
{
    private boolean clicked;
    public void act() 
    {
        setImage(new GreenfootImage("World1.png"));
        if(Greenfoot.mouseClicked(this)){
            clicked=true; 
            Greenfoot.setWorld(new DarkWorld());
        }
    }    

    public boolean gotClicked()
    {
        boolean wasClicked=clicked;
        clicked=false;
        return wasClicked;
    }

}
