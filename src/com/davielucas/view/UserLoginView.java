package com.davielucas.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.davielucas.impl.AdminsDAO;
import com.davielucas.impl.UserDaoImpl;
import com.davielucas.model.Admin;
import com.davielucas.model.User;

@ManagedBean(name="LoginMB")
public class UserLoginView {
	private UserDaoImpl userDao = new UserDaoImpl();
	private User user = new User();
	private AdminsDAO admDao = new AdminsDAO();
	private Admin adm = new Admin();
	private boolean isAdm = false;
	

	public String send() {
		user = userDao.getUser(user.getEmail(), user.getPassword());
		if (user==null) {
			FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                            "Erro no Login!"));
			return null;
		} else {
			this.adm = admDao.read(user);
			if(adm!=null) {
				this.setAdm(true);
			}
			return "/main";
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

	public boolean isAdm() {
		return isAdm;
	}

	public void setAdm(boolean isAdm) {
		this.isAdm = isAdm;
	}

	
}
