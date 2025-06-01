public class Course {
    private static int _courseCounter = 0;

    private int _courseId;
    private String _courseName;
    private int _credits;

    public Course() {
        _courseId = _courseCounter;
        _courseCounter++;
    }

    public Course(String courseName, int credits) {
        _courseId = _courseCounter;
        _courseCounter++;

        _courseName = courseName;
        _credits = credits;
    }

    public int getCourseId() {
        return _courseId;
    }

    public String getCourseName() {
        return _courseName;
    }

    public int getCredits() {
        return _credits;
    }

    public void setCourseName(String courseName) {
        _courseName = courseName;
    }

    public void setCredits(int credits) {
        _credits = credits;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Course)) {
            return false;
        }

        Course castedObj = (Course) obj;
        return castedObj._courseId == this._courseId;
    }

    @Override
    public String toString() {
        return String.format("[ID = %s, Name = %s, Credits = %s]", _courseId, _courseName, _credits);
    }

    public void increaseCredits(int extraCredits) {
        if (extraCredits > 0) {
            _credits += extraCredits;
        }
    }

    public static int getTotalCourses() {
        return Course._courseCounter;
    }
}
