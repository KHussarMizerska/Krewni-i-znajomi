package pl.krewniiznajomi.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.krewniiznajomi.model.dto.StatDorosliDTO;
import pl.krewniiznajomi.model.dto.StatWszyscyDTO;
import pl.krewniiznajomi.utils.HibernateUtils;

import java.util.List;

public class WszyscyStatService {

    public int ileWszyscy() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        int ileWszyscy = session.createSQLQuery("SELECT * FROM wszyscy").list().size();

        transaction.commit();
        session.close();
        return ileWszyscy;
    }

    public List<StatWszyscyDTO> imionaWszyscy() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<StatWszyscyDTO> imionaWszyscy = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatWszyscyDTO(imie, count(imie) as ile) FROM Wszyscy GROUP BY imie " +
                "ORDER BY ile DESC, imie").list();
        transaction.commit();
        session.close();
        return imionaWszyscy;
    }

    public List<StatWszyscyDTO> dniTygUrWszyscy() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<StatWszyscyDTO> dniTygUrWszyscy = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatWszyscyDTO(CASE\n" +
                "        WHEN (DAYOFWEEK(data_ur) = 1) THEN 'Niedziela'\n" +
                "        WHEN (DAYOFWEEK(data_ur) = 2) THEN 'Poniedziałek'\n" +
                "        WHEN (DAYOFWEEK(data_ur) = 3) THEN 'Wtorek'\n" +
                "        WHEN (DAYOFWEEK(data_ur) = 4) THEN 'Środa'\n" +
                "        WHEN (DAYOFWEEK(data_ur) = 5) THEN 'Czwartek'\n" +
                "        WHEN (DAYOFWEEK(data_ur) = 6) THEN 'Piątek'\n" +
                "        WHEN (DAYOFWEEK(data_ur) = 7) THEN 'Sobota'\n" +
                "\tEND,\n" +
                "    COUNT(*) AS ile) FROM Wszyscy\n" +
                "GROUP BY 1\n" +
                "ORDER BY DAYOFWEEK(data_ur)").list();

        transaction.commit();
        session.close();
        return dniTygUrWszyscy;
    }

    public List<StatWszyscyDTO> dniMiesUrWszyscy() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<StatWszyscyDTO> dniMiesUrWszyscy = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatWszyscyDTO(DAY(data_ur) AS wynik, COUNT(*) AS ile) FROM Wszyscy GROUP BY DAY(data_ur) ORDER BY DAY(data_ur)").list();

        transaction.commit();
        session.close();
        return dniMiesUrWszyscy;
    }

    public List<StatWszyscyDTO> miesiaceUrWszyscy() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<StatWszyscyDTO> miesiaceUrWszyscy = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatWszyscyDTO(CASE\n" +
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
                "                            COUNT(*) AS ile) FROM Wszyscy\n" +
                "                        GROUP BY 1\n" +
                "                        ORDER BY MONTH(data_ur)").list();

        transaction.commit();
        session.close();
        return miesiaceUrWszyscy;
    }

    public List<StatWszyscyDTO> znakiZodiakuWszyscy() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<StatWszyscyDTO> znakiZodiakuWszyscy = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatWszyscyDTO(znakZodiaku AS wynik, COUNT(*) AS ile) FROM ZnakiZodiakuWszyscy GROUP BY znak_zodiaku").list();

        transaction.commit();
        session.close();
        return znakiZodiakuWszyscy;
    }
}
