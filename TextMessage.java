import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class TextMessage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextMessage extends Actor
{
    private static Font font = new Font("Arial",20);
    private static Color color = Color.BLUE;
    /**
     * Act - do whatever the TextMessage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {      
        //textImage();
        //TextMessage.setText("worms eaaten:");

    }    



    public void setText(String msg){
        GreenfootImage image = getImage();
        image.clear();
        image.setFont(font);
        image.setColor(color);
        int x = 200;
        int y = 10;
        image.drawString(msg,x,y);
    }

  
    public void setColor(Color color){
        this.color = color;
    }

}
