public class IssueDB {
    private int code;
    private String message;

    public IssueDB(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
