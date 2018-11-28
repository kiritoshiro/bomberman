import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.*;

public class Sound2 extends Button 
{ 

    GreenfootImage image = getImage();
    Sound2(){

        image.scale(1,image.getHeight());
        //	Sound2(2*Dungeons.soundLevel);
    }


    public void act() 
    {
        if (Dungeons.mute == true){ 

        }else{
            if(Greenfoot.isKeyDown("right")&& (image.getWidth()) < 95) {  
                Dungeons.backgroundMusic.setVolume(image.getWidth());
                Dungeons.soundLevel = Dungeons.backgroundMusic.getVolume();
                image.scale(image.getWidth()+4,image.getHeight());
                setLocation(getX()+2,getY());
            }else if(Greenfoot.isKeyDown("left")&& (image.getWidth()) > 1) { 
                Dungeons.backgroundMusic.setVolume(image.getWidth());
                Dungeons.soundLevel = Dungeons.backgroundMusic.getVolume();
                if(image.getWidth() >= 5){
                    image.scale(image.getWidth()-4,image.getHeight());
                    setLocation(getX()-2,getY());
                }

            }
        }
    }    
}
