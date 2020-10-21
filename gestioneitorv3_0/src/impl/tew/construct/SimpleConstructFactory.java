package impl.tew.construct;

import javax.faces.context.FacesContext;

import com.tew.construct.ConstructFactory;
import com.tew.presentation.BeanAlumno;

public class SimpleConstructFactory implements ConstructFactory{

	@Override
	public BeanAlumno CreateBeanAlumno() {
		System.out.println("BeanAlumnos - PostConstruct");
		//Buscamos el alumno en la sesión. Esto es un patrón factoría claramente.
		BeanAlumno alumno = (BeanAlumno)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(new String("alumno"));
		//si no existe lo creamos e inicializamos
		if (alumno == null) {
			System.out.println("BeanAlumnos - No existia");
			alumno = new BeanAlumno();
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put( "alumno",alumno);
		}
		return alumno;
	}

}
