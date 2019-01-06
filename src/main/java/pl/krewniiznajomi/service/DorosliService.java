package pl.krewniiznajomi.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.krewniiznajomi.model.Dorosli;
import pl.krewniiznajomi.utils.HibernateUtils;

import java.util.List;

public class DorosliService {

    public List<Dorosli> pokazDorosli() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Dorosli> pokazDorosli = session.createQuery("SELECT d FROM Dorosli d").list();

        transaction.commit();
        session.close();
        return pokazDorosli;
    }

    public List<Dorosli> imionaDorosli() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Dorosli> imionaDorosli = session.createSQLQuery("SELECT imie, count(imie) as ile FROM dorosli GROUP BY imie ORDER BY ile DESC, imie").addEntity(Dorosli.class).list();

        transaction.commit();
        session.close();
        return imionaDorosli;

    }
}
