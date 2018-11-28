import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class HpPlayer1 extends Animal
{
    private int lifeCount;
    public void act() 
    {
        lifeCount = Player1.hp1;
        setImage(lifeCount);
 
    }

    void setImage(int lifeCount){
        if (lifeCount >= 0){
            setImage(lifeCount+"health.png");       
        }
    }
}
