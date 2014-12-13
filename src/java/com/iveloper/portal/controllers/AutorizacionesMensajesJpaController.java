/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.portal.controllers;

import com.iveloper.portal.controllers.exceptions.NonexistentEntityException;
import com.iveloper.portal.controllers.exceptions.RollbackFailureException;
import com.iveloper.portal.entities.AutorizacionesMensajes;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author alexbonilla
 */
public class AutorizacionesMensajesJpaController implements Serializable {

    public AutorizacionesMensajesJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AutorizacionesMensajes autorizacionesMensajes) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(autorizacionesMensajes);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AutorizacionesMensajes autorizacionesMensajes) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            autorizacionesMensajes = em.merge(autorizacionesMensajes);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = autorizacionesMensajes.getAutorizacionesMensajesId();
                if (findAutorizacionesMensajes(id) == null) {
                    throw new NonexistentEntityException("The autorizacionesMensajes with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            AutorizacionesMensajes autorizacionesMensajes;
            try {
                autorizacionesMensajes = em.getReference(AutorizacionesMensajes.class, id);
                autorizacionesMensajes.getAutorizacionesMensajesId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The autorizacionesMensajes with id " + id + " no longer exists.", enfe);
            }
            em.remove(autorizacionesMensajes);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AutorizacionesMensajes> findAutorizacionesMensajesEntities() {
        return findAutorizacionesMensajesEntities(true, -1, -1);
    }

    public List<AutorizacionesMensajes> findAutorizacionesMensajesEntities(int maxResults, int firstResult) {
        return findAutorizacionesMensajesEntities(false, maxResults, firstResult);
    }

    private List<AutorizacionesMensajes> findAutorizacionesMensajesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AutorizacionesMensajes.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public AutorizacionesMensajes findAutorizacionesMensajes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AutorizacionesMensajes.class, id);
        } finally {
            em.close();
        }
    }

    public int getAutorizacionesMensajesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AutorizacionesMensajes> rt = cq.from(AutorizacionesMensajes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
