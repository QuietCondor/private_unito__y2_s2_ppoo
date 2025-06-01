public class CourseTest {
    public static void main(String[] args) {
        Course c1 = new Course("Programmazione I", 6);
        Course c2 = new Course("Basi di Dati", 9);
        Course c3 = new Course();

        System.out.println("Course 1: " + c1);
        System.out.println("Course 2: " + c2);
        System.out.println("Course 3: " + c3);

        System.out.println("Course 1 equals Course 1: " + c1.equals(c1));
        System.out.println("Course 1 equals Course 2: " + c1.equals(c2));

        c1.increaseCredits(3);
        System.out.println("Course 1 after increase: " + c1);

        System.out.println("Total courses created: " + Course.getTotalCourses());

        OnlineCourse online = new OnlineCourse("Algoritmi", 6, "Coursera");
        System.out.println("Online Course: " + online);
    }
}