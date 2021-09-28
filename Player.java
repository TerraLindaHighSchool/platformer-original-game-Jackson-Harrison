import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private Health[] health;
    private PowerUp[] powerup;
    private int healthCount;
    private int spped;
    private int walkIndex;
    private int frame;
    private float yVelocity;
    private boolean isWalking;
    private boolean isJumping;
    private boolean isFacingLeft;
    private final GreenfootImage[] WALK_ANIMATION;
    private final GreenfootImage STANDING_IMAGE;
    private final float GRAVITY;
    private final float JUMP_FORCE;
    private final Class NEXT_LEVEL;
    private final GreenfootSound MUSIC;
    
    public Player(int speed, float jumpforce, float gravity, int maxHealth,
    int maxPowerUp, Class nextLevel, GreenfootSound music)
    {
        WALK_ANIMATION = new GreenfootImage[]
                         {
                             new GreenfootImage("walk0.png"),
                             new GreenfootImage("walk1.png"),
                             new GreenfootImage("walk2.png"),
                             new GreenfootImage("walk3.png"),
                             new GreenfootImage("walk4.png"),
                             new GreenfootImage("walk5.png"),
                         };
    }
    
                  
    
    public void act()
    {
    }
    public void addedToWorld(World world) {}
    
    private void walk() {}
    private void jump() {}
    private void fall() {}
    private void animator() {}
    private void onCollision() {}
    private void mirrorImages() {}
    private void gameOver() {}
    private boolean isOnGround() 
    {
        
    }
}
