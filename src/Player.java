import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener{  
    Vector position;
    Vector direction = new Vector(0, 0);
    double speed = 200; //200 pixels per second, change later
    Vector cannonTip;
    

    public Player(Vector position){
        this.position = position;
    }

    public void update(double delta){
        position = position.add(direction.normalized().scale(delta).scale(speed));
    }


    public void keyPressed(KeyEvent e) {
        int currentKeyPress = e.getKeyCode();
        if (currentKeyPress == KeyEvent.VK_W) { //wkey
            direction.y = -1;
        }

        if (currentKeyPress == KeyEvent.VK_S) { //skey
            direction.y = 1;
        }

        if (currentKeyPress == KeyEvent.VK_A) { //akey
            direction.x = -1;
        }

        if (currentKeyPress == KeyEvent.VK_D) { //hehe
            direction.x = 5;        
        }
    }

    public void keyTyped(KeyEvent e) {
        //idk why if i delete this it breaks
    }
    public void keyReleased(KeyEvent e) {
        int currentKeyReleased = e.getKeyCode();
        if (currentKeyReleased == KeyEvent.VK_W) { //wkey
            direction.y = 0;
        }

        if (currentKeyReleased == KeyEvent.VK_S) { //Srelease
            direction.y = 0;
        }

        if (currentKeyReleased == KeyEvent.VK_A) { //Arelease
            direction.x = 0;
        }

        if (currentKeyReleased == KeyEvent.VK_D) { //Drelease
            direction.x = 0;
        }
    }

}
