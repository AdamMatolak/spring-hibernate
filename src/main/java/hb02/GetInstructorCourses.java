package hb02;

import hb02.entity.Course;
import hb02.entity.Instructor;
import hb02.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetInstructorCourses {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hb02_hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);

            List<Course> courses = instructor.getCourses();

            courses.forEach(course -> System.out.println(course.toString()));

            session.getTransaction().commit();
            System.out.println("Done");
        } catch (Exception e) { e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
