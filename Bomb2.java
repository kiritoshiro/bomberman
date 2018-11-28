import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */ 
public class Bomb2 extends Bomb
{
    private String fireImage = "fire2.png";
    private int eaten;
    public void act() 
    {
        if(Dungeons.getPause()){ 

        }else{ 

            getFireImage(fireImage);
            bombardiaKirkudu(Player2.flowersEaten2);
        }
    }    
}
