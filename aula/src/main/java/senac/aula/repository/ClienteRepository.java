package senac.aula.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import senac.aula.model.Cliente;

public class ClienteRepository {
	
	EntityManagerFactory emf = Persistence.
		createEntityManagerFactory("aula-senac-poo");

	public void cadastrar(Cliente cliente) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void deletar(Integer id) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.remove(id);
		entityManager.close();
	}
		
	public void editar(Cliente cliente) {
		if (cliente != null && cliente.getId() == null) {
			//erro
		}
		
		EntityManager entityManager = emf.createEntityManager();
		entityManager.persist(cliente);
		entityManager.close();
	}
	
	public List<Cliente> listar() {
		EntityManager entityManager = emf.createEntityManager();
		Query query = entityManager.
				createQuery("select c from Cliente c");
		List<Cliente> clientes = query.getResultList();
		entityManager.close();
		return clientes;
	}
	
	public Cliente buscar(Integer id) {
		return null;
	}	
}
