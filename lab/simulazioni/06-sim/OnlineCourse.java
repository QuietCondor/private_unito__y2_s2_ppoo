public class OnlineCourse extends Course {
    private String _platform;

    public OnlineCourse(String platform) {
        super();
        _platform = platform;
    }

    public OnlineCourse(String courseName, int credits, String platform) {
        super(courseName, credits);
        _platform = platform;
    }

    @Override
    public String toString() {
        String base = super.toString();

        return String.format("%s - [Platform = %s]", base, _platform);
    }
}
