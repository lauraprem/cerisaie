package metier;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Client;

/**
 * Session Bean implementation class CerisaieBean
 */
@Stateless(mappedName = "GestCerisaie")
@Remote(CerisaieBeanRemote.class)
public class CerisaieBean implements CerisaieBeanRemote {

	@PersistenceContext(unitName = "JPAMavenCerisaie")
	private EntityManager em;

	public void ajouter(Client unclient) throws NamingException {
		try {
			em.persist(unclient);
		} catch (Exception ne) {
			System.out.println(ne.getMessage());
			throw ne;
		}
	}

	public Client rechercherClient(String id) throws NamingException {
		try {
			return em.find(Client.class, id);
		} catch (Exception ne) {
			System.out.println(ne.getMessage());
			throw ne;
		}
	}

	public List<Client> listerTousLesClients() throws NamingException {
		try {
			return em.createQuery("SELECT c FROM Client c ORDER BY c.nomCli").getResultList();
		} catch (Exception ne) {
			System.out.println(ne.getMessage());
			throw ne;
		}
	}

	/**
	* Default constructor.
	*/
	public CerisaieBean() {
		// TODO Auto-generated constructor stub
	}

}
