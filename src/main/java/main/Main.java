package main;

import beans.Department;
import beans.Employee;
import hibernateutils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println(session);

        try {

            Department department=new Department();
            department.setName("AIIt");


            Employee employee=new Employee();
            employee.setAddr("Patna");
            employee.setName("Saket kUmar keshri");

            Employee employee1=new Employee();
            employee1.setName("Name");
            employee1.setAddr("DAnapur");

            List<Employee> employeeList=new ArrayList<>();
            employeeList.add(employee);
            employeeList.add(employee1);


            department.setEmployeeList(employeeList);

            //session.persist(department);

            Department department1=(Department) session.get(Department.class,Integer.parseInt("1"));
            System.out.println(department1.getEmployeeList());

            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }


    }
}
