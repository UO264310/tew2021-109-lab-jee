package com.tew.presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@NoneScoped
public class BeanError {
	private String vista;
	private String metodo;
	private String clase;
	private String errorConcreto;
	private HttpServletRequest r = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	private String mensaje=null;
	public String getVista() {
		return vista;
	}
	public void setVista(String vista) {
		this.vista = vista;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	public String getErrorConcreto() {
		return errorConcreto;
	}
	public void setErrorConcreto(String error) {
		this.errorConcreto = error;
	}
	public void setError(String vista, String metodo, String clase, String ec) {
		setVista(vista);
		setMetodo(metodo);
		setClase(clase);
		setErrorConcreto(ec);
	}
	public HttpServletRequest getR() {
		return r;
	}
	public void setR(HttpServletRequest r) {
		this.r = r;
	}
	
	public void AñadirMensaje() {
		setMensaje("Se ha producido un error en el metodo "+getMetodo()+" de la clase "+getClase()+" en la vista "+getVista()+" con error especifico: "+getErrorConcreto());
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
