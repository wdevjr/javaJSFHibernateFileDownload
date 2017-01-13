package br.com.warhjr.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import br.com.warhjr.entidades.Arquivo;

public class ArquivoDao extends DAO<Arquivo>{
	
	private ArquivoDao arquivoDao;
	
    public void salvar(Arquivo arquivo){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		tx = session.beginTransaction();
		
       session.save(arquivo);
       arquivoDao = new ArquivoDao(session, Arquivo.class);
		tx.commit();
		session.close();
       System.out.println("Salvo com sucesso");
   }
   
   public List<Arquivo> listar(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		tx = session.beginTransaction();
       String sql = "SELECT p FROM arquivo p";
       return (List<Arquivo>) session.createQuery(sql).list();
   }
   
	public ArquivoDao(Session session, Class<?> classe) {
		super(session, classe);
	}
}
