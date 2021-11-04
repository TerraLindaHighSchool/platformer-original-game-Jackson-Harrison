import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level5 extends World
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
    public Level5()
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
        Player player = new Player(SPEED, JUMP_FORCE, GRAVITY, MAX_HEALTH, 
                                   MAX_POWERUP, NEXT_LEVEL, MUSIC);
        addObject(player,25,780);
        addObject(door,100,160);
        addObject(new SmBrickWall(), 550, 680); 
        addObject(new SmBrickWall(), 1100, 400);
        addObject(new SmBrickWall(), 1075, 650);
        addObject(new AmmoBoost(), 100, 507);
        addObject(new BrickWall(), 180, 540);
        addObject(new BrickWall(), 200, 220);
        addObject(new BrickWall(), 200, 80);
        addObject(new BrickWall(), 700, 220);
        addObject(new BrickWall(), 880, 480);
        addObject(new Blocker(GRAVITY), 250, 762);
        addObject(new Blocker(GRAVITY), 550, 630);
        addObject(new Blocker(GRAVITY), 160, 490);
        addObject(new Blocker(GRAVITY), 340, 490);
        addObject(new Blocker(GRAVITY), 280, 490);
        addObject(new Blocker(GRAVITY), 220, 490);
        addObject(new Blocker(GRAVITY), 340, 170);
        addObject(new Blocker(GRAVITY), 280, 170);
        addObject(new Blocker(GRAVITY), 220, 170);
        addObject(new Blocker(GRAVITY), 160, 170);
        addObject(new Trapdoor(GRAVITY), 560, 480);
        addObject(new Floor(), 600, 800);

    }
    private void spawn()
    {
        if(Math.random() < 0.002)
        {
            addObject(new Rock(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
    }
}