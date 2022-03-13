package com.example.using_spring_jpa_store_procedure.repositorty;

import com.example.using_spring_jpa_store_procedure.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
@Repository
public class CustomerRepository implements ICustomerRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        String sql = "CALL Insert_Customer(:first_name, :last_name)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("first_name", customer.getFirstName());
        query.setParameter("last_name", customer.getLastName());
        return query.executeUpdate() == 0;
    }
}
