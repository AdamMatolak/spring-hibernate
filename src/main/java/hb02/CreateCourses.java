package hb02;

import hb02.entity.Course;
import hb02.entity.Instructor;
import hb02.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourses {

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

            Course course1 = new Course("Ultimate guide to Java");
            Course course2 = new Course("Javascript - All you need to know");

            instructor.add(course1);
            instructor.add(course2);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();
            System.out.println("Done");
        } catch (Exception e) { e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
