import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.*;
//import java.io.IOException;
/**
 * Write a description of class Restart here.
 * 
 * @author (your name) 
 * @version (a vers ion number or a date)
 */
public class Option extends Button
{
    // private boolean clicked;

    public void act()   
    {
 
        if(Greenfoot.mouseClicked(this)){
            clicked=true; 
            add();
            remove();

        }
    }    

    private void add(){
        getWorld().addObject(new Field(),getWorld().getWidth()/2,getWorld().getHeight()/2);
        getWorld().addObject(new Sound(),449,4*getWorld().getHeight()/8-1);
        getWorld().addObject(new Sound2(),400,4*getWorld().getHeight()/8);
        getWorld().addObject(new Mute(),550,300);
        getWorld().addObject(new Back(true),getWorld().getWidth()/2,6*getWorld().getHeight()/8);
        getWorld().addObject(new Controls(),getWorld().getWidth()/2,5*getWorld().getHeight()/8);
    }

    private void remove(){
        getWorld().removeObjects(getWorld().getObjects(Restart.class));
        getWorld().removeObjects(getWorld().getObjects(Home.class));
        getWorld().removeObjects(getWorld().getObjects(Option.class));
        //getWorld().removeObjects(getWorld().getObjects(TextField.class));
    }

}
