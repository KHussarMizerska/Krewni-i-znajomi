package pl.krewniiznajomi.service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pl.krewniiznajomi.model.Dorosli;
import pl.krewniiznajomi.model.FiltrWszyscyView;
import pl.krewniiznajomi.model.Wszyscy;
import pl.krewniiznajomi.utils.HibernateUtils;

import java.util.List;

public class WszyscyService {

    public List<Wszyscy> pokazWszyscy(){

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Wszyscy> wszyscy = session.createSQLQuery("SELECT * FROM wszyscy").addEntity(Wszyscy.class).list();

        transaction.commit();
        session.close();
        return wszyscy;
    }

    public List<Wszyscy> filtruj(FiltrWszyscyView filtr) {

        Session session = HibernateUtils.getSessionFactory().openSession();

        Criteria criteria = session.createCriteria(Wszyscy.class); // do robienia filtra - więcej materiałów w necie

        if (filtr.getImie()!= null && !"".equals(filtr.getImie())) {
            criteria.add(Restrictions.like("imie", "%"+filtr.getImie()+"%")); //eq - to jest equals; like - żeby szukać fragmentu tekstu plus procenty w odpowiednim miejscu
        }

        if (filtr.getNazwisko()!= null && !"".equals(filtr.getNazwisko())) {
            criteria.add(Restrictions.like("nazwisko", "%"+filtr.getNazwisko()+"%")); //eq - to jest equals; like - żeby szukać fragmentu tekstu plus procenty w odpowiednim miejscu
        }


        List<Wszyscy> filtrWszyscy = criteria.list();

        session.close();
        return filtrWszyscy;
    }
}


