import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends World
{
    private final float GRAVITY = 0.0667f;
    public final GreenfootSound MUSIC = new GreenfootSound("Jazzbest.mp3");
    public final int SPEED = 4;
    private final int MAX_HEALTH = 3;
    private final int MAX_POWERUP = 3;
    private final float JUMP_FORCE = 7.8f;
    private final Class NEXT_LEVEL = Level4.class;
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level3()
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
        addObject(door,1050,120);
         
        addObject(new SmBrickWall(), 1020, 180);
        addObject(new SmBrickWall(), 900, 650);
        addObject(new SmBrickWall(), 850, 500);
        addObject(new SmBrickWall(), 60, 280);
        addObject(new SmBrickWall(), 60, 600);
        addObject(new SmBrickWall(), 200, 450);
        addObject(new AmmoBoost(), 850, 470);
        addObject(new AmmoBoost(), 70, 250);
        addObject(new BrickWall(), 350, 150);
        addObject(new BrickWall(), 220, 40);
        addObject(new BrickWall(), 700, 40);
        addObject(new BrickWall(), 700, 150);
        
        addObject(new Blocker(GRAVITY), 900, 762);
        addObject(new Blocker(GRAVITY), 900, 600);
        
        addObject(new Blocker(GRAVITY), 700, 100);
        addObject(new Blocker(GRAVITY), 640, 100);
        addObject(new Blocker(GRAVITY), 580, 100);
        addObject(new Blocker(GRAVITY), 520, 100);
        addObject(new Blocker(GRAVITY), 460, 100);
        addObject(new Blocker(GRAVITY), 400, 100);
        addObject(new Blocker(GRAVITY), 340, 100);
        addObject(new Blocker(GRAVITY), 280, 100);
        addObject(new Trapdoor(GRAVITY), 650, 600);
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
