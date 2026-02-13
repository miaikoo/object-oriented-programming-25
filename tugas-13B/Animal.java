import java.util.List;

public abstract class Animal {
    protected boolean alive;
    protected Field field;
    protected Location location;
    protected int age;

    public Animal(Field field, Location location) {
        this.alive = true;
        this.field = field;
        this.age = 0;
        setLocation(location);
    }
    
    abstract public void act(List<Animal> newAnimals);

    
    public boolean isAlive() {
        return alive;
    }

    protected void setDead() {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }
   
    protected void setLocation(Location newLocation) {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
    
    protected void incrementAge() {
        age++;
    }
    
    public Location getLocation() {
        return location;
    }
}