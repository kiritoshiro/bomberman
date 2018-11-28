import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score2 extends Animal
{
    /**  to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressmed in the environment.
     */
    public void act() 
    {
       //setImage(new GreenfootImage(""+Player2.getFlowersEaten2()));
       
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
