public class Vector{
    double x;
    double y; 

    public Vector(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Vector add(Vector v){
        return new Vector(this.x + v.x, this.y + v.y);
    }

    public Vector subtract(Vector v){
        return new Vector(this.x - v.x, this.y - v.y);
    }
    
    public Vector scale(double k){
        return new Vector(this.x * k, this.y * k);
    }

    public double length(){
        return (Math.sqrt(x*x + y*y));
    }

    public Vector normalized(){
        double length = this.length();
        if(length == 0)
            return this;
        return this.scale(1/length);
    }
}
