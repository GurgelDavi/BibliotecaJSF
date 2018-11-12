package com.davielucas.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.davielucas.impl.AdminsDAO;
import com.davielucas.impl.UserDaoImpl;
import com.davielucas.model.Admin;
import com.davielucas.model.User;

@ManagedBean(name="LoginMB")
@SessionScoped
public class UserLoginView {
	private User user;
	private Admin adm;
	private boolean isAdm;
	
	
	public UserLoginView() {
		this.user = new User();
		this.adm  = new Admin();
		this.isAdm = false;
	}
	

	public String send() {
		UserDaoImpl userDao = new UserDaoImpl();
		user = userDao.getUser(user.getEmail(), user.getPassword());
		if (user == null) {
			FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                            "Erro no Login!"));
			return "/login.xhtml";
			
		} else {
			AdminsDAO admDao = new AdminsDAO();
			this.adm = admDao.read(user);
			if(adm != null)
				this.setIsAdm(true);
			else
				this.setIsAdm(false);
			
			return "/main.xhtml?faces-redirect=true";
		}
	}
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Admin getAdm() {
		return adm;
	}

	public void setAdm(Admin adm) {
		this.adm = adm;
	}

	public boolean getIsAdm() {
		return isAdm;
	}

	public void setIsAdm(boolean isAdm) {
		this.isAdm = isAdm;
	}

	
}
