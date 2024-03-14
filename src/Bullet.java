public class Bullet {
    Vector position;
    Vector direction;
    double speed = 400; //pix per second


    public Bullet(Vector position, Vector direction){
        this.position = position;
        this.direction = direction;
    }  

    public void update(double delta){ //delta change is the amount of time that passed between the last frame and this frame, updates everyr frame
        position = position.add(direction.scale(speed).scale(delta)); //new position = old position + velocity * time (delta)

    }
}
