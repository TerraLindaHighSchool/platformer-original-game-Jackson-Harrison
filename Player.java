import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int AmmoCount = 3;
    private int teleportDelay = 120;
    private Health[] health;
    private PowerUp[] powerup;
    private int healthCount;
    private int fireCoolDown = 0;
    private int speed;
    private int walkIndex;
    private int frame; 
    private float yVelocity = 1;
    private boolean isWalking;
    private boolean isJumping;
    public static boolean isFacingLeft;
    private final GreenfootImage[] WALK_ANIMATION;
    private final GreenfootImage player1;
    private final float GRAVITY;
    private final float JUMP_FORCE;
    private final Class NEXT_LEVEL;
    public final GreenfootSound Music;
    private final GreenfootSound JUMPSOUND = new GreenfootSound("jump.wav");
    private final GreenfootSound DOORSOUND = new GreenfootSound("door_open.wav");
    private final GreenfootSound HURTSOUND = new GreenfootSound("explosionSmall.wav");
    public Player(int speed, float jumpforce, float gravity, int maxHealth,
    int maxPowerUp, Class nextLevel, GreenfootSound music)
    {
        this.speed = 1;
        JUMP_FORCE = jumpforce;
        GRAVITY = gravity;
        NEXT_LEVEL = nextLevel;
        Music = music;
        
        healthCount = maxHealth;
        health = new Health[maxHealth];
        
        player1 = getImage();
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
        checkFire();
    }
    private void checkFire()
    {
        if(Greenfoot.isKeyDown("space") && fireCoolDown <= 0 && AmmoCount > 0) 
        {
           if(isFacingLeft == false)
           {
               getWorld().addObject(new RightPew(), getX()+10, getY());
               fireCoolDown = 25;
           }
           else
           {
               getWorld().addObject(new LeftPew(), getX()+10, getY());
               fireCoolDown = 25;
           }
           AmmoCount --;
        }
        if(AmmoCount < 0)
        {
            AmmoCount = 0;
        }
        
        fireCoolDown --;
    }
    public void addedToWorld(World world) 
    {
        health[0] = new Health();
        world.addObject(health[0], 30, 36);
        health[1] = new Health();
        world.addObject(health[1], 72, 36);
        health[2] = new Health();
        world.addObject(health[2], 114, 36);
    }
    
    private void walk()
    {
        if(isWalking)
        {
            setImage(player1);
        }
        else
        {
            setImage(player1);
            walkIndex = 0;
        }
        if(Greenfoot.isKeyDown("d"))
        {
            if(!Music.isPlaying())
            {
                Music.playLoop();
            }
            if(isFacingLeft)
            {
                mirrorImages();
            }
            isFacingLeft = false;
            isWalking = true;
            
            move(speed + 5);
        }
        if(Greenfoot.isKeyDown("a"))
        {
            if(!isFacingLeft)
            {
                mirrorImages();
            }
            isFacingLeft = true;
            isWalking = true;
            
            move(-speed - 5);
        }
        if(Greenfoot.isKeyDown("s") && healthCount == 3 && teleportDelay <= 0)
        {
            if(!isFacingLeft)
            {
                move(100);
            }
            else
            {
                move (-100);
            }
            teleportDelay = 120;
        }
        teleportDelay --;
        if(!(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("d")))
        {
            isWalking = false;
        }
    }
    private void jump()
    {
        if(Greenfoot.isKeyDown("w") && isOnGround())
        {
            yVelocity = JUMP_FORCE;
            isJumping = true;
            if(!JUMPSOUND.isPlaying())
            {
                JUMPSOUND.play();
            }
        }
        
        if(isJumping && yVelocity > 0.0)
        {
            setLocation(getX(), getY() - (int) (2 * yVelocity));
            yVelocity -= (4 * GRAVITY);
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
            yVelocity -= (4 * GRAVITY);
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
            if(!DOORSOUND.isPlaying())
            {
                DOORSOUND.play();
            }
            Music.stop();
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
        if(isTouching(Obstacle.class))
        {
            if(!HURTSOUND.isPlaying())
            {
                HURTSOUND.play();
            }
            removeTouching(Obstacle.class);
            getWorld().removeObject(health[healthCount -1]);
            healthCount--;
        }
        if(isTouching(Platform.class) && !isOnGround())
        {
            yVelocity = -1;
            fall();
        }
        if(isTouching(AmmoBoost.class))
        {
            AmmoCount = 3;
        }
    }    
    private void mirrorImages()
    {
        player1.mirrorHorizontally();
    }
    private void gameOver() 
    {
        if(healthCount == 0)
        {
            Music.stop();
            Greenfoot.setWorld(new Level1());
        }
    }
    private boolean isOnGround() 
    {
       Actor ground = getOneObjectAtOffset(0, getImage().getHeight() / 2,
                                            Platform.class);
        return ground != null;
    }
}
