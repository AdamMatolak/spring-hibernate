package hb01_uni;

import hb01_uni.entity.Instructor;
import hb01_uni.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hb01_hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
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
            factory.close();
        }
    }
}
