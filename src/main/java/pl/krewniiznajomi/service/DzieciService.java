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

    public int ileDzieci() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        int ileDzieci = session.createSQLQuery("SELECT * FROM dzieci").list().size();

        transaction.commit();
        session.close();
        return ileDzieci;
    }

    public int ileDzieciK() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        int ileDzieciK= session.createSQLQuery("SELECT plec FROM dzieci WHERE plec = 'K'").list().size();

        transaction.commit();
        session.close();
        return ileDzieciK;
    }

    public int ileDzieciM() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        int ileDzieciM= session.createSQLQuery("SELECT plec FROM dzieci WHERE plec = 'M'").list().size();

        transaction.commit();
        session.close();
        return ileDzieciM;
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

        List<StatDzieciDTO> dniTygUrDzieci = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatDzieciDTO(CASE\n" +
                "        WHEN (DAYOFWEEK(data_ur) = 1) THEN 'Niedziela'\n" +
                "        WHEN (DAYOFWEEK(data_ur) = 2) THEN 'Poniedziałek'\n" +
                "        WHEN (DAYOFWEEK(data_ur) = 3) THEN 'Wtorek'\n" +
                "        WHEN (DAYOFWEEK(data_ur) = 4) THEN 'Środa'\n" +
                "        WHEN (DAYOFWEEK(data_ur) = 5) THEN 'Czwartek'\n" +
                "        WHEN (DAYOFWEEK(data_ur) = 6) THEN 'Piątek'\n" +
                "        WHEN (DAYOFWEEK(data_ur) = 7) THEN 'Sobota'\n" +
                "\tEND,\n" +
                "    COUNT(*) AS ile) FROM Dzieci\n" +
                "GROUP BY 1\n" +
                "ORDER BY DAYOFWEEK(data_ur)").list();

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

    public List<StatDzieciDTO> miesiaceUrDzieci() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<StatDzieciDTO> miesiaceUrDzieci = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatDzieciDTO(CASE\n" +
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
                "                            COUNT(*) AS ile) FROM Dzieci\n" +
                "                        GROUP BY 1\n" +
                "                        ORDER BY MONTH(data_ur)").list();

        transaction.commit();
        session.close();
        return miesiaceUrDzieci;
    }

    public List<StatDzieciDTO> znakiZodiakuDzieci() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<StatDzieciDTO> znakiZodiakuDzieci = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatDzieciDTO(znakZodiaku AS wynik, COUNT(*) AS ile) FROM ZnakiZodiakuDzieci GROUP BY znak_zodiaku").list();

        transaction.commit();
        session.close();
        return znakiZodiakuDzieci;
    }

    public int ileDzieciPrzed30Matki() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        int ileDzieciPrzed30Matki = session.createSQLQuery("SELECT d.imie, d.nazwisko, year(d.data_ur), year(dz.data_ur), TIMESTAMPDIFF(year, d.data_ur, dz.data_ur) \n" +
                "FROM dorosli AS d\n" +
                "LEFT JOIN rodzice_dzieci AS rd ON rd.id_dorosli = d.id_dorosli\n" +
                "INNER JOIN dzieci AS dz ON rd.id_dzieci = dz.id_dzieci\n" +
                "WHERE rd.id_dorosli IS NOT NULL AND TIMESTAMPDIFF(year, d.data_ur, dz.data_ur) < 30 AND d.plec = 'K'").list().size();

        transaction.commit();
        session.close();
        return ileDzieciPrzed30Matki;
    }

    public int ileDzieciPo30Matki() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        int ileDzieciPo30Matki = session.createSQLQuery("SELECT d.imie, d.nazwisko, year(d.data_ur), year(dz.data_ur), TIMESTAMPDIFF(year, d.data_ur, dz.data_ur) \n" +
                "FROM dorosli AS d\n" +
                "LEFT JOIN rodzice_dzieci AS rd ON rd.id_dorosli = d.id_dorosli\n" +
                "INNER JOIN dzieci AS dz ON rd.id_dzieci = dz.id_dzieci\n" +
                "WHERE rd.id_dorosli IS NOT NULL AND TIMESTAMPDIFF(year, d.data_ur, dz.data_ur) >= 30 AND d.plec = 'K'").list().size();

        transaction.commit();
        session.close();
        return ileDzieciPo30Matki;
    }

    public int ileDzieciPrzed30Ojca() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        int ileDzieciPrzed30Ojca = session.createSQLQuery("SELECT d.imie, d.nazwisko, year(d.data_ur), year(dz.data_ur), TIMESTAMPDIFF(year, d.data_ur, dz.data_ur) \n" +
                "FROM dorosli AS d\n" +
                "LEFT JOIN rodzice_dzieci AS rd ON rd.id_dorosli = d.id_dorosli\n" +
                "INNER JOIN dzieci AS dz ON rd.id_dzieci = dz.id_dzieci\n" +
                "WHERE rd.id_dorosli IS NOT NULL AND TIMESTAMPDIFF(year, d.data_ur, dz.data_ur) < 30 AND d.plec = 'M'").list().size();

        transaction.commit();
        session.close();
        return ileDzieciPrzed30Ojca;
    }

    public int ileDzieciPo30Ojca() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        int ileDzieciPo30Ojca = session.createSQLQuery("SELECT d.imie, d.nazwisko, year(d.data_ur), year(dz.data_ur), TIMESTAMPDIFF(year, d.data_ur, dz.data_ur) \n" +
                "FROM dorosli AS d\n" +
                "LEFT JOIN rodzice_dzieci AS rd ON rd.id_dorosli = d.id_dorosli\n" +
                "INNER JOIN dzieci AS dz ON rd.id_dzieci = dz.id_dzieci\n" +
                "WHERE rd.id_dorosli IS NOT NULL AND TIMESTAMPDIFF(year, d.data_ur, dz.data_ur) >= 30 AND d.plec = 'M'").list().size();

        transaction.commit();
        session.close();
        return ileDzieciPo30Ojca;
    }
}