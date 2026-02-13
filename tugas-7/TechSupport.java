public class TechSupport {
    private IssueResponse responseDB;

    public TechSupport() {
        responseDB = new IssueResponse();
    }

    public String solve(int code) {
        return responseDB.getResponse(code);
    }
}
