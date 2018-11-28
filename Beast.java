import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Collections;
import java.util.List;
import java.awt.geom.Point2D;

public class Beast extends Animal
{
    private int ejimoDelay;
    private int ejimoLaikas;
    private int kryptis;

    private int ejimoLaikoLimitas;
    private int imgTimeDelay;
    private String pusesKriptis;
    private int attackSoundTimer;
    private GreenfootSound comehere = new GreenfootSound("comehere.mp3");
    private GreenfootSound moan = new GreenfootSound("moan.mp3");
    private int moveTimer;
    private int timer;

    public void act() 
    {
        if(Dungeons.pause){
        }else{
            timer++;
            if (timer == 1){

                if (isNear()){
                    nearestHero();
                    soundEffect();
                }else kriptis();
            }else if (timer == 2) timer = 0;
        }
    }  

    void ejimasKriptimi(int kryptis){
        if(!isTouching(Rock.class)){
            switch (kryptis) {
             case 1: ejimas(1,0); break;       
             case 2: ejimas(1,1); break;
             case 3: ejimas(0,1); break;
             case 4: ejimas(-1,1); break;
             case 5: ejimas(-1,0); break;       
             case 6: ejimas(-1,-1); break;
             case 7: ejimas(0,-1); break;
             case 8: ejimas(1,-1); break;
             default: break;
            }
        }
        animate(kryptis);
    }

    void stucked(){
        //if(){
        //}
    }

    public void kriptis(){
        ejimoLaikas++;
        ejimoLaikoLimitas =(Greenfoot.getRandomNumber(200))+10;
        if (ejimoLaikas >= ejimoLaikoLimitas){
            kryptis = Greenfoot.getRandomNumber(7)+1;
            ejimoLaikas = 0;
        }

        ejimasKriptimi(kryptis);

    }

    public void ejimas(int x, int y){
        setLocation(getX()+x,getY()+y);
    }

    public void animate(int kryptis){
        imgTimeDelay++;

        if (kryptis == 1) {
            this.pusesKriptis = "right";
        } else if (kryptis == 3) {
            this.pusesKriptis = "down";
        } else if (kryptis == 5) {
            this.pusesKriptis = "left";
        } else if (kryptis == 7) {
            this.pusesKriptis = "up";
        } else if (kryptis == 2) {
            this.pusesKriptis = "down";
        } else if (kryptis == 4) {
            this.pusesKriptis = "down";
        } else if (kryptis == 6 | kryptis == 8 | kryptis == 9 | kryptis == 0) {
            this.pusesKriptis = "up";
        }
        
        

        setAnimation(pusesKriptis);
        if (imgTimeDelay == 11)imgTimeDelay = 0;
    }

    public void setImage(String puse){
        setImage(new GreenfootImage("Fother-spider_"+puse+".png"));
    }

    public void setAnimation(String puse){
        switch (imgTimeDelay){
            case 2: setImage(puse+1); break;
            case 4: setImage(puse+2); break;
            case 6: setImage(puse+3); break;
            case 8: setImage(puse+4); break;
            case 10: setImage(puse+5); break;
        }
    }
    void chaseHero(int x, int y){
        if ((Math.abs(x-getX()+1) < Math.abs(x-getX())) && (Math.abs(y-getY()+1) < Math.abs(y-getY()))){
                    ejimasKriptimi(6);
        }
        if ((Math.abs(x-getX()+1) < Math.abs(x-getX())) && (Math.abs(y-getY()-1) < Math.abs(y-getY()))){
                    ejimasKriptimi(4);
        } 
        if ((Math.abs(x-getX()-1) < Math.abs(x-getX())) && (Math.abs(y-getY()-1) < Math.abs(y-getY()))){
                    ejimasKriptimi(2);
        }
        if ((Math.abs(x-getX()-1) < Math.abs(x-getX())) && (Math.abs(y-getY()+1) < Math.abs(y-getY()))){
                    ejimasKriptimi(8);
        }
        if (Math.abs(x-getX()-1) < Math.abs(x-getX())) {//&& (Math.abs(y-getY()) < Math.abs(y-getY()))){
                    ejimasKriptimi(1);
        }
        if (Math.abs(y-getY()-1) < Math.abs(y-getY())){
                    ejimasKriptimi(3);
        }
        if  (Math.abs(y-getY()+1) < Math.abs(y-getY())){
                    ejimasKriptimi(7);
        }
        if ((Math.abs(x-getX()+1) < Math.abs(x-getX()))){// && (Math.abs(y-getY()) < Math.abs(y-getY()))){
                    ejimasKriptimi(5);
        }    
    }
    void nearestHero(){
            List<Hero> hero = getObjectsInRange(100,Hero.class);
            double[] distance = new double[1];
            for (int i = 0; i<hero.size(); i++) {
                int x1 = hero.get(i).getX();
                int y1 = hero.get(i).getY();     
                int x2 = getX();
                int y2 = getY();           
                distance[i] = Point2D.distance(x1, y1, x2, y2);
            }
            if(distance[0] <= distance[1]){
                chaseHero(hero.get(0).getX(),hero.get(0).getY() );
            }else{
                chaseHero(hero.get(1).getX(),hero.get(1).getY() );
            }
    }

    private boolean isNear(){
        List<Hero> hero = getObjectsInRange(100,Hero.class);
        if ((!hero.isEmpty())&&(!hero.get(0).isHiding)){
            return true;
        }else{ 
            return false;
        }
    }

    /*
    private int closerOne(){
    List<Hero> hero = getObjectsInRange(100,Hero.class);
    if(hero.size() == 1){

    }
    }
     */

    private void soundEffect(){

        int x = Greenfoot.getRandomNumber(2);
        attackSoundTimer++;
        if(attackSoundTimer == 10){
            if (x == 1){
                moan.setVolume(Dungeons.soundLevel);
                moan.play();
            }else {
                comehere.setVolume(Dungeons.soundLevel);
                comehere.play();
            }
            attackSoundTimer = 0;
        }
    }
}

