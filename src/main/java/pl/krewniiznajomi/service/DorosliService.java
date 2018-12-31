package pl.krewniiznajomi.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.krewniiznajomi.model.Dorosli;
import pl.krewniiznajomi.utils.HibernateUtils;

import java.util.List;

public class DorosliService {

    public List<Dorosli> getAllD() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Dorosli> wszyscyDorosli = session.createQuery("SELECT d FROM Dorosli d").list();

        transaction.commit();
        session.close();
        return wszyscyDorosli;
    }
}
