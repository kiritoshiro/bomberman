import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)
import java.awt.*;
import java.util.List;
public class BrightWorld extends Dungeons 
{
    public boolean tamsus= true;
    public BrightWorld() 
    {
        pause = false;
        populate();
        backgroundMusic.stop();
        backgroundMusic.playLoop();
        resetValues();

    }
 
    public void act(){
        rip();
        repopulate();
        pause();
        showFlowersEaten();
        getSoundLevel();
    }

    public void repopulate(){
        List flowers = getObjects(Flower.class);
        if (Player1.isAlive1 == true && Player2.isAlive2 == true){
            if ((flowers.size()<20)){
                for (int i=0;i<=5;i++){
                    addObject(new Flower(tamsus),Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
                }
            }
        }
    }

    public void populate(){
        for (int i=0;i<=100;i++){
            addObject(new Flower(tamsus),Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        }
        addObject(new HpPlayer2(),100,15); 
        addObject(new HpPlayer1(),600,15);
        addObject(new Score2(),200,15);
        addObject(new Score2(),500,15);

        addObject(new Rock(),300,550);
        addObject(new Rock(),440,450);
        addObject(new Rock(),190,350);
        addObject(new Rock(),640,290);
        addObject(new Rock(),540,330);
        addObject(new Rock(),100,100);
        addObject(new Rock(),200,200);
        addObject(new Rock(),300,300);
        addObject(new Rock(),400,400);
        addObject(new Rock(),500,500);
        addObject(new Rock(),600,600);
        addObject(new Rock(),200,400);
        addObject(new Rock(),300,500);
        addObject(new Rock(),600,500);
        addObject(new Rock(),200,600);
        addObject(new Rock(),300,500);
        addObject(new Rock(),400,200);
        addObject(new Rock(),500,300);
        addObject(new Rock(),200,100);
        addObject(new Rock(),100,600);
        // addObject(new Brick(),250,300);
        for (int i=0;i<10;i++){
            addObject(new Beast(),Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        }

    }
}
