import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pew here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class RightPew extends Actor
{
    public boolean removeSelf = false;
    public void act()
    {
        movePew();
        destroyObstacle();
        checkOutOfBounds();
        removeSelf();
        //implement this ^
    }
    private void movePew()
    {
        setLocation(getX() + 12, getY());
    }
    private void checkOutOfBounds()
    {
        if((getX() > getWorld().getWidth() - 1) || (getX() < 0))
        {
            removeSelf = true;
        }
    }
     public void destroyObstacle()
    {
       Actor enemy = getOneIntersectingObject(Obstacle.class);
       if(enemy != null) {
            removeTouching(Obstacle.class);
            removeSelf = true;
       }
    }
    public void removeSelf()
    {
       if(removeSelf == true)
       {
           removeSelf = false;
           getWorld().removeObject(this);
       }
    }
}
