import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class App extends JPanel implements KeyListener, MouseListener { 
    int x = 0;
    int y = 0;
    int howMuchX = 0;
    int howMuchY = 0;
    int cannonLength = 35;
    static int whereClickedX;
    static int whereClickedY;
    static int bulletProgess = 0;
    static Player player = new Player(new Vector(400, 400));
    static Color white = new Color(255, 255, 255); //colour*
    static Color Black = new Color(0, 0, 0);
    static Color Red = new Color(255, 0, 0); 
    static Color Gray = new Color(100, 100, 100); 
    public App() {
    addKeyListener(this);
    setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        int j = x-150;
        int i = j;
        g.setColor(Red);
        Point mousePointerPosition = MouseInfo.getPointerInfo().getLocation();
        Vector mousePosition = new Vector(mousePointerPosition.getX() -10, mousePointerPosition.getY() -10);
        Vector mouseClick = new Vector(whereClickedX, whereClickedY);
        Vector cannonTip = player.position.add(mousePosition.subtract(player.position).normalized().scale(cannonLength));
        Vector CannonExtra = player.position.add(mousePosition.subtract(player.position).normalized().scale(cannonLength + 5));
        Vector flyingbullet = player.position.add(mouseClick.subtract(player.position).normalized().scale(bulletProgess)); //the player posisition should be a constant, but the damn paint can't be static
        g.fillOval((int)flyingbullet.x -10, (int)flyingbullet.y -10, 20, 20);
        Graphics2D g2 = (Graphics2D) g; //since it's a 2d graphics, this implies that paint by default is 3d
        g2.setStroke(new BasicStroke(20));
        g.setColor(Gray);
        g.drawLine((int) player.position.x, (int) player.position.y, (int) CannonExtra.x, (int) CannonExtra.y);
        g.setColor(Black);
        g.drawLine((int) player.position.x, (int) player.position.y, (int) cannonTip.x, (int) cannonTip.y);
        g.setColor(Red);
        g.fillOval((int) player.position.x - 25, (int) player.position.y -25, 50, 50);  //actually paints the circle at the coordinates     
    }


    public Vector bulletFlying(int x, int y){
        Vector whereMouseClicked = new Vector(x, y);
        return player.position.add(whereMouseClicked.subtract(player.position).normalized().scale(bulletProgess));
    }



    public void updateAndRefreshtheSystemlol() {
        player.position.x += howMuchX;
        player.position.y += howMuchY;
        bulletProgess += 1;
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        int whaTheyPress = e.getKeyCode();
        if (whaTheyPress == KeyEvent.VK_W) { //wkey
            howMuchX = 0;
            howMuchY = -5;
        }

        if (whaTheyPress == KeyEvent.VK_S) { //skey
            howMuchX = 0;
            howMuchY = 5;
        }

        if (whaTheyPress == KeyEvent.VK_A) { //akey
            howMuchX = -5;
            howMuchY = 0;
        }

        if (whaTheyPress == KeyEvent.VK_D) { //hehe
            howMuchX = 5;
            howMuchY = 0;
        }
    }

    public void keyTyped(KeyEvent e) {
        //idk why if i delete this it breaks
    }
    public void keyReleased(KeyEvent e) {
        int whaTheyNoLongerPress = e.getKeyCode();
        if (whaTheyNoLongerPress == KeyEvent.VK_W) { //wkey
            howMuchX = 0;
            howMuchY = 0;
        }

        if (whaTheyNoLongerPress == KeyEvent.VK_S) { //Srelease
            howMuchX = 0;
            howMuchY = 0;
        }

        if (whaTheyNoLongerPress == KeyEvent.VK_A) { //Arelease
            howMuchX = 0;
            howMuchY = 0;
        }

        if (whaTheyNoLongerPress == KeyEvent.VK_D) { //Drelease
            howMuchX = 0;
            howMuchY = 0;
        }
    }

    public static void main(String[] args) {
        App app = new App();
        JFrame frame = new JFrame(); //createsaframe
        frame.setSize(1080, 720); //how big the window be
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //stops the code when you close the window;
        frame.add(app);
        
        frame.setVisible(true);

        while (true) {
            app.updateAndRefreshtheSystemlol();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("skill issue, probably not my code's fault, idk why there's an error but there is");
                System.out.println(e); //prints the error in the unlickly case there is one
            }
        }
    }


    public void mouseClicked(MouseEvent e) {
        whereClickedX = e.getX();
        whereClickedY = e.getY();
        //will fix in the near future
    }

    public void mousePressed(MouseEvent e) {

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