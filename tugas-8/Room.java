class Room
{
    private String description;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;

    public Room(String description)
    {
        this.description = description;
    }

    public void setExits(Room north, Room east, Room south, Room west)
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
    }

    public String getDescription()
    {
        return description;
    }

    public Room getExit(String direction)
    {
        if(direction.equals("north"))
            return northExit;
        if(direction.equals("east"))
            return eastExit;
        if(direction.equals("south"))
            return southExit;
        if(direction.equals("west"))
            return westExit;
        return null;
    }
}