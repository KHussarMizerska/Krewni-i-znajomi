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

        List<StatDorosliDTO> lataUrDorosli = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatDorosliDTO(year(data_ur) as rok, count(*) as " +
                "ile) FROM Dorosli GROUP BY 1 " +
                "ORDER BY ile DESC, rok").list();
        transaction.commit();
        session.close();
        return lataUrDorosli;
    }

    public List<StatDorosliDTO> dniTygUrDorosli() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<StatDorosliDTO> dniTygUrDorosli = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatDorosliDTO(CASE\n" +
                "        WHEN (DAYOFWEEK(data_ur) = 1) THEN 'Niedziela'\n" +
                "        WHEN (DAYOFWEEK(data_ur) = 2) THEN 'Poniedziałek'\n" +
                "        WHEN (DAYOFWEEK(data_ur) = 3) THEN 'Wtorek'\n" +
                "        WHEN (DAYOFWEEK(data_ur) = 4) THEN 'Środa'\n" +
                "        WHEN (DAYOFWEEK(data_ur) = 5) THEN 'Czwartek'\n" +
                "        WHEN (DAYOFWEEK(data_ur) = 6) THEN 'Piątek'\n" +
                "        WHEN (DAYOFWEEK(data_ur) = 7) THEN 'Sobota'\n" +
                "\tEND,\n" +
                "    COUNT(*) AS ile) FROM Dorosli\n" +
                "GROUP BY 1\n" +
                "ORDER BY DAYOFWEEK(data_ur)").list();

        transaction.commit();
        session.close();
        return dniTygUrDorosli;
    }

    public List<StatDorosliDTO> dniMiesUrDorosli() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<StatDorosliDTO> dniMiesUrDorosli = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatDorosliDTO(DAY(data_ur) AS wynik, COUNT(*) AS ile) FROM Dorosli GROUP BY DAY(data_ur) ORDER BY DAY(data_ur)").list();

        transaction.commit();
        session.close();
        return dniMiesUrDorosli;
    }

    public List<StatDorosliDTO> miesiaceUrDorosli() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<StatDorosliDTO> miesiaceUrDorosli = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatDorosliDTO(CASE\n" +
                        "                                WHEN (MONTH(data_ur) = 1) THEN 'Styczeń'\n" +
                        "                                WHEN (MONTH(data_ur) = 2) THEN 'Luty'\n" +
                        "                                WHEN (MONTH(data_ur) = 3) THEN 'Marzec'\n" +
                        "                                WHEN (MONTH(data_ur) = 4) THEN 'Kwiecień'\n" +
                        "                                WHEN (MONTH(data_ur) = 5) THEN 'Maj'\n" +
                        "                                WHEN (MONTH(data_ur) = 6) THEN 'Czerwiec'\n" +
                        "                                WHEN (MONTH(data_ur) = 7) THEN 'Lipiec'\n" +
                        "                                WHEN (MONTH(data_ur) = 8) THEN 'Sierpień'\n" +
                        "                                WHEN (MONTH(data_ur) = 9) THEN 'Wrzesień'\n" +
                        "                                WHEN (MONTH(data_ur) = 10) THEN 'Październik'\n" +
                        "                                WHEN (MONTH(data_ur) = 11) THEN 'Listopad'\n" +
                        "                                WHEN (MONTH(data_ur) = 12) THEN 'Grudzień'\n" +
                        "                            END,\n" +
                        "                            COUNT(*) AS ile) FROM Dorosli\n" +
                        "                        GROUP BY 1\n" +
                        "                        ORDER BY MONTH(data_ur)").list();

        transaction.commit();
        session.close();
        return miesiaceUrDorosli;
    }

    public List<StatDorosliDTO> znakiZodiakuDorosli() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        return znakiZodiakuDorosli();
    }
}
