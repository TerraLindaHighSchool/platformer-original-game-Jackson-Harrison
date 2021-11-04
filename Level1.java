import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    private final float GRAVITY = 0.07f;
    public final GreenfootSound MUSIC = new GreenfootSound("zapsplat_024.mp3");
    public final int SPEED = 6;
    private final int MAX_HEALTH = 3;
    private final int MAX_POWERUP = 3;
    private final float JUMP_FORCE = 7.8f;
    private final Class NEXT_LEVEL = Level2.class;
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level1()
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
        addObject(door,1100,90);
        addObject(new SmBrickWall(), 450, 680); 
        addObject(new SmBrickWall(), 1100, 150);
        addObject(new SmBrickWall(), 1075, 650);
        addObject(new AmmoBoost(), 1075, 619);
        addObject(new BrickWall(), 350, 400);
        addObject(new BrickWall(), 520, 220);
        addObject(new BrickWall(), 800, 550);
        addObject(new Blocker(GRAVITY), 560, 350);
        addObject(new Blocker(GRAVITY), 510, 350);
        addObject(new Blocker(GRAVITY), 460, 350);
        addObject(new Blocker(GRAVITY), 410, 350);
        addObject(new Trapdoor(GRAVITY), 875, 250);
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
