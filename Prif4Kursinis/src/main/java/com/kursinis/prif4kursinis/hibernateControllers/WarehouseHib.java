package com.kursinis.prif4kursinis.hibernateControllers;

import com.kursinis.prif4kursinis.model.Warehouse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;

import java.util.ArrayList;
import java.util.List;

public class WarehouseHib {
    private EntityManagerFactory entityManagerFactory;


    public WarehouseHib(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void createWarehouse(Warehouse warehouse) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(warehouse);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
        }
    }

    public void updateWarehouse(Warehouse warehouse) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(warehouse);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
        }
    }

    public void deleteWarehouse(int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Warehouse warehouse = null;
            try {
                warehouse = em.getReference(Warehouse.class, id);
                warehouse.getId();
            } catch (Exception e) {
                System.out.println("No such warehouse by given ID");
            }

            //Biski i ateiti, bet cia reikes nulinkint nuo susijusiu objektu, kad man leistu istrinti

            em.remove(warehouse);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
        }
    }

    public List<Warehouse> getAllWarehouse() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaQuery query = em.getCriteriaBuilder().createQuery();
            query.select(query.from(Warehouse.class));
            Query q = em.createQuery(query);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
        }
        return new ArrayList<>();
    }


    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }


}
