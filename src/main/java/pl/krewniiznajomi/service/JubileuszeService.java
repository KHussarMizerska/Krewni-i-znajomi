package pl.krewniiznajomi.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.krewniiznajomi.model.Rocznice;
import pl.krewniiznajomi.model.Wszyscy;
import pl.krewniiznajomi.utils.HibernateUtils;

import java.util.List;

public class JubileuszeService {

    public List<Wszyscy> jubileuszeUrodziny(){

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Wszyscy> urodzinyDzis = session.createSQLQuery("SELECT imie, nazwisko, data_ur FROM wszyscy WHERE MONTH(data_ur) = MONTH(CURDATE()) ORDER BY DAY(data_ur), YEAR(data_ur)").addEntity(Wszyscy.class).list();

        transaction.commit();
        session.close();
        return urodzinyDzis;
    }

    public List<Rocznice> roczniceSlubu(){

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Rocznice> roczniceSlubu = session.createSQLQuery("SELECT * \n" +
                "                    FROM rocznice \n" +
                "                    WHERE MONTH(data_slubu) = MONTH(CURDATE())\n" +
                "                    ORDER BY DAY(data_slubu), YEAR(data_slubu)").addEntity(Rocznice.class).list();

        transaction.commit();
        session.close();
        return roczniceSlubu;
    }
}
