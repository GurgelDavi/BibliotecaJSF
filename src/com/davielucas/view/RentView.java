package com.davielucas.view;

import java.util.List;

import javax.faces.bean.ManagedBean;

import com.davielucas.impl.BookDAO;
import com.davielucas.impl.RentDAO;
import com.davielucas.model.Admin;
import com.davielucas.model.Book;
import com.davielucas.model.Rent;
import com.davielucas.model.User;

@ManagedBean
public class RentView {
	private Boolean isAdm = false;
	
	private Book selected = new Book();
	private BookDAO bookDao = new BookDAO();
	
	private User renter = new User();
	private Admin currentAdm = new Admin();
	
	private Rent request = new Rent();
	private RentDAO rentDao = new RentDAO();
	
	
	
	public Boolean getIsAdm() {
		return isAdm;
	}



	public void setIsAdm(Boolean isAdm) {
		this.isAdm = isAdm;
	}



	public Book getSelected() {
		return selected;
	}



	public void setSelected(Book selected) {
		this.selected = selected;
	}



	public User getRenter() {
		return renter;
	}



	public void setRenter(User renter) {
		this.renter = renter;
	}



	public Admin getCurrentAdm() {
		return currentAdm;
	}



	public void setCurrentAdm(Admin currentAdm) {
		this.currentAdm = currentAdm;
	}



	public Rent getRequest() {
		return request;
	}



	public void setRequest(Rent request) {
		this.request = request;
	}



	public void requestRent() {
		if((selected!=null)&&(renter!=null)) {
			this.selected.setAvailable(false);
			this.bookDao.update(selected);
			rentDao.create(renter, selected);
		}else {
			System.out.println("Null parameter at request!");
		}
		
	}
	public List<Rent> getAllRequests() {
		// TODO Auto-generated method stub
		System.out.println("loading Rent request");
		return rentDao.rentsRequest();

	}
	public void yieldRequest()
	{
		System.out.println("--------------------------------------------------------");
		System.out.println(this.request.getBook().getTitle());
		System.out.println(this.currentAdm.getUser().getEmail());
		System.out.println("--------------------------------------------------------");
	}
	
	
	
}
