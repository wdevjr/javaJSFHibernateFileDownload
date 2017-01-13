package br.com.warhjr.managedBean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.com.warhjr.entidades.Arquivo;
import br.com.warhjr.fachada.ArquivoFacade;
import br.com.warhjr.fachada.ArquivoFacadeImpl;



@ManagedBean(name = "FileManagedBean")
@RequestScoped
public class ArquivoManageBean {
	
	private Arquivo arquivos;

	private List<Arquivo> listararquivos;
	
	private Part arqu;
	//private static String caminhonome,nomedoarquivo;

	private ExternalContext externalContext;
	
	public Part getArqu() {
		return arqu;
	}
	
	public void setArqu(Part arqu) {
		this.arqu = arqu;
	}


	public ArquivoManageBean()
	{
		this.arquivos = new Arquivo();
		this.listararquivos = new ArrayList<Arquivo>();
	}


	public Arquivo getArquivos() {
		return arquivos;
	}

	public void setArquivos(Arquivo arquivos) {
		this.arquivos = arquivos;
	}


	public List<Arquivo> getListararquivos() {
		return listararquivos;
	}

	public void setListararquivos(List<Arquivo> listararquivos) {
		this.listararquivos = listararquivos;
	}
	
	public void enviar() {
		this.arquivos.setNomearquivo(arqu.getSubmittedFileName());
		
		save();
		String nomeArquivoSaida = "C:/Dados/" + arqu.getSubmittedFileName();
		//caminhonome=nomeArquivoSaida;
		//nomedoarquivo=arqu.getSubmittedFileName();
		try (InputStream is = arqu.getInputStream();
				OutputStream out = new FileOutputStream(nomeArquivoSaida)) {
			
            int read = 0;
            byte[] bytes = new byte[1024];
     
            while ((read = is.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

			adicionarMensagem(FacesMessage.SEVERITY_INFO, " enviado com sucesso.");
		} catch (IOException e) {
			adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Erro ao enviar arquivo.");
		}
	}
	private void adicionarMensagem(Severity nivel, String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(nivel, mensagem, mensagem));
	}

    public void save()
    {
    	ArquivoFacade arquivoService = new ArquivoFacadeImpl();
    	arquivoService.salva(this.arquivos);
    }
    
//    public void update()
//    {
//    	ArquivoFacade arquivoServ = new ArquivoFacadeImpl();
//    	this.arquivos.setIdarquivo(this.arquivo.getIdarquivo());
//    	this.arquivos.setDescricao(this.arquivo.getDescricao());
//    	this.arquivos.setNomearquivo(this.arquivo.getNomearquivo());
//    	
//    	arquivoServ.atualiza(this.arquivos);
//    	this.arquivos = new Arquivo();
//    	this.arquivo = new Arquivo();
//    }

    public List<Arquivo> getListarArquivos() {
    	
        return new ArquivoFacadeImpl().lista();
    
    }
    
    public void downloadFile(ActionEvent e) throws IOException {
        String nomedoarquivo =  (String) e.getComponent().getAttributes().get("carquivo");
        FacesContext ctx = null;
       // ExternalContext ectx = ctx.getExternalContext(); //aqui que esta dando erro ....
        File file = new File("C:/Dados/"+nomedoarquivo);
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();  
        //HttpServletResponse response = (HttpServletResponse) ectx.getResponse();
        response.setHeader("Content-Disposition", "attachment;filename="+nomedoarquivo);  
        response.setContentLength((int) file.length());  
        //ServletOutputStream out = null; 
       
        //resp.setContentType(mimeType);

          FileInputStream in = new FileInputStream(file);
          OutputStream out = response.getOutputStream();
          byte[] buf = new byte[(int) file.length()];
          int count;
          while ((count = in.read(buf)) >= 0) {
            out.write(buf, 0, count);
          }
          in.close();
          out.flush();
          out.close();
          //ctx.responseComplete();
          FacesContext.getCurrentInstance().getResponseComplete(); 

      }
   
        	

    }

