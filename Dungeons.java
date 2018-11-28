import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.util.List;
/**
 * Write a description of class Dungeons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */ 
public class Dungeons extends World
{ 
    public static int soundLevel;
    public static boolean mute = false;
    public static int yra;
    public static boolean pause = false;
    int hpOriginal = 5;
    boolean pasaulioPabaiga = false;
    boolean pagrota = false;
    static GreenfootSound backgroundMusic = new GreenfootSound("birds.wav");
    GreenfootSound gameOverMusic = new GreenfootSound("gameover.mp3");
    Player1 p1 = new Player1();
    Player2 p2 = new Player2();
    public Dungeons() 
    {    
        super(700, 600, 1); 
        addObject(new Player1(),600,300);
        addObject(new Player2(),100,300);
        backgroundMusic.stop();
        backgroundMusic.playLoop();

        pause = false;
        Player1 p1 = new Player1();

    }

    public void act(){
        
    }

    public void getSoundLevel(){
        if(mute == true){
            soundLevel = 0;
        }else{
            soundLevel = Dungeons.backgroundMusic.getVolume();
        }
        
    }
    public void resetValues(){
        p1.hp1 = hpOriginal;
        p1.flowersEaten1 = 0;
        p1.isAlive1 = true;

        p2.hp2 = hpOriginal;
        p2.flowersEaten2 = 0;
        p2.isAlive2 = true;

    }

    public void showFlowersEaten(){
        if(!pasaulioPabaiga){
            showText(""+p2.flowersEaten2,200,15);
            showText(""+p1.flowersEaten1,500,15);
        }
    }

    void pause(){
        if(!pasaulioPabaiga){
            String key = Greenfoot.getKey();
            if("p".equals(key)) {
                if(pause == false){
                    pause = true;
                    addObject(new Pause(),getWidth()/2,getHeight()/5);
                    addObject(new Option(),getWidth()/2,getHeight()/2);
                    meniu();

                }else {
                    pause = false;
                    removeObjects(getObjects(Pause.class));
                    deleteMeniu();
                }
            }
        }

    }

    public static boolean getPause(){
        return pause;
    }

    public  void paruostiGO(){
        pasaulioPabaiga = true;
        removeObjects(getObjects(Beast.class));
        removeObjects(getObjects(Rock.class));
        removeObjects(getObjects(Flower.class));
        removeObjects(getObjects(Fire.class));
        removeObjects(getObjects(Hero.class));

        addObject(new Gameover(),getWidth()/2,getHeight()/7);
        meniu();
    }

    public void deleteMeniu(){
        removeObjects(getObjects(Button.class));
    }

    public void meniu(){
        addObject(new Option(),getWidth()/2,4*getHeight()/8);
        addObject(new Home(),getWidth()/2,5*getHeight()/8);
        addObject(new Restart(),getWidth()/2,6*getHeight()/8);

    }

    protected void rip(){
        if ((Player2.isAlive2 == false) && !pasaulioPabaiga) { 
            paruostiGO();

            showText("RED WON",getWidth()/2,getHeight()/7+50);
        }else if ((Player1.isAlive1 == false) && !pasaulioPabaiga) {
            paruostiGO();
            showText("BLUE WON",getWidth()/2,getHeight()/7+50);
        }
        if (pasaulioPabaiga && !pagrota){
            pagrota = true;
            // backgroundMusic.stop();
            gameOverMusic.setVolume(soundLevel);
            gameOverMusic.play(); 
        }
    }
}
