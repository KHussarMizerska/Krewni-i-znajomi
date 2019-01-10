package pl.krewniiznajomi.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.krewniiznajomi.model.Dorosli;
import pl.krewniiznajomi.model.dto.StatDorosliDTO;
import pl.krewniiznajomi.utils.HibernateUtils;

import java.util.List;

public class DorosliService {

    public List<Dorosli> pokazDorosli() {

        Session session = HibernateUtils.getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();

        List<Dorosli> pokazDorosli = session.createQuery("SELECT d FROM Dorosli d")
                .list();

        transaction.commit();
        session.close();
        return pokazDorosli;
    }

    public List<StatDorosliDTO> imionaDorosli() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<StatDorosliDTO> imionaDorosli = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatDorosliDTO(imie, count(imie) as ile) FROM Dorosli GROUP BY imie " +
                "ORDER BY ile DESC, imie").list();
        transaction.commit();
        session.close();
        return imionaDorosli;
    }


    public List<StatDorosliDTO> lataUrDorosli() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<StatDorosliDTO> lataUrDorosli = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatDorosliDTO(year(data_ur) as rok, count(rok) as ile) FROM Dorosli GROUP BY rok " +
                "ORDER BY ile DESC, rok").list();
        transaction.commit();
        session.close();
        return lataUrDorosli;
    }

    public List<StatDorosliDTO> dniTygUrDorosli() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<StatDorosliDTO> dniTygUrDorosli = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatDorosliDTO(DAYNAME(data_ur) AS wynik, COUNT(*) AS ile, DAYOFWEEK(data_ur)) FROM Dorosli GROUP BY DAYNAME(data_ur) ORDER BY DAYOFWEEK(data_ur)").list();

        transaction.commit();
        session.close();
        return dniTygUrDorosli;
    }
}
