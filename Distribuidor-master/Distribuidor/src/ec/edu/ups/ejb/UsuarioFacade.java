package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario>{

	@PersistenceContext(unitName = "Distribuidor")
	private EntityManager em;
	

	public UsuarioFacade() {
		super(Usuario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Rol buscarRol(String nombre){
		Rol rol=new Rol();
		String sql="SELECT p FROM Rol p where p.nombre='"+nombre+"'";
		rol = (Rol) em.createQuery(sql).getSingleResult();
		return rol;
	}
	
	public Usuario inicio(String username, String password) {
    	Usuario us=new Usuario();
   	 String query = "SELECT e " +
   		      "FROM Usuario e " +
   		      "WHERE e.correo = '" + username +
   		      "' AND " +
   		      " e.contraseña = '" + password + "'";
      	us =em.createQuery(query, Usuario.class).getSingleResult();
   		      return us;
   }

	public List<Usuario> muestraClientes() {
		String sql="SELECT u FROM Usuario u where u.roles.nombre = 'cliente'";
		List<Usuario> list = em.createQuery(sql).getResultList();
		System.out.println("Lista persona:" + list);
		return list;
   }
	
	public Usuario inicioo(String username, String password) {
    	Usuario us=new Usuario();
   	 String query = "SELECT e " +
   		      "FROM Usuario e " +
   		      "WHERE e.estado='A' AND  e.correo = '" + username +
   		      "' AND " +
   		      " e.contraseña = '" + password + "'";
      	us =em.createQuery(query, Usuario.class).getSingleResult();
   		      return us;
   }

	public void elimina(int id) {
    	//Usuario usu=new Usuario();
   	 String query = "UPDATE Usuario e " +
   		      "SET e.estado='E' " +
   		      "WHERE  e.id=" + id;
   	 System.out.println(query);
   	em.createQuery(query).executeUpdate();
   }
	
	public void acti(int id) {
    	//Usuario usu=new Usuario();
   	 String query = "UPDATE Usuario e " +
   		      "SET e.estado='A' " +
   		      "WHERE  e.id=" + id;
   	 System.out.println(query);
   	em.createQuery(query).executeUpdate();
   }
	//SELECT ID FROM distribuidora.persona WHERE CORREO='kevin@gmail';
	
	
	public Usuario buscarid(String correo) {
    	Usuario us=new Usuario();
   	 String query = "SELECT e " +
  		      "FROM Usuario e " +
  		      "WHERE  e.correo = '" + correo + "'";
      	us =em.createQuery(query,Usuario.class).getSingleResult();
      	System.out.println(query);
   	return us;
   }

	
	

}
