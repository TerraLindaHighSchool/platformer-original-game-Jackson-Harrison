import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4 extends World
{
    private final float GRAVITY = 0.0667f;
    public final GreenfootSound MUSIC = new GreenfootSound("Jazzbest.mp3");
    public final int SPEED = 4;
    private final int MAX_HEALTH = 3;
    private final int MAX_POWERUP = 3;
    private final float JUMP_FORCE = 7.8f;
    private final Class NEXT_LEVEL = Level5.class;
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level4()
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
        addObject(door,70,190);
         
        addObject(new SmBrickWall(), 650, 180);
        addObject(new SmBrickWall(), 900, 650);
        addObject(new SmBrickWall(), 1200, 650);
        addObject(new SmBrickWall(), 850, 450);
        addObject(new SmBrickWall(), 60, 500);
        addObject(new SmBrickWall(), 220, 380);
        addObject(new SmBrickWall(), 540, 380);
        
        addObject(new AmmoBoost(), 850, 420);
        addObject(new AmmoBoost(), 200, 780);

        addObject(new BrickWall(), 220, 650);
        addObject(new BrickWall(), 220, 250);
        addObject(new BrickWall(), 220, 70);
        
        addObject(new Blocker(GRAVITY), 900, 762);
        addObject(new Blocker(GRAVITY), 900, 600);
        addObject(new Blocker(GRAVITY), 220, 200);
        addObject(new Blocker(GRAVITY), 160, 200);
        addObject(new Blocker(GRAVITY), 340, 200);
        addObject(new Blocker(GRAVITY), 280, 200);
        addObject(new Trapdoor(GRAVITY), 650, 600);
        addObject(new Trapdoor(GRAVITY), 380, 380);
        addObject(new Trapdoor(GRAVITY), 1010 , 450);
        addObject(new Trapdoor(GRAVITY), 1010 , 416);
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
