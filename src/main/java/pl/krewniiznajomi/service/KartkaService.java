package pl.krewniiznajomi.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.krewniiznajomi.model.Rocznice;
import pl.krewniiznajomi.model.Wszyscy;
import pl.krewniiznajomi.utils.HibernateUtils;

import java.util.List;

public class KartkaService {

    public List<Wszyscy> urodzinyDzis(){

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Wszyscy> urodzinyDzis = session.createSQLQuery("SELECT id, imie, nazwisko, data_ur FROM wszyscy WHERE MONTH(data_ur) = MONTH(CURDATE()) AND DAY(data_ur) = DAY(CURDATE())").addEntity(Wszyscy.class).list();

        transaction.commit();
        session.close();
        return urodzinyDzis;
    }

    public List<Wszyscy> okragleDniDzis(){

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Wszyscy> okragleDniDzis = session.createQuery("SELECT new pl.krewniiznajomi.model.Wszyscy(imie, nazwisko, dataUr, DATEDIFF(NOW(), dataUr)) FROM Wszyscy WHERE MOD(DATEDIFF(NOW(), dataUr), 100) = 0 ORDER BY 4, nazwisko").list();

        transaction.commit();
        session.close();
        return okragleDniDzis;
    }

    public List<Rocznice> roczniceSlubuDzis() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Rocznice> roczniceSlubuDzis = session.createSQLQuery("SELECT imie_zony, nazwisko_zony, imie_meza, nazwisko_meza, data_slubu, nr_rocznicy, nazwa_rocznicy FROM rocznice WHERE ((MONTH(data_slubu) = MONTH(curdate())) AND (DAY(data_slubu) = DAY(curdate())))").addEntity(Rocznice.class).list();

        transaction.commit();
        session.close();
        return roczniceSlubuDzis;
    }
}
