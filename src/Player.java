import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.text.Position;

public class Player implements KeyListener{  
    Vector position;
    Vector direction = new Vector(0, 0);
    double speed = 200; //200 pixels per second, change later
    Vector cannonTip;
    int radius = 25;
    

    public Player(Vector position){
        this.position = position;
    }

    public void update(double delta){
        position = position.add(direction.normalized().scale(delta).scale(speed));
        position.x = Math.min(position.x, App.windowWidth - radius); //clamps for bounderies 
        position.x = Math.max(position.x, radius);
        position.y = Math.min(position.y, App.windowHeight - radius - 30);
        position.y = Math.max(position.y, radius);

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
