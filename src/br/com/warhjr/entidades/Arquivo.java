package br.com.warhjr.entidades;

import javax.persistence.*;


@Entity
@Table(name="tb_arquivo")
public class Arquivo{
     @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
     @Column(name="arquivo_id")
     private int idarquivo;
     @Column(name="arquivo_nome")
     private String nomearquivo;
     @Column(name="arquivo_descricao")
     private String descricao;
     
    public Arquivo() {
    }

	public int getIdarquivo() {
		return idarquivo;
	}

	public void setIdarquivo(int idarquivo) {
		this.idarquivo = idarquivo;
	}

	public String getNomearquivo() {
		return nomearquivo;
	}

	public void setNomearquivo(String nomearquivo) {
		this.nomearquivo = nomearquivo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
    
    
}