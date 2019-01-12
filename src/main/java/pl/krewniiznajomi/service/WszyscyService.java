package pl.krewniiznajomi.service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pl.krewniiznajomi.model.Dorosli;
import pl.krewniiznajomi.model.FiltrWszyscyView;
import pl.krewniiznajomi.model.Wszyscy;
import pl.krewniiznajomi.model.dto.WszyscyDTO;
import pl.krewniiznajomi.utils.HibernateUtils;

import java.util.List;

public class WszyscyService {

    public List<WszyscyDTO> pokazWszyscy(){

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<WszyscyDTO> wszyscy = session.createQuery("SELECT new pl.krewniiznajomi.model.dto.WszyscyDTO(imie, nazwisko, dataUr) FROM Wszyscy").list();

        transaction.commit();
        session.close();
        return wszyscy;
    }

    public List<WszyscyDTO> filtruj(FiltrWszyscyView filtr) {

        Session session = HibernateUtils.getSessionFactory().openSession();

        Criteria criteria = session.createCriteria(Wszyscy.class); // do robienia filtra - więcej materiałów w necie

        if (filtr.getImie()!= null && !"".equals(filtr.getImie())) {
            criteria.add(Restrictions.like("imie", "%"+filtr.getImie()+"%")); //eq - to jest equals; like - żeby szukać fragmentu tekstu plus procenty w odpowiednim miejscu
        }

        if (filtr.getNazwisko()!= null && !"".equals(filtr.getNazwisko())) {
            criteria.add(Restrictions.like("nazwisko", "%"+filtr.getNazwisko()+"%")); //eq - to jest equals; like - żeby szukać fragmentu tekstu plus procenty w odpowiednim miejscu
        }

        List<WszyscyDTO> filtrWszyscy = criteria.list();

        session.close();
        return filtrWszyscy;
    }
}


