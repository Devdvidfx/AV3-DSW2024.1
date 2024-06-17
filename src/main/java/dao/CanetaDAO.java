package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Caneta;
import util.JPAUtil;

public class CanetaDAO {

	public static void salvar(Caneta caneta) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(caneta);
		em.getTransaction().commit();
		em.close();
	}

	public static void excluir(Integer id) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		Caneta caneta = em.find(Caneta.class, id);
		if (caneta != null) {
			em.remove(caneta);
		}
		em.getTransaction().commit();
		em.close();
	}

	public static List<Caneta> listar() {
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("SELECT c FROM Caneta c", Caneta.class);
		List<Caneta> canetasResul = (List<Caneta>) q.getResultList();
		for (Caneta cn : canetasResul) {
			System.out.println(cn.getMarca());
		}
		em.close();
		return canetasResul;
	}
	public static int contarPorCor(String cor) {
	    EntityManager em = JPAUtil.criarEntityManager();
	    Query q = em.createQuery("SELECT COUNT(c) FROM Caneta c WHERE c.cor = :cor");
	    q.setParameter("cor", cor);
	    int quantidade = ((Number) q.getSingleResult()).intValue();
	    em.close();
	    return quantidade;
	}

	
}
