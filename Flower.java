import greenfoot.*;

public class Flower extends Animal
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    Lapas[] lapai;
    void mesti(){
        for(int i=0;i<4;i++){
            lapai[i].kristi();
        }
        
    }
    public Flower(boolean tamsus){
        int rand = Greenfoot.getRandomNumber(100);
        if (rand == 0){
            if (getImage() == image1)
                setImage(image2);
            }
        
    }
    public Flower(){}
    public void act(){
        animate();
        
    }
   
    public void animate(){
        image1 = getImage();
        image2 = new GreenfootImage(image1);
        image2.mirrorHorizontally();
        //image2.setTransparency(90);
        int rand = Greenfoot.getRandomNumber(100);
        if (rand == 0){
            if (getImage() == image1)
                setImage(image2);

            else
                setImage(image1);
        }
    }
}
