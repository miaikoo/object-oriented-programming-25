
import java.util.List;
import java.util.Iterator;

public class Fox extends Animal {
    private static final int BREEDING_AGE = 15;
    private static final int MAX_AGE = 150;
    private static final double BREEDING_PROBABILITY = 0.08;
    private static final int MAX_LITTER_SIZE = 2;
    private static final int RABBIT_FOOD_VALUE = 9;
    private static final int MAX_FOOD_LEVEL = 10; 

    private int foodLevel;

    public Fox(Field field, Location location) {
        super(field, location);
        foodLevel = Randomizer.nextInt(MAX_FOOD_LEVEL);
    }
    
    @Override
    public void act(List<Animal> newFoxes) {
        incrementAge();
        incrementHunger();
        if(isAlive()) {
            giveBirth(newFoxes);            
            Location newLocation = findFood();
            if(newLocation == null) { 
                newLocation = field.freeAdjacentLocation(location);
            }
            
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                setDead();
            }

            if (age > MAX_AGE || foodLevel <= 0) {
                setDead();
            }
        }
    }
    
    private void incrementHunger() {
        foodLevel--;
    }
    
    private Location findFood() {
        List<Location> adjacent = field.getFreeAdjacentLocations(location);
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Animal animal = field.getObjectAt(where);
            if(animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if(rabbit.isAlive()) { 
                    rabbit.setDead();
                    foodLevel += RABBIT_FOOD_VALUE;
                    if(foodLevel > MAX_FOOD_LEVEL) foodLevel = MAX_FOOD_LEVEL;
                    return where;
                }
            }
        }
        return null;
    }

    private void giveBirth(List<Animal> newFoxes) {
        if(age >= BREEDING_AGE && Randomizer.nextDouble() <= BREEDING_PROBABILITY) {
            int births = Randomizer.nextInt(MAX_LITTER_SIZE) + 1;
            List<Location> free = field.getFreeAdjacentLocations(location);
            for(int b = 0; b < births && free.size() > 0; b++) {
                Location loc = free.remove(0);
                Fox young = new Fox(field, loc);
                newFoxes.add(young);
            }
        }
    }
}