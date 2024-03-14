import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class App extends JPanel implements MouseListener { 
    int cannonLength = 35;
    Player player = new Player(new Vector(400, 400));
    static Color white = new Color(255, 255, 255); //colour*
    static Color Black = new Color(0, 0, 0);
    static Color Red = new Color(255, 0, 0); 
    static Color Gray = new Color(100, 100, 100); 
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();

    public App() {
        addKeyListener(player);
        addMouseListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        g.setColor(Red);
        Point mousePointerPosition = MouseInfo.getPointerInfo().getLocation();
        Vector mousePosition = new Vector(mousePointerPosition.getX(), mousePointerPosition.getY());
        mousePosition = mousePosition.subtract(new Vector(getLocationOnScreen().x, getLocationOnScreen().y)); //
        player.cannonTip = player.position.add(mousePosition.subtract(player.position).normalized().scale(cannonLength));
        Vector CannonExtra = player.position.add(mousePosition.subtract(player.position).normalized().scale(cannonLength + 5));
        
       
        for (int i = 0; i<bullets.size(); i++){ //updrates all bullets
            g.fillOval((int) bullets.get(i).position.x -10, (int)bullets.get(i).position.y -10, 20, 20);
        }
        Graphics2D g2 = (Graphics2D) g; //since it's a 2d graphics, this implies that paint by default is 3d
        g2.setStroke(new BasicStroke(20));
        g.setColor(Gray);
        g.drawLine((int) player.position.x, (int) player.position.y, (int) CannonExtra.x, (int) CannonExtra.y);
        g.setColor(Black);
        g.drawLine((int) player.position.x, (int) player.position.y, (int) player.cannonTip.x, (int) player.cannonTip.y);
        g.setColor(Red);
        g.fillOval((int) player.position.x - 25, (int) player.position.y -25, 50, 50);  //actually paints the circle at the coordinates     
    }


    public void update(double delta) {
        player.update(delta);
        for (int i = 0; i<bullets.size(); i++){ //updrates all bullets
            bullets.get(i).update(delta);
        }
        repaint();
    }

    
    public static void main(String[] args) {
        App app = new App();
        JFrame frame = new JFrame(); //createsaframe
        frame.setSize(1080, 720); //how big the window be
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //stops the code when you close the window;
        frame.add(app);
        
        frame.setVisible(true);

        while (true) {
            app.update(1/60.0); //every fps (60fps)
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                System.out.println("skill issue, probably not my code's fault, idk why there's an error but there is");
                System.out.println(e); //prints the error in the unlickly case there is one
            }
        }
    }


    public void mouseClicked(MouseEvent e) {
        
    }

    public void mousePressed(MouseEvent e) {
        Vector direction = new Vector(e.getX(), e.getY()).subtract(player.position).normalized();
        Bullet bullet = new Bullet(player.cannonTip, direction);
        bullets.add(bullet);  //spawns and add bullet to the list
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        
    }


    public void mouseExited(MouseEvent e) {

    }
}


//distance bt mouse pos - player pos
//length = lenth formula
//v / v.length = 1
//that formula * barrel = new vector
//player pos + new vector = cannon end pos

//some change