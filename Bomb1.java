import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb1 extends Bomb
{

    private String fireImage = "fire1.png";

    public void act() 
    {
        if(Dungeons.getPause()){ 

        }else{ 
            getFireImage(fireImage);  
            bombardiaKirkudu(Player1.flowersEaten1);
        }
    }    
}
