package impl.tew.error;

import javax.faces.context.FacesContext;

import com.tew.error.ErrorFactory;
import com.tew.presentation.BGError;

public class SimpleErrorFactory implements ErrorFactory {

	@Override
	public BGError inicializar() {
		System.out.println("BGError - PostConstruct");
		//Buscamos el alumno en la sesión. Esto es un patrón factoría claramente.
		BGError error = (BGError)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(new String("error"));
		//si no existe lo creamos e inicializamos
		if (error == null) {
			System.out.println("BGError - No existia");
			error = new BGError();
		}
		return error;
	}

}
