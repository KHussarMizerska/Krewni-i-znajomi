package pl.krewniiznajomi.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.krewniiznajomi.model.Wszyscy;
import pl.krewniiznajomi.utils.HibernateUtils;

import java.util.List;

public class KartkaService {

    public List<Wszyscy> urodzinyDzis(){

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Wszyscy> urodzinyDzis = session.createSQLQuery("SELECT imie, nazwisko, data_ur FROM wszyscy WHERE MONTH(data_ur) = MONTH(CURDATE()) AND DAY(data_ur) = DAY(CURDATE())").addEntity(Wszyscy.class).list();

        transaction.commit();
        session.close();
        return urodzinyDzis;
    }
}
