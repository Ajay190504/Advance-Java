package hibernateIntro.project.dao;

import hibernateIntro.project.entity.Users;
import hibernateIntro.project.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UsersDAO {

    // INSERT
    public boolean insert(Users user) {
        Transaction tx = null;

        try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
            tx = ss.beginTransaction();

            ss.persist(user);

            tx.commit();
            return true;

        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            System.out.println("Insert failed: " + e.getMessage());
            return false;
        }
    }

    // UPDATE (using merge - detached object)
    public boolean update(Users user) {
        Transaction tx = null;

        try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
            tx = ss.beginTransaction();

            Users existing = ss.find(Users.class, user.getId());

            if (existing == null) {
                System.out.println("User not found.");
                if (tx != null && tx.isActive()) tx.rollback();
                return false;
            }

            ss.merge(user);

            tx.commit();
            return true;

        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            System.out.println("Update failed: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean delete(int id) {
        Transaction tx = null;

        try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
            tx = ss.beginTransaction();

            Users user = ss.find(Users.class, id);

            if (user == null) {
                System.out.println("User not found.");
                if (tx != null && tx.isActive()) tx.rollback();
                return false;
            }

            ss.remove(user);

            tx.commit();
            return true;

        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            System.out.println("Delete failed: " + e.getMessage());
            return false;
        }
    }

    // GET BY ID
    public Users getById(int id) {
        try (Session ss = HibernateUtil.getSessionFactory().openSession()) {

            Users user = ss.find(Users.class, id);

            if (user == null) {
                System.out.println("User not found.");
            }

            return user;

        } catch (Exception e) {
            System.out.println("Fetch failed: " + e.getMessage());
            return null;
        }
    }

    // GET ALL
    public List<Users> getAll() {
        try (Session ss = HibernateUtil.getSessionFactory().openSession()) {

            List<Users> users = ss
                    .createQuery("select u from Users u", Users.class)
                    .list();

            if (users.isEmpty()) {
                System.out.println("No users present.");
            }

            return users;

        } catch (Exception e) {
            System.out.println("Fetch all failed: " + e.getMessage());
            return List.of(); // never return null
        }
    }
}