package hb02_uni;

import hb02_uni.entity.Course;
import hb02_uni.entity.Instructor;
import hb02_uni.entity.InstructorDetail;
import hb02_uni.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourses {

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

            int id = 10;
            Course course = session.get(Course.class, id);

            System.out.println(course);

            System.out.println(course.getReviews());

            session.getTransaction().commit();
            System.out.println("Done");
        } catch (Exception e) { e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
