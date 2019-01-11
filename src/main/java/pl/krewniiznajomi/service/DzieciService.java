package pl.krewniiznajomi.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.krewniiznajomi.model.Dorosli;
import pl.krewniiznajomi.model.Dzieci;
import pl.krewniiznajomi.model.dto.StatDorosliDTO;
import pl.krewniiznajomi.model.dto.StatDzieciDTO;
import pl.krewniiznajomi.utils.HibernateUtils;

import java.util.List;

public class DzieciService {

    public List<Dzieci> pokazDzieci() {

        Session session = HibernateUtils.getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();

        List<Dzieci> pokazDzieci = session.createQuery("SELECT dz FROM Dzieci dz")
                .list();

        transaction.commit();
        session.close();
        return pokazDzieci;
    }

    public List<StatDzieciDTO> imionaDzieci() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<StatDzieciDTO> imionaDzieci = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatDzieciDTO(imie, count(imie) as ile) FROM Dzieci GROUP BY imie " +
                "ORDER BY ile DESC, imie").list();
        transaction.commit();
        session.close();
        return imionaDzieci;
    }

    public List<StatDzieciDTO> lataUrDzieci() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<StatDzieciDTO> lataUrDzieci = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatDzieciDTO(year(data_ur) as rok, count(*) as " +
                "ile) FROM Dzieci GROUP BY 1 " +
                "ORDER BY ile DESC, rok").list();
        transaction.commit();
        session.close();
        return lataUrDzieci;
    }

    public List<StatDzieciDTO> dniTygUrDzieci() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<StatDzieciDTO> dniTygUrDzieci = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatDzieciDTO(DAYNAME(data_ur) AS wynik, COUNT(*) " +
                "AS ile) FROM Dzieci GROUP BY DAYNAME(data_ur) ORDER BY DAYOFWEEK(data_ur)").list();

        transaction.commit();
        session.close();
        return dniTygUrDzieci;
    }

    public List<StatDzieciDTO> dniMiesUrDzieci() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<StatDzieciDTO> dniMiesUrDzieci = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatDzieciDTO(DAY(data_ur) AS wynik, COUNT(*) AS ile) FROM Dzieci GROUP BY DAY(data_ur) ORDER BY DAY(data_ur)").list();

        transaction.commit();
        session.close();
        return dniMiesUrDzieci;
    }
}