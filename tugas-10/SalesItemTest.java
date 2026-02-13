public class SalesItemTest extends SalesItem
{
    public SalesItemTest()
    {
        super("Test Item", 100); 
    }

    public void runTest()
    {
        System.out.println("Starting Test on: " + this.getClass().getName());

        // Create a comment object
        Comment c1 = new Comment("John", "Great stuff", 5);

        this.addComment(c1);

        if(this.comments.size() == 1) {
            System.out.println("SUCCESS: Comment added correctly.");
        } else {
            System.out.println("FAILURE: Comment was not added.");
        }
        
        Comment found = this.findCommentByAuthor("John");
        if(found != null) {
            System.out.println("SUCCESS: Found comment by John.");
        } else {
            System.out.println("FAILURE: Could not find comment.");
        }
    }
}