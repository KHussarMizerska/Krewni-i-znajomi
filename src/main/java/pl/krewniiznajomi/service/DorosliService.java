package pl.krewniiznajomi.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.krewniiznajomi.model.Dorosli;
import pl.krewniiznajomi.model.Rocznice;
import pl.krewniiznajomi.model.dto.StatDorosliDTO;
import pl.krewniiznajomi.model.dto.StatRoczniceDTO;
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

    public int ileDorosli() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        int ileDorosli = session.createSQLQuery("SELECT * FROM dorosli").list().size();

        transaction.commit();
        session.close();
        return ileDorosli;
    }

    public int ileDorosliK() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        int ileDorosliK = session.createSQLQuery("SELECT plec FROM dorosli WHERE plec = 'K'").list().size();

        transaction.commit();
        session.close();
        return ileDorosliK;
    }

    public int ileDorosliM() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        int ileDorosliM = session.createSQLQuery("SELECT plec FROM dorosli WHERE plec = 'M'").list().size();

        transaction.commit();
        session.close();
        return ileDorosliM;
    }

    public int ileBezDzieci() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        int ileBezDzieci = session.createSQLQuery("SELECT d.imie FROM dorosli d LEFT JOIN rodzice_dzieci rd ON (rd.id_dorosli = d.id_dorosli) WHERE ISNULL (rd.id_dorosli)").list().size();

        transaction.commit();
        session.close();
        return ileBezDzieci;
    }

    public int ile4dzieci() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        int ile4dzieci = session.createSQLQuery("SELECT * FROM (SELECT d.imie, d.nazwisko, count(d.id_dorosli) as liczba_dzieci\n" +
                "FROM dorosli AS d \n" +
                "INNER JOIN rodzice_dzieci AS rd ON rd.id_dorosli = d.id_dorosli \n" +
                "GROUP BY d.imie, d.nazwisko) as x\n" +
                "WHERE x.liczba_dzieci = 4").list().size();

        transaction.commit();
        session.close();
        return ile4dzieci;
    }

    public int ile3dzieci() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        int ile3dzieci = session.createSQLQuery("SELECT * FROM (SELECT d.imie, d.nazwisko, count(d.id_dorosli) as liczba_dzieci\n" +
                "FROM dorosli AS d \n" +
                "INNER JOIN rodzice_dzieci AS rd ON rd.id_dorosli = d.id_dorosli \n" +
                "GROUP BY d.imie, d.nazwisko) as x\n" +
                "WHERE x.liczba_dzieci = 3").list().size();

        transaction.commit();
        session.close();
        return ile3dzieci;
    }

    public int ile2dzieci() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        int ile2dzieci = session.createSQLQuery("SELECT * FROM (SELECT d.imie, d.nazwisko, count(d.id_dorosli) as liczba_dzieci\n" +
                "FROM dorosli AS d \n" +
                "INNER JOIN rodzice_dzieci AS rd ON rd.id_dorosli = d.id_dorosli \n" +
                "GROUP BY d.imie, d.nazwisko) as x\n" +
                "WHERE x.liczba_dzieci = 2").list().size();

        transaction.commit();
        session.close();
        return ile2dzieci;
    }

    public int ile1dziecko() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        int ile1dziecko = session.createSQLQuery("SELECT * FROM (SELECT d.imie, d.nazwisko, count(d.id_dorosli) as liczba_dzieci\n" +
                "FROM dorosli AS d \n" +
                "INNER JOIN rodzice_dzieci AS rd ON rd.id_dorosli = d.id_dorosli \n" +
                "GROUP BY d.imie, d.nazwisko) as x\n" +
                "WHERE x.liczba_dzieci = 1").list().size();

        transaction.commit();
        session.close();
        return ile1dziecko;
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

        List<StatDorosliDTO> znakiZodiakuDorosli = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatDorosliDTO(znakZodiaku AS wynik, COUNT(*) AS ile) FROM ZnakiZodiakuDorosli GROUP BY znak_zodiaku").list();

        transaction.commit();
        session.close();
        return znakiZodiakuDorosli;
    }

    public List<StatDorosliDTO> lataSlubu() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<StatDorosliDTO> lataSlubu = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatDorosliDTO(year(data_slubu) as rok, count(*) as " +
                "ile) FROM Rocznice GROUP BY 1 " +
                "ORDER BY ile DESC, rok").list();
        transaction.commit();
        session.close();
        return lataSlubu;
    }

    public List<StatDorosliDTO> miesiaceSlubu() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<StatDorosliDTO> miesiaceSlubu = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatDorosliDTO(CASE\n" +
                "                                WHEN (MONTH(data_slubu) = 1) THEN 'Styczeń'\n" +
                "                                WHEN (MONTH(data_slubu) = 2) THEN 'Luty'\n" +
                "                                WHEN (MONTH(data_slubu) = 3) THEN 'Marzec'\n" +
                "                                WHEN (MONTH(data_slubu) = 4) THEN 'Kwiecień'\n" +
                "                                WHEN (MONTH(data_slubu) = 5) THEN 'Maj'\n" +
                "                                WHEN (MONTH(data_slubu) = 6) THEN 'Czerwiec'\n" +
                "                                WHEN (MONTH(data_slubu) = 7) THEN 'Lipiec'\n" +
                "                                WHEN (MONTH(data_slubu) = 8) THEN 'Sierpień'\n" +
                "                                WHEN (MONTH(data_slubu) = 9) THEN 'Wrzesień'\n" +
                "                                WHEN (MONTH(data_slubu) = 10) THEN 'Październik'\n" +
                "                                WHEN (MONTH(data_slubu) = 11) THEN 'Listopad'\n" +
                "                                WHEN (MONTH(data_slubu) = 12) THEN 'Grudzień'\n" +
                "                            END,\n" +
                "                            COUNT(*) AS ile) FROM Rocznice\n" +
                "                        GROUP BY 1\n" +
                "                        ORDER BY MONTH(data_slubu)").list();

        transaction.commit();
        session.close();
        return miesiaceSlubu;
    }

    public List<StatDorosliDTO> dniTygSlubu() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<StatDorosliDTO> dniTygSlubu = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatDorosliDTO(CASE\n" +
                "        WHEN (DAYOFWEEK(data_slubu) = 1) THEN 'Niedziela'\n" +
                "        WHEN (DAYOFWEEK(data_slubu) = 2) THEN 'Poniedziałek'\n" +
                "        WHEN (DAYOFWEEK(data_slubu) = 3) THEN 'Wtorek'\n" +
                "        WHEN (DAYOFWEEK(data_slubu) = 4) THEN 'Środa'\n" +
                "        WHEN (DAYOFWEEK(data_slubu) = 5) THEN 'Czwartek'\n" +
                "        WHEN (DAYOFWEEK(data_slubu) = 6) THEN 'Piątek'\n" +
                "        WHEN (DAYOFWEEK(data_slubu) = 7) THEN 'Sobota'\n" +
                "\tEND,\n" +
                "    COUNT(*) AS ile) FROM Rocznice\n" +
                "GROUP BY 1\n" +
                "ORDER BY DAYOFWEEK(data_slubu)").list();

        transaction.commit();
        session.close();
        return dniTygSlubu;
    }

    public List<StatDorosliDTO> dniMiesSlubu() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<StatDorosliDTO> dniMiesSlubu = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.StatDorosliDTO(DAY(data_slubu) AS wynik, COUNT(*) AS ile) FROM Rocznice GROUP BY DAY(data_slubu) ORDER BY DAY(data_slubu)").list();

        transaction.commit();
        session.close();
        return dniMiesSlubu;
    }
}