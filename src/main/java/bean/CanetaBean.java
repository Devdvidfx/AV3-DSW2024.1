package bean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import dao.CanetaDAO;
import entidade.Caneta;

@ManagedBean
public class CanetaBean {
	private Caneta caneta = new Caneta();
	private List<Caneta> canetas;

	public Caneta getCaneta() {
		return caneta;
	}

	public void setCaneta(Caneta caneta) {
		this.caneta = caneta;
	}

	public List<Caneta> getCanetas() {
		if (canetas == null) {
			canetas = CanetaDAO.listar();
		}
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, buildQuantityByColor(canetas), null);
		FacesContext.getCurrentInstance().addMessage("message2", msg);
		return canetas;
	}

	public void salvar() {
		CanetaDAO.salvar(caneta);
		caneta = new Caneta();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Caneta salva com sucesso", null);
		FacesContext.getCurrentInstance().addMessage("message0", msg);
	}

	public void excluir(Integer id) {
		CanetaDAO.excluir(id);
		getCanetas();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "A Caneta foi excluída", null);
		FacesContext.getCurrentInstance().addMessage("message1", msg);
	}

	public void selecionar(Caneta caneta) {
		FacesContext.getCurrentInstance().addMessage("message1",
				new FacesMessage("A caneta foi selecionada:" + caneta.getMarca() + " - " + caneta.getModelo()));
	}

	public String buildQuantityByColor(List<Caneta> canetas) {
	    int quantityPreta = 0;
	    int quantityAzul = 0;
	    int quantityVermelha = 0;
	    
	    for (Caneta cn : canetas) {
	        String cor = cn.getCor();
	        System.out.println(cor);
	        if (cor.equals("azul")) {
	            quantityAzul++;
	        } else if (cor.equals("preta")) {
	            quantityPreta++;
	        } else if (cor.equals("vermelha")) { 
	            quantityVermelha++;
	        }
	    }
	    
	    return "A quantidade de Canetas Azul é: " + quantityAzul + ";" + 
	           "A quantidade de Canetas Preta é: " + quantityPreta + ";" + 
	           "A quantidade de Canetas Vermelha é: " + quantityVermelha + ".";
	}
}