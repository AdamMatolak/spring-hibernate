package hb02;

import hb02.entity.Course;
import hb02.entity.Instructor;
import hb02.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteCourse {

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

            int id = 10;
            Course course = session.get(Course.class, id);

            session.delete(course);

            session.getTransaction().commit();
            System.out.println("Done");
        } catch (Exception e) { e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
