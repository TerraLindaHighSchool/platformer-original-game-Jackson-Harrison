import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    private final float GRAVITY = 0.0007f;
    private final GreenfootSound MUSIC = new GreenfootSound("zapsplat_024.mp3");
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
        addObject(door,1176,40);
        Player player = new Player(3, 5.6f, GRAVITY, 3, 3, Level2.class, MUSIC);
        addObject(player,25,671);
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
        addObject(new Floor(), 600, 800);
        addObject(new Gem(), 150, 450);
        addObject(new Gem(), 175, 50);
    }
    private void spawn()
    {
        if(Math.random() < 0.0005)
        {
            addObject(new Rock(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
        if(Math.random() < 0.0003)
        {
            addObject(new AcidRain(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
    }
    
}
