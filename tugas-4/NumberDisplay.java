public class NumberDisplay
{
    private int limit;
    private int value;

    public NumberDisplay(int limit)
    {
        this.limit = limit;
        this.value = 0;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int newValue)
    {
        if (newValue >= 0 && newValue < limit) {
            this.value = newValue;
        }
    }

    public void increment()
    {
        value = (value + 1) % limit;
    }

    public String getDisplayValue()
    {
        if (value < 10) {
            return "0" + value;
        }
        return "" + value;
    }
}
