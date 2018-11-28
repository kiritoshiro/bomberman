import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.io.IOException;
public class Back extends Button
{
    public int value = 29;
    public boolean ivedimas = true;
    Ivedimas ivesti; 
    public Back(){}
    public Back(boolean ivedimas){
        
        if(Greenfoot.mouseClicked(this)){
            try {
                
            ivesti.isvedimas(2);
        } catch (IOException e) {
            System.err.println("An IOException was caught :"+e.getMessage());
        }
            remove();
            clicked=true;
            add();
            //getWorld().addObject(new Ivedimas(value),getWorld().getWidth()/2,6*getWorld().getHeight()/8);
            getWorld().removeObjects(getWorld().getObjects(Back.class));
        }
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            remove();
            clicked=true;
            add();
            getWorld().removeObjects(getWorld().getObjects(Back.class));
        }
    }

    private void add(){
        getWorld().addObject(new Option(),getWorld().getWidth()/2,4*getWorld().getHeight()/8);
        getWorld().addObject(new Home(),getWorld().getWidth()/2,5*getWorld().getHeight()/8);
        getWorld().addObject(new Restart(),getWorld().getWidth()/2,6*getWorld().getHeight()/8);

    }

    private void remove(){
        getWorld().removeObjects(getWorld().getObjects(Sound2.class));
        getWorld().removeObjects(getWorld().getObjects(Sound.class));
        getWorld().removeObjects(getWorld().getObjects(Field.class));
        getWorld().removeObjects(getWorld().getObjects(Mute.class));
        List<TextField> laukas = getWorld().getObjects(TextField.class);
        if (laukas.size() >= 0){
            getWorld().removeObjects(getWorld().getObjects(TextField.class));
        }
    }

}
