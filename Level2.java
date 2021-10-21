import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    private final float GRAVITY = 0.0667f;
    public final GreenfootSound MUSIC = new GreenfootSound("Jazzbest.mp3");
    public final int SPEED = 4;
    private final int MAX_HEALTH = 3;
    private final int MAX_POWERUP = 3;
    private final float JUMP_FORCE = 7.8f;
    private final Class NEXT_LEVEL = WinSplash.class;
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level2()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false); 
        prepare();
    }
    public void act()
    {
        spawn();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        setPaintOrder(Player.class, Platform.class, Obstacle.class, Collectable.class,
              Door.class, HUD.class);
        Door door = new Door();
        addObject(door,754,248);
        removeObject(door);
        addObject(door,1176,40);
        Player player = new Player(SPEED, JUMP_FORCE, GRAVITY, MAX_HEALTH, 
                                   MAX_POWERUP, NEXT_LEVEL, MUSIC);
        addObject(player,25,600);
        addObject(new SmBrickWall(), 175, 100); 
        addObject(new SmBrickWall(), 125, 500);
        addObject(new SmBrickWall(), 600, 150);
        addObject(new SmBrickWall(), 1100, 150);
        addObject(new SmBrickWall(), 1000, 250);
        addObject(new SmBrickWall(), 925, 350);
        addObject(new SmBrickWall(), 1075, 650);
        addObject(new BrickWall(), 350, 350);
        addObject(new BrickWall(), 800, 500);
        addObject(new Bomb(GRAVITY), 600, 450);
        addObject(new Trapdoor(GRAVITY), 425, 600);
        addObject(new Trapdoor(GRAVITY), 875, 250);
        addObject(new Floor(), 600, 700);
        addObject(new Gem(), 150, 450);
        addObject(new Gem(), 175, 50);
    }
    private void spawn()
    {
        if(Math.random() < 0.002)
        {
            addObject(new Rock(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
        if(Math.random() < 0.003)
        {
            addObject(new AcidRain(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
    }
    
}
