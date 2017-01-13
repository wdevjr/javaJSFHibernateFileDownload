package br.com.warhjr.fachada;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.warhjr.dao.ArquivoDao;
import br.com.warhjr.dao.HibernateUtil;
import br.com.warhjr.entidades.Arquivo;



public class ArquivoFacadeImpl implements ArquivoFacade {

	private static final long serialVersionUID = 1818242808424001885L;
	//private static Arquivo p;
	private ArquivoDao arquivoDAO;
	private SessionFactory sf; 
	private	Session session;
	private Transaction tx;
	
	public void salva(Arquivo p) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		tx = session.beginTransaction();
		arquivoDAO = new ArquivoDao(session, Arquivo.class);
		
		this.arquivoDAO.save(p);
		
		tx.commit();
		session.close();
	}

	



	@Override
	public void remove(Arquivo p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Arquivo procura(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualiza(Arquivo p) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		tx = session.beginTransaction();
		
		arquivoDAO = new ArquivoDao(session, Arquivo.class);
		this.arquivoDAO.merge(p);
		
		tx.commit();
		session.close();
	}

	@Override
	public List<Arquivo> pesquisaArquivosByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Arquivo> lista() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		tx = session.beginTransaction();
		
		arquivoDAO = new ArquivoDao(session, Arquivo.class);
		
		List<Arquivo> lista = this.arquivoDAO.list();
		
		tx.commit();
		session.close();
		
		return lista;
	}



	@Override
	public boolean autentica(String email, String senha) {
		// TODO Auto-generated method stub
		return false;
	}





	@Override
	public void atualiza() {
		// TODO Auto-generated method stub
		
	}

}