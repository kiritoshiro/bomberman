import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
/**
 * Write a description of class ChoseWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChoseWorld extends World
{

    public ChoseWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        showText("Chose Dungeon",getWidth()/2,getHeight()/5);
        addObject(new World1(),150,200);
        addObject(new World2(),450,200);

        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
