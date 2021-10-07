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
    private int speed;
    private int walkIndex;
    private int frame; 
    private float yVelocity = 1;
    private boolean isWalking;
    private boolean isJumping;
    private boolean isFacingLeft;
    private final GreenfootImage[] WALK_ANIMATION;
    private final GreenfootImage STANDING_IMAGE;
    private final float GRAVITY;
    private final float JUMP_FORCE;
    private final Class NEXT_LEVEL;
    public final GreenfootSound Music;
    public Player(int speed, float jumpforce, float gravity, int maxHealth,
    int maxPowerUp, Class nextLevel, GreenfootSound music)
    {
        this.speed = 1;
        JUMP_FORCE = jumpforce;
        GRAVITY = gravity;
        NEXT_LEVEL = nextLevel;
        Music = music;
        
        STANDING_IMAGE = getImage();
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
        walk();
        jump();
        fall();
        onCollision();
        gameOver();
    }
    public void addedToWorld(World world) {}
    
    private void walk()
    {
        if(isWalking)
        {
            animator();
        }
        else
        {
            setImage(STANDING_IMAGE);
            walkIndex = 0;
        }
        if(Greenfoot.isKeyDown("right"))
        {
            if(isFacingLeft)
            {
                mirrorImages();
            }
            isFacingLeft = false;
            isWalking = true;
            
            move(speed);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            if(!isFacingLeft)
            {
                mirrorImages();
            }
            isFacingLeft = true;
            isWalking = true;
            
            move(-speed);
        }
        if(!(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right")))
        {
            isWalking = false;
        }
    }
    private void jump()
    {
        if(Greenfoot.isKeyDown("space") && isOnGround())
        {
            yVelocity = JUMP_FORCE;
            isJumping = true;
        }
        
        if(isJumping && yVelocity > 0.0)
        {
            setLocation(getX(), getY() - (int) yVelocity);
            yVelocity -= GRAVITY;
        }
        else
        {
            isJumping = false;
        }
    }
    private void fall()
    {
        if(!isOnGround() && !isJumping)
        {
            setLocation(getX(), getY() - (int) yVelocity);
            yVelocity -= GRAVITY;
            System.out.println (yVelocity);
        }
    }
    private void animator() 
    {
        if(frame % (8) == 0)
        {
            if(walkIndex < WALK_ANIMATION.length)
            {
                setImage(WALK_ANIMATION[walkIndex]);
                walkIndex++;
            }
            else
            {
                walkIndex = 0;
            }
        }
        frame++;
    }
    private void onCollision() 
    {
        if(isTouching(Door.class))
        {
            World world = null;
             try 
                {
                    world = (World) NEXT_LEVEL.newInstance();
                }
            catch (InstantiationException e) 
                {
                    System.out.println("Class cannot be instantiated");
                } 
            catch (IllegalAccessException e) 
            {
                System.out.println("Cannot access class constructor");
            } 
            Greenfoot.setWorld(world);
        }
        if(isTouching(Rock.class))
        {
            removeTouching(Rock.class);
        }
        if(isTouching(Platform.class) && !isOnGround())
        {
            yVelocity = -1;
            fall();
        }
    }    
    private void mirrorImages()
    {
        for(int i = 0; i < WALK_ANIMATION.length; i++)
        {
            WALK_ANIMATION[i].mirrorHorizontally();
        }
    }
    private void gameOver() {}
    private boolean isOnGround() 
    {
       Actor ground = getOneObjectAtOffset(0, getImage().getHeight() / 2,
                                            Platform.class);
        return ground != null;
    }
}
