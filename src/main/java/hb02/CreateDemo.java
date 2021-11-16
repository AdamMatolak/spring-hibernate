package hb02;

import hb02.entity.Course;
import hb02.entity.Instructor;
import hb02.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hb02_hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Instructor object = new Instructor("Someone", "Yes", "someone@gmail.com");
            InstructorDetail details = new InstructorDetail("youtubechannel", "surviving");
            object.setInstructorDetail(details);


            session.beginTransaction();

            session.save(object);

            session.getTransaction().commit();
            System.out.println("Done");
        } catch (Exception e) { e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
