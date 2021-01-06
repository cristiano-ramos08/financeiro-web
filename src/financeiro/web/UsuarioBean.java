package financeiro.web;

//import java.util.ArrayList;
//import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
//import javax.faces.model.SelectItem;

import financeiro.usuario.Usuario;
import financeiro.usuario.UsuarioRN;

@ManagedBean(name="usuarioBean")
@RequestScoped
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private String confirmarSenha;
/*	private List<SelectItem> idiomas;

	public List<SelectItem> getIdiomas() {
		if (this.idiomas == null) {
			this.idiomas = new ArrayList<SelectItem>();
			this.idiomas.add(new SelectItem("pt_BR", "Português"));
			this.idiomas.add(new SelectItem("en_US", "English"));
			this.idiomas.add(new SelectItem("es_ES", "Espanol"));

		}
		return idiomas;

	}*/
	
	public String novo() { 
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "usuario"; 
	}
	public String salvar() { 
		FacesContext context = FacesContext.getCurrentInstance();

		String senha = this.usuario.getSenha();
		if (!senha.equals(this.confirmarSenha)) { 
			FacesMessage facesMessage = new FacesMessage("A senha não foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null; 
		}

		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario); 

		return "usuarioSucesso"; 
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}


}