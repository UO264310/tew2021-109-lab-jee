package com.tew.presentation;
import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.tew.infrastructure.Factories;
@ManagedBean
@SessionScoped
public class BeanSettings implements Serializable{
	private static final long serialVersionUID = 2L;
	private static final Locale ENGLISH = new Locale("en");
	private static final Locale SPANISH = new Locale("es"); 
	private Locale locale = new Locale("es");
	
	//uso de inyección de dependencia
	@ManagedProperty(value="#{alumno}")
	private BeanAlumno alumno;
	public BeanAlumno getAlumno() { return alumno; }
	public void setAlumno(BeanAlumno alumno) {this.alumno = alumno;}
	
	@ManagedProperty(value="#{error}")
	private BGError error;
	public BGError getError() { return error;}
	public void setError(BGError error) { this.error=error; }

 
	public Locale getLocale() { /*Habria que cambiar algo de código para coger locale
	del navegador la primera vez que se accede a getLocale(), de momento el idioma de
	partida “es”*/
		return(locale);
	}
	
	public void setSpanish(ActionEvent event) {
		locale = SPANISH;
		try {
			if (alumno != null)
				if (alumno.getId()== null) //valores por defecto del alumno, si no NO inicializar
					alumno.iniciaAlumno(null);
		} catch (Exception ex){
			ex.printStackTrace();
			error.setError(error.getR().getPathInfo(), "setSpanish", this.getClass().toString(), "Error al traducir al Español");
		}
	}

	public void setEnglish(ActionEvent event) {
		locale = ENGLISH;
		try {
			FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
			if (alumno != null)
				if (alumno.getId()== null) //valores por defecto del alumno, si no NO inicializar
					alumno.iniciaAlumno(null);
		} catch (Exception ex){
			ex.printStackTrace();
			error.setError(error.getR().getPathInfo(), "setEnglish", this.getClass().toString(), "Error al traducir al Ingles");
		}
	}
	
	//Se inicia correctamente el Managed Bean inyectado si JSF lo hubiera creado
	//y en caso contrario se crea.
	//(hay que tener en cuenta que es un Bean de sesión)
	//Se usa @PostConstruct, ya que en el contructor no se sabe todavía si
	//el MBean ya estaba construido y en @PostConstruct SI.
	@PostConstruct
	public void init() {
		error=Factories.fail.inicializar();
		alumno=Factories.construct.CreateBeanAlumno();
	}
	
	//Es sólo a modo de traza.
	@PreDestroy
	public void end(){
		System.out.println("BeanSettings - PreDestroy");
	}

}
