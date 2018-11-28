import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mute here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mute extends Button
{
   //GreenfootImage image = getImage();
   //GreenfootImage image = getImage();
    private  boolean mute = Dungeons.mute;
    public Mute(){
        if(mute == true){
            setImage("mute.png");
            
        }else{
            setImage("unmute.png");
        }
        
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            if (Dungeons.mute == true){
                setImage("unmute.png");
                Dungeons.mute = false;
                Dungeons.backgroundMusic.setVolume(Dungeons.soundLevel);
            }else{
                setImage("mute.png");
                Dungeons.mute = true;
                Dungeons.backgroundMusic.setVolume(0);
            }
           
            clicked=true;
            
        }    
    }
}
