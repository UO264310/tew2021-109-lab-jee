package impl.tew.error;

import javax.faces.context.FacesContext;

import com.tew.error.ErrorFactory;
import com.tew.presentation.BeanError;

public class SimpleErrorFactory implements ErrorFactory {

	@Override
	public BeanError inicializar() {
		System.out.println("BGError - PostConstruct");
		//Buscamos el alumno en la sesión. Esto es un patrón factoría claramente.
		BeanError error = (BeanError)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(new String("error"));
		//si no existe lo creamos e inicializamos
		if (error == null) {
			System.out.println("BGError - No existia");
			error = new BeanError();
		}
		return error;
	}

}
