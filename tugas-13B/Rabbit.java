import java.util.List;

public class Rabbit extends Animal {
    private static final int BREEDING_AGE = 5;
    private static final int MAX_AGE = 40;
    private static final double BREEDING_PROBABILITY = 0.12;
    private static final int MAX_LITTER_SIZE = 4;

    public Rabbit(Field field, Location location) {
        super(field, location); 
    }
    
    @Override
    public void act(List<Animal> newRabbits) {
        incrementAge();
        if(isAlive()) {
            giveBirth(newRabbits);            
            Location newLocation = field.freeAdjacentLocation(location);
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                setDead();
            }
            
            if (age > MAX_AGE) {
                setDead();
            }
        }
    }

    
    private void giveBirth(List<Animal> newRabbits) {
        if(age >= BREEDING_AGE && Randomizer.nextDouble() <= BREEDING_PROBABILITY) {
            int births = Randomizer.nextInt(MAX_LITTER_SIZE) + 1;
            List<Location> free = field.getFreeAdjacentLocations(location);
            for(int b = 0; b < births && free.size() > 0; b++) {
                Location loc = free.remove(0);
                Rabbit young = new Rabbit(field, loc);
                newRabbits.add(young);
            }
        }
    }
}