package com.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;

public class EmployeeDao {

	

		public void insertData() {

			Configuration cfg = new Configuration();
			cfg.configure();
			cfg.addAnnotatedClass(Employee.class);

			SessionFactory sf = cfg.buildSessionFactory();
			Session ss = sf.openSession();
			Transaction tr = ss.beginTransaction();

			Employee e = new Employee();
			e.setempName("mangesh");
			e.setCity("goa");
			e.setSalary("32LPA");
			e.setEmail("mangesh@gmail.com");

		ss.save(e);
			ss.persist(e);

			tr.commit();
			ss.close();
			System.out.println("Data is Inserted ... !");
		}

		public void deleteData() {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(Employee.class);

			SessionFactory sf = cfg.buildSessionFactory();
			Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

			int id = 126;
			Employee e = ss.get(Employee.class, id);

			ss.delete(e);
			ss.remove(e);

			tr.commit();
			ss.close();

			System.out.println("Data is Deleted... ! ");

	}

		public void updateData() {

			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(Employee.class);

			SessionFactory sf = cfg.buildSessionFactory();
			Session ss = sf.openSession();
			Transaction tr = ss.beginTransaction();

			int id = 124;
			Employee e = ss.load(Employee.class, id);

			e.setCity("nagpur");
			e.setempName("raj");
			
			e.setSalary("48LPA");
			

			ss.update(e)
			ss.merge(e);
			System.out.println("Data is insert data..");
			tr.commit();
			ss.close();

		}
		
}


