import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)
import java.awt.*;
import java.util.List;
public class DarkWorld extends Dungeons  
{
    public boolean tamsus = true;
    public DarkWorld() 
    {
        pause = false;
        populate();
        backgroundMusic.playLoop(); 
        resetValues();
        
    }

    public void act(){
        repopulateFlower();
        repopulateBeast();
        pause();
        rip(); 
        showFlowersEaten();
        getSoundLevel();
    }

    public void repopulateFlower(){
        List flowers = getObjects(Flower.class);
        if (Player1.isAlive1 && Player2.isAlive2){
            if ((flowers.size()<20)){
                for (int i=0;i<=5;i++){
                    addObject(new Flower(tamsus),Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
                }
            }
        }
    }

    public void repopulateBeast(){
        List beast = getObjects(Beast.class);
        if (Player1.isAlive1 == true && Player2.isAlive2 == true){
            if ((beast.size()<10)){
                for (int i=0;i<=5;i++){
                    addObject(new Beast(),Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
                }
            }
        }
    }



    public void populate(){
        for (int i=0;i<=50;i++){
            addObject(new Flower(tamsus),Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        }
        addObject(new HpPlayer2(),100,15); 
        addObject(new HpPlayer1(),600,15);

        for (int i=0;i<10;i++){
            addObject(new Beast(),Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        }

    }
}
