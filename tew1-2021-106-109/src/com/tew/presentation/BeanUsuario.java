package com.tew.presentation;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.tew.model.Usuario;
@ManagedBean(name="usuario")
@SessionScoped
public class BeanUsuario extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public BeanUsuario() {
		iniciaUsuario(null);
	}
	
	//Iniciamos los datos del alumno con los valores por defecto
	//extraídos del archivo de propiedades correspondiente
	public void iniciaUsuario(ActionEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
			ResourceBundle bundle =
				facesContext.getApplication().getResourceBundle(facesContext, "msgs");
			
	}

}
