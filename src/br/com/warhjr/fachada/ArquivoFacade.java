package br.com.warhjr.fachada;

import java.util.List;

import br.com.warhjr.entidades.Arquivo;

public interface ArquivoFacade extends BaseFacade<Arquivo>{
	public void salva(Arquivo p);

	public void remove(Arquivo p);
	
	public Arquivo procura(int id);

	public void atualiza(Arquivo p);
	
	public List<Arquivo> pesquisaArquivosByNome(String nome);
	
	public boolean autentica(String email, String senha);

	void atualiza();
}