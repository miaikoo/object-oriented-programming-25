import java.util.ArrayList;

public class SalesItem
{
    private String name;
    private int price;
    
    // 'protected' means subclasses (like SalesItemTest) can access this directly
    protected ArrayList<Comment> comments; 

    public SalesItem(String name, int price)
    {
        this.name = name;
        this.price = price;
        this.comments = new ArrayList<>();
    }

    public void addComment(Comment newComment)
    {
        comments.add(newComment);
    }
    
    // Method mentioned in your image text
    public Comment findCommentByAuthor(String authorName)
    {
        for(Comment c : comments) {
            if(c.getAuthor().equals(authorName)) {
                return c;
            }
        }
        return null;
    }

    public int getPrice()
    {
        return price;
    }
}