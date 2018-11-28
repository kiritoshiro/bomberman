import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Brick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Actor
{
    public Rock(int skaicius){
        setImage("Rock"+skaicius);
    }
    
    public Rock(){
        
    }
    public void act() 
    {
        //drawText();
        getWorld().removeObjects(getObjectsInRange(40, Flower.class));
       
    }  

    public void drawText() {
        GreenfootImage image = getImage();        
        Font font = new Font("Arial",18);
        image.setFont(font);        
        image.setColor(Color.WHITE);        
        int x = 2;
        int y = image.getHeight()/2;       
       
    }
}
