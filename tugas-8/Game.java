class Game
{
    private Parser parser;
    private Room currentRoom;

    public Game()
    {
        createRooms();
        parser = new Parser();
    }

    private void createRooms()
    {
        Room outside, theatre, pub, lab, office;

        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        outside.setExits(null, theatre, lab, pub);
        theatre.setExits(null, null, null, outside);
        pub.setExits(null, outside, null, null);
        lab.setExits(outside, office, null, null);
        office.setExits(null, null, null, lab);

        currentRoom = outside;
    }

    public void play()
    {
        printWelcome();

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing. Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Adventure! Adventure is a new,");
        System.out.println("incredibly boring adventure game. Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Exits: ");
        
        // FIX: Using getExit for lower coupling
        if(currentRoom.getExit("north") != null)
            System.out.print("north ");
        if(currentRoom.getExit("east") != null)
            System.out.print("east ");
        if(currentRoom.getExit("south") != null)
            System.out.print("south ");
        if(currentRoom.getExit("west") != null)
            System.out.print("west ");
        System.out.println();
    }

    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    private void printHelp()
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("go quit help");
    }

    private void goRoom(Command command)
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // FIX: Using getExit for low coupling and error prevention
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println("You are " + currentRoom.getDescription());
            System.out.print("Exits: ");
            
            // FIX: Using getExit to list exits from the new room
            if(currentRoom.getExit("north") != null)
                System.out.print("north ");
            if(currentRoom.getExit("east") != null)
                System.out.print("east ");
            if(currentRoom.getExit("south") != null)
                System.out.print("south ");
            if(currentRoom.getExit("west") != null)
                System.out.print("west ");
            System.out.println();
        }
    }

    private boolean quit(Command command)
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
}