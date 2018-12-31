package pl.krewniiznajomi.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.krewniiznajomi.model.User;
import pl.krewniiznajomi.utils.HibernateUtils;

import java.util.List;

public class UserService {

    public List<User> pobierzUser() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<User> users = session.createQuery("Select u FROM User u").list();

        transaction.commit();
        session.close();
        return users;
    }

    public void zapisz(User user) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);

        transaction.commit();
        session.close();
    }

    // metoda do logowania bez użycia DB Connectora (JDBC) - wtedy trzeba usunąć folder database (w sumie powinno być to w LoginService, tu upraszcamy
    public User login(String login, String password) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT u FROM User u WHERE u.login=:login AND u.password=:pass");
        query.setString("login", login);
        query.setString("pass", password);
        query.setMaxResults(1);
        User zalogowanyUser = (User) query.uniqueResult(); // w nawiasie jest castowanie na typ obiektowy User

        transaction.commit();
        session.close();
        return zalogowanyUser;
    }

}
