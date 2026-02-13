public class TicketMachine
{
    private int price;
    private int balance;
    private int total;

    public TicketMachine(int ticketCost)
    {
        price = ticketCost;
        balance = 0;
        total = 0;
    }

    public int getPrice()
    {
        return price;
    }

    public int getBalance()
    {
        return balance;
    }

    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount: " + amount);
        }
    }

    public void printTicket()
    {
        if(balance >= price) {
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            total = total + price;
            balance = balance - price;
        }
        else {
            int amountLeftToPay = price - balance;
            System.out.println("You must insert at least: " + amountLeftToPay + " more cents.");
        }
    }
}