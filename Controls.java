import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Controls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controls extends Button
{
    public String hide;
    Controls(){
        // writinti();
    }

    

    public void act()  
    {
        if(Greenfoot.mouseClicked(this)){
            clicked=true; 
            add();
            remove();

        }
    }    

    private void remove(){
        getWorld().removeObjects(getWorld().getObjects(Sound2.class));
        getWorld().removeObjects(getWorld().getObjects(Sound.class));
        getWorld().removeObjects(getWorld().getObjects(Field.class));
        getWorld().removeObjects(getWorld().getObjects(Mute.class));
        getWorld().removeObjects(getWorld().getObjects(Controls.class));
    }

    private void add(){
       
        hide = ",";
        TextField key1 = new TextField(hide);
        getWorld().addObject(key1,400,300);
        TextField key2 = new TextField();
        getWorld().addObject(key2,400,350);
        TextField key3 = new TextField();
        getWorld().addObject(key3,400,400);

    }
}
