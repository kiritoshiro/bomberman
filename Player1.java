import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.*;
import java.util.List;
/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Hero
{

    private int bombLimit1 = 4;
    private Actor bomb = new Bomb1();
    static boolean isAlive1 = true;
    static boolean pause1 = false;
    public static int hp1 = 5;
    private int hpTimeDelay;
    private int hpReloadTime = 80;
    static  int flowersEaten1;
    private String up = "up";
    private String down = "down";
    private String left = "left";
    private String right = "right";
    private String bombKey = "/";
    private String hideKey = ".";

    public void act() 
    {
        if(Dungeons.getPause()){

        }else{
            eat();
            moveWithKeyboard(up,down,left,right);
            //   pause();
            bomb(bombKey,Bomb1.class,bombLimit1,new Bomb1());
            hide(hideKey);
            manageHp();
            getSpalvaZaidejo("red");
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
                hp1--;
                getImage().setTransparency( 110);
                if (hp1 <= 0){
                    isAlive1 = false;
                }
                hpTimeDelay = 0;
            }

        }   

    }

    public static int getHp1()
    {
        return hp1;
    }

    public void eat() {
        if ((canSee(Flower.class)) && (!isHiding)) {
            eat(Flower.class);
            Greenfoot.playSound("slurp.wav");
            flowersEaten1++;
        }
    } 

    public  int getFlowersEaten1() {
        return flowersEaten1;
    }
}
