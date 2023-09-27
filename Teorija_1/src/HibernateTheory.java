import model.Warehouse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTheory {
    public static void main(String[] args) {
        SessionFactory factory = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Warehouse warehouse1 = new Warehouse("Silutes Depo", "Silute");
            Warehouse warehouse2 = new Warehouse("Plateliu Depo", "Plateliai");
            session.save(warehouse1);
            session.save(warehouse2);

            Warehouse w1 = session.get(Warehouse.class, 1);
            System.out.println(w1);
            w1.setAddress("Silales priemiestis");
            session.update(w1);
            tx.commit();


        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
