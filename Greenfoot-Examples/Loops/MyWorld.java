import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
         //    int randomX = Greenfoot.getRandomNumber(600);
         //   int randomY = Greenfoot.getRandomNumber(400);
        // for(<init>;<condition>;<increment>)
        /*
        for(int k = 0;k<8;k++){
            for(int i = 0;i<12;i++){
                addObject(new Butterfly(),60+i*50,70+k*50);
            }
        }*/
       
        // while(<condition>)
        /*boolean hasRun = false;
        while(!hasRun){
            addObject(new Butterfly(),60,70);
            hasRun=true;
        }*/
        
        
        int avgLifeSpan = 700;
        // First row
        addObject(new Butterfly(Greenfoot.getRandomNumber(avgLifeSpan*2)),60,70);
        addObject(new Butterfly(Greenfoot.getRandomNumber(avgLifeSpan*2)),160,70);
        addObject(new Butterfly(Greenfoot.getRandomNumber(avgLifeSpan*2)),260,70);
        addObject(new Butterfly(Greenfoot.getRandomNumber(avgLifeSpan*2)),360,70);
        addObject(new Butterfly(Greenfoot.getRandomNumber(avgLifeSpan*2)),460,70);
        addObject(new Butterfly(Greenfoot.getRandomNumber(avgLifeSpan*2)),560,70);
        
        // Second row
        addObject(new Butterfly(Greenfoot.getRandomNumber(avgLifeSpan*2)),60,170);
        addObject(new Butterfly(Greenfoot.getRandomNumber(avgLifeSpan*2)),160,170);
        
        
        
        
    }
}
