import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.*;
import java.util.List;

public class Player2 extends Hero
{

    private Actor bomb = new Bomb2();
    private int bombLimit2 = 4;
    public static int hp2 = 5;
    static boolean isAlive2 = true; 
    private int hpTimeDelay;  
    private int hpReloadTime = 80;
    private String up = "w";
    private String down = "s";
    private String left = "a";
    private String right = "d";
    private String bombKey = "space";
    private String hideKey = "e";
    static  int flowersEaten2;
    private boolean pirmasPajudejimas = false;
    public void act() 
    {      
        if(Dungeons.getPause()){ 

        }else{ 
            eat();
            moveWithKeyboard(up,down,left,right);
            //pause();
            bomb(bombKey,Bomb2.class,bombLimit2,new Bomb2());
            hide(hideKey);
            manageHp();
            // hp2 = getHp2();
            getSpalvaZaidejo("");
        }
    }  

    void manageHp()
    {
        hpTimeDelay++;
        if (hpReloadTime <= hpTimeDelay){
            if((getImage().getTransparency() == 110)){
                getImage().setTransparency(255);
            }
            if(((!getObjectsInRange(30,Beast.class).isEmpty()) && (!isHiding)) || !getObjectsInRange(30,Fire.class).isEmpty()){
                hp2--;
                getImage().setTransparency( 110);
                if (hp2 <= 0){
                    isAlive2 = false;
                }
                hpTimeDelay = 0;
            }

        }   

    }

    public static int getHp2()
    {
        return hp2;
    }

    public void eat() {
        if ((canSee(Flower.class)) && (!isHiding)) {
            eat(Flower.class);
            Greenfoot.playSound("slurp.wav");
           flowersEaten2++;
        }
    } 
  
    public static int getFlowersEaten2() {
        return flowersEaten2;
    }
    
}