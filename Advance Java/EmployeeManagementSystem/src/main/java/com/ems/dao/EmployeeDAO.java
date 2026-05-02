package com.ems.dao;

import com.ems.entity.Employee;
import com.ems.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDAO {

    // 1. INSERT (HQL does not support normal insert values, so we use persist/save)
    public void insert(Employee emp) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            // new (recommended)
            session.persist(emp);

            // old (deprecated style)
            // session.save(emp);

            tx.commit();
            System.out.println("Inserted");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println(e.getMessage());
        }
    }

    // 2. GET BY ID using HQL
    public Employee getById(int id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<Employee> q = session.createQuery(
                    "from Employee where id = :id",
                    Employee.class
            );

            q.setParameter("id", id);

            // new
            return q.uniqueResult();

            // alternative
            // return q.getSingleResult();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // 3. GET ALL
    public List<Employee> getAll() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<Employee> q = session.createQuery(
                    "from Employee",
                    Employee.class
            );

            // new
            return q.list();

            // alternative
            // return q.getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // 4. UPDATE FULL EMPLOYEE (HQL)
    public void updateEmployee(Employee emp) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            // new (Hibernate 6)
            MutationQuery q = session.createMutationQuery(
                    "update Employee set " +
                            "firstName=:fn, lastName=:ln, email=:em, phone=:ph, " +
                            "department=:dept, designation=:des, salary=:sal, gender=:gen, " +
                            "dateOfJoining=:doj, city=:city, state=:state, country=:country " +
                            "where id=:id"
            );

            // old
            // Query<?> q = session.createQuery("update Employee set ...");

            q.setParameter("fn", emp.getFirstName());
            q.setParameter("ln", emp.getLastName());
            q.setParameter("em", emp.getEmail());
            q.setParameter("ph", emp.getPhone());
            q.setParameter("dept", emp.getDepartment());
            q.setParameter("des", emp.getDesignation());
            q.setParameter("sal", emp.getSalary());
            q.setParameter("gen", emp.getGender());
            q.setParameter("doj", emp.getDateOfJoining());
            q.setParameter("city", emp.getCity());
            q.setParameter("state", emp.getState());
            q.setParameter("country", emp.getCountry());
            q.setParameter("id", emp.getId());

            q.executeUpdate();

            tx.commit();
            System.out.println("Updated");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println(e.getMessage());
        }
    }

    // 5. UPDATE SALARY
    public void updateSalary(int id, double salary) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            MutationQuery q = session.createMutationQuery(
                    "update Employee set salary = :sal where id = :id"
            );

            // old
            // Query<?> q = session.createQuery("update Employee set salary = :sal where id = :id");

            q.setParameter("sal", salary);
            q.setParameter("id", id);

            q.executeUpdate();

            tx.commit();
            System.out.println("Salary updated");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println(e.getMessage());
        }
    }

    // 6. DELETE BY ID
    public void delete(int id) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            MutationQuery q = session.createMutationQuery(
                    "delete from Employee where id = :id"
            );

            // old
            // Query<?> q = session.createQuery("delete from Employee where id = :id");

            q.setParameter("id", id);

            q.executeUpdate();

            tx.commit();
            System.out.println("Deleted");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println(e.getMessage());
        }
    }

    // 7. GET BY DEPARTMENT
    public List<Employee> getByDepartment(String dept) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<Employee> q = session.createQuery(
                    "from Employee where department = :dept",
                    Employee.class
            );

            q.setParameter("dept", dept);

            return q.list();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // 8. GET BY CITY
    public List<Employee> getByCity(String city) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<Employee> q = session.createQuery(
                    "from Employee where city = :city",
                    Employee.class
            );

            q.setParameter("city", city);

            return q.list();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // 9. GET BY SALARY > X
    public List<Employee> getBySalaryGreaterThan(double salary) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<Employee> q = session.createQuery(
                    "from Employee where salary > :sal",
                    Employee.class
            );

            q.setParameter("sal", salary);

            return q.list();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // 10. SORT BY SALARY DESC
    public List<Employee> sortBySalaryDesc() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<Employee> q = session.createQuery(
                    "from Employee order by salary desc",
                    Employee.class
            );

            return q.list();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // 11. COUNT
    public long countEmployees() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<Long> q = session.createQuery(
                    "select count(e) from Employee e",
                    Long.class
            );

            Long count = q.uniqueResult();

            return count != null ? count : 0;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // 12. BULK UPDATE (salary increase)
    public void increaseSalaryByDepartment(String dept, double percent) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            MutationQuery q = session.createMutationQuery(
                    "update Employee set salary = salary + (salary * :p / 100) where department = :d"
            );

            q.setParameter("p", percent);
            q.setParameter("d", dept);

            q.executeUpdate();

            tx.commit();
            System.out.println("Bulk updated");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println(e.getMessage());
        }
    }
}