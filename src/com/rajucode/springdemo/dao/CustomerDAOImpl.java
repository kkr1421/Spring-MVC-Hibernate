package com.rajucode.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.rajucode.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// Get the hibernate session
		Session session = sessionFactory.getCurrentSession();
		// Create query
		Query<Customer> query = session.createQuery("from Customer order by first_name", Customer.class);
		// Execute query
		List<Customer> customers = query.getResultList();
		return customers;

	}

	@Override
	public void saveCustomer(Customer objCustomer) {
		// Get the hibernate session
		Session session = sessionFactory.getCurrentSession();
		// save or update customer
		session.saveOrUpdate(objCustomer);

	}

	@Override
	public Customer getCustomer(int custId) {
		Session session = sessionFactory.getCurrentSession();
		Customer objCust = session.get(Customer.class, custId);
		return objCust;
	}

	@Override
	public void deleteCustomer(int custId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Customer c where id=:custId";
		Query query = session.createQuery(hql).setParameter("custId", custId);
		query.executeUpdate();
	}

	@Override
	public List<Customer> getCustomersBySearchVal(String searchVal) {
		// Get the hibernate session
		Session session = sessionFactory.getCurrentSession();
		// Create query
		Query<Customer> query = session.createQuery(
				"from Customer where "
						+ "(first_name like:searchVal or last_name like:searchVal or email like:searchVal) order by first_name",
				Customer.class);
		query.setParameter("searchVal", "%" + searchVal + "%");
		// Execute query
		List<Customer> customers = query.getResultList();
		return customers;
	}

}
