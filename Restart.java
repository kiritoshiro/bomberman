import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.*;
/**
 * Write a description of class Restart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Restart extends Button
{
  //  World world =  getWorld();
    public void act()  
    {

        if(Greenfoot.mouseClicked(this)){
            clicked=true;
           
                Greenfoot.setWorld(new BrightWorld());
           
        }
    }    

}
