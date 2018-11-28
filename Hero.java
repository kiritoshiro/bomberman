import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

import java.util.List;

public  class Hero extends Animal
{
    protected GreenfootSound planted = new GreenfootSound("planted.mp3");
    protected GreenfootSound eating = new GreenfootSound("slurp.wav");

    private int hideTimeDelay; 
    private int hideReloadTime = 20;
    //protected int  bombLimit = 4; 
    public  boolean isAlive = true;
    // static boolean pause = false;

    public static int flowersEaten;
    // public int hp;

    private int reloadTimeDelay;
    private int bombReloadTime = 10;

    private int imgTimeDelay;
    private int imgReloadTime = 10;

    private int hpTimeDelay;
    private int hpReloadTime = 100;

    public   boolean isHiding = false;
    private String spalvaZaidejo;

    void getSpalvaZaidejo(String spalva){
        spalvaZaidejo = spalva;
    }

    void restart(){
        Restart isnauj = new Restart();
        getWorld().addObject(new Restart(),300,300);
        if(Greenfoot.mouseClicked(isnauj)){ 
            // restart();
            getWorld().addObject(new Restart(),400,300);
        }
    }

    public boolean getIsHiding(){
        return isHiding;
    }

    void hide(String keyToHide){
        hideTimeDelay++;

        if (Greenfoot.isKeyDown(keyToHide)&& (getImage().getTransparency()== 255)){
            if(hideReloadTime <= hideTimeDelay){
                getImage().setTransparency(150);
                hideTimeDelay = 0;
                isHiding = true;
            }
        }else if(Greenfoot.isKeyDown(keyToHide)&& (getImage().getTransparency()== 150)){
            if(hideReloadTime <= hideTimeDelay){
                getImage().setTransparency(255);
                hideTimeDelay = 0;
                isHiding = false;
            }
        }

    }

    void manageHp(int hp)
    {
        hpTimeDelay++;
        if (hpReloadTime <= hpTimeDelay){
            if((getImage().getTransparency() == 110)){
                getImage().setTransparency(255);
            }
            if(((!getObjectsInRange(30,Beast.class).isEmpty()) && (!isHiding)) || !getObjectsInRange(30,Fire.class).isEmpty()){
                hp--;
                getImage().setTransparency( 110);
                if (hp <= 0){
                    isAlive = false;
                }
                hpTimeDelay = 0;
            }

        }   

    }

    public   boolean getIsAlive(){
        return isAlive;
    }

    /*
    public static int getHp()
    {
    return hp;
    }
     */
    protected void bomb(String placeBombKey, Class bombClass, int bombLimit, Actor bombActor)
    {
        reloadTimeDelay++;
        List bombCount =  getWorld().getObjects(bombClass);
        if(Greenfoot.isKeyDown(placeBombKey)){

            if (bombCount.size() <= bombLimit){ 
                if (!isHiding){

                    if(bombReloadTime <= reloadTimeDelay){

                        getWorld().addObject(bombActor,getX(),getY());  
                        planted.setVolume(Dungeons.soundLevel);
                        planted.play();
                        reloadTimeDelay = 0;

                    }
                }
            }
        }
    }


    boolean siena(int x, int y){
        boolean gal = false;
        if (getOneObjectAtOffset(x,y,Rock.class) != null){
            return  gal = true;
        }
        return gal;
    }

    void moveWithKeyboard(String up, String down, String left,
    String right){
        if(Greenfoot.isKeyDown(up) && Greenfoot.isKeyDown(right)) {
            if((siena(25,-20) | siena(25,20))&(siena(20,-25) | siena(-20,-25))){
                animate("ru");
            }else if (siena(25,-20) | siena(25,20)){//right wall
                animate("u");
                setLocation(getX(),getY()-2);
            }else if(siena(20,-25) | siena(-20,-25)){ //up wall
                animate("r");
                setLocation(getX()+2,getY());
            }else{
                setLocation(getX()+2,getY()-2);
                animate("ru");
            }
        }else
        if(Greenfoot.isKeyDown(up) && Greenfoot.isKeyDown(left)) {
            if((siena(-25,-20) | siena(-25,20))&(siena(20,-25)| siena(-20,-25))){
                animate("lu");         
            }else if (siena(-25,-20) | siena(-25,20)){//left wall
                animate("u");
                setLocation(getX(),getY()-2);
            }else if(siena(20,-25)| siena(-20,-25)){//up wall
                animate("l");
                setLocation(getX()-2,getY());
            }else{
                setLocation(getX()-2,getY()-2);
                animate("lu");
            }
        }else
        if
        (Greenfoot.isKeyDown(down) && Greenfoot.isKeyDown(right)) {
            if((siena(20,25) | siena(-20,25))&(siena(25,-20) | siena(25,20))){
                animate("rd");
            }else if (siena(20,25) | siena(-20,25)){//down wall
                animate("r");
                setLocation(getX()+2,getY());
            }else if(siena(25,-20)|siena(25,20)){//right wall
                animate("d");
                setLocation(getX(),getY()+2);              
            }else{
                animate("rd");
                setLocation(getX()+2,getY()+2);
            }
        }else
        if(Greenfoot.isKeyDown(down) && Greenfoot.isKeyDown(left))
        {
            if((siena(-25,20) | siena(-25,-20))&(siena(-20,25) | siena(20,25))){
                animate("ld");
            }else if (siena(-25,20)|siena(-25,-20)){//wall left
                animate("d");
                setLocation(getX(),getY()+2);
            }else if(siena(-20,25)|siena(20,25)){//wall down
                animate("l");
                setLocation(getX()-2,getY());
            }else{
                animate("ld");
                setLocation(getX()-2,getY()+2);
            }
        }else
        if (Greenfoot.isKeyDown(up)){
            if (siena(20,-25)| siena(-20,-25)){
                animate("u");
            }else{
                setLocation(getX(),getY()-2);
                animate("u");
            }
        }else
        if(Greenfoot.isKeyDown(right)) {
            if (siena(25,-20) | siena(25,20)){
                animate("r");
            }else{
                setLocation(getX()+2,getY());
                animate("r");
            }
        }else if(Greenfoot.isKeyDown(down)) {
            if (siena(20,25) | siena(-20,25)){
                animate("d");             
            }else{
                setLocation(getX(),getY()+2);   
                animate("d");
            }
        }else if(Greenfoot.isKeyDown(left)) {
            if (siena(-25,20) | siena(-25,-20)){
                animate("l");
            }else{
                setLocation(getX()-2,getY());            
                animate("l");
            }
        } 
    }

    public void eat() {

        if ((canSee(Flower.class)) && (!isHiding)) {
            eat(Flower.class);
            Greenfoot.playSound("slurp.wav");
            flowersEaten++; 
        }
    } 

    public   int getFlowersEaten() {
        return flowersEaten;
    }

    public void animate(String pav) {

        imgTimeDelay++; 
        if (imgTimeDelay == 3){
            setAnimation(1,pav,isHiding);
        }
        if (imgTimeDelay == 6){
            setAnimation(2,pav,isHiding);
        }
        if (imgTimeDelay == 9){
            setAnimation(3,pav,isHiding);
        }
        if (imgTimeDelay == 12){
            setAnimation(4,pav,isHiding);
        }

        if(imgTimeDelay==13) imgTimeDelay = 0;
    }

    public void setAnimation(int number,String pav, boolean isHiding){

        setImage(new GreenfootImage(spalvaZaidejo+pav+number+".png"));
        GreenfootImage image = getImage(); 
        image.scale(28,40);
        if(isHiding)getImage().setTransparency( 150);
    }
}

