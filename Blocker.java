import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Blocker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blocker extends Obstacle
{
    private float yVelocity;
    private final float GRAVITY;
    
    public Blocker(float gravity)
    {
        GRAVITY = gravity;
    }
    public void act()
    {
        fall();
    }
    
    protected void fall()
    {
        if(!isOnGround())
        {
            yVelocity += GRAVITY;
            setLocation(getX(), getY() + (int) yVelocity);
        }
    }
}
