package hb01_bi;

import hb01_bi.entity.Instructor;
import hb01_bi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hb01_hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int id = 2;
            InstructorDetail detail = session.get(InstructorDetail.class, id);

            System.out.println(detail.toString());

            System.out.println(detail.getInstructor().toString());

            // break bi-directional link
            detail.getInstructor().setInstructorDetail(null);

            session.delete(detail);

            session.getTransaction().commit();
            System.out.println("Done");
        } catch (Exception e) { e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
