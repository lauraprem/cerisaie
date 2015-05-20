package metier;

import java.util.List;

import javax.ejb.Remote;
import javax.naming.NamingException;

import model.Client;

@Remote
public interface CerisaieBeanRemote  {

	public void ajouter(Client c) throws NamingException, Exception;
	public Client rechercherClient(String id) throws NamingException, Exception;
	public List<Client> listerTousLesClients() throws NamingException,Exception;

}
