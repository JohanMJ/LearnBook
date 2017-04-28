package modelviews;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.br.model.Usuario;



public class RegisterForm {
	
	@Valid
	private Usuario usuario;
	
	@NotNull
	private String passwordConfirmation;
	

	public Usuario getUser() {
		return usuario;
	}

	public void setUser(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}	
	
}
