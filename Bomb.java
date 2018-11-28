import greenfoot.*;

/**
 * Write a description of class virus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Bomb extends Animal
{
    static boolean isBlocking = false;
    static int x;
    static int y;
    private int level;
    private int bombTimeDelay;
    private int bombReloadTime = 20;
    private GreenfootSound blast= new  GreenfootSound("blast.mp3") ;
    //int eatenFlowers;
    private String fireImage;
    private int blastTimer;
    public void act() 
    {

    }  

    void  getFireImage(String getingFireImage){
        fireImage = getingFireImage;
    }

    public void bombardiaKirkudu(int eatenFlowers){
        bombTimeDelay++;
        if(!getObjectsInRange(30,Fire.class).isEmpty()){
            bombTimeDelay = 200;
        }
        if(bombTimeDelay >= 200){
            

            if (eatenFlowers >=  0 && eatenFlowers < 5){
                level = 1; 
                blast();
            }else if (eatenFlowers >=  5 && eatenFlowers < 10)
            {
                level = 2;
                blast();
            }else if(eatenFlowers >=  10 && eatenFlowers < 20)
            {
                level = 3;
                blast();
            } else if(eatenFlowers >=  20 && eatenFlowers < 30)
            {
                level = 4;
                blast();
            }else if(eatenFlowers >=  30 && eatenFlowers < 5000)
            {
                level = 5;

                blast();
            }
            blast.setVolume(Dungeons.soundLevel);
            blast.play();

            bombTimeDelay = 0;
            getWorld().removeObject(this);

        }
    }

    private void xLinija(int i, int j){

        if(getOneObjectAtOffset((i*40),(j*40),Rock.class) != null){
            isBlocking = true;
            return;
        }else{
            addSomeFire(i,j);
        }
    }

    private void addSomeFire(int i, int j){
        Fire fire = new Fire();
        fire.setImage(fireImage);
        getWorld().addObject (fire,getX()+(i*40),getY()+(j*40));
    }

    private void yteigGalimaLinija(int j, int x, int y){
        isBlocking = false;
        for (int i=1;i<=j;i++){
            y = i;
            xLinija(x,y);
            if (isBlocking){
                i=5;
            }

        }

    }

    void yneigGalimaLinija(int j, int x, int y){
        isBlocking = false;
        for (int i=-1;i>=j;i--){
            y=i;
            xLinija(x,y);
            if (isBlocking){
                i=-5;
            }
        }

    }

    void xteigGalimaLinija(int j, int x, int y){
        isBlocking = false;
        for (int i=1;i<=j;i++){
            x = i;
            xLinija(x,y);
            if (isBlocking){
                i=5;
            }

        }

    }

    void xneigGalimaLinija(int j, int x, int y){
        isBlocking = false;
        for (int i=-1;i>=j;i--){
            x=i;
            xLinija(x,y);
            if (isBlocking){
                i=-5;
            }
        }

    }

    void blast()
    {      
        Fire fire = new Fire();
        fire.setImage(fireImage);
        getWorld().addObject (fire,getX(),getY());
        yteigGalimaLinija(level,0,1);
        yneigGalimaLinija(-level,0,0);
        xteigGalimaLinija(level,1,0);
        xneigGalimaLinija(-level,0,0);
        blastTimer = 0;
    }

}
