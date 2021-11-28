package hb02_uni;

import hb02_uni.entity.Course;
import hb02_uni.entity.Instructor;
import hb02_uni.entity.InstructorDetail;
import hb02_uni.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hb02_uni_hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            Course course = new Course("Pacman");

            course.addReview(new Review("Good course"));
            course.addReview(new Review("OMG such wow"));
            course.addReview(new Review("Best course"));

            System.out.println("Saving course");
            System.out.println(course);
            session.save(course);

            session.getTransaction().commit();
            System.out.println("Done");
        } catch (Exception e) { e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
