package domain;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import data.ProfesorFinder;
import data.ProfesorRowGateway;
import display.FrontCommand;

public class AgregarProfesor extends FrontCommand {

	public void process() throws ServletException, IOException {
		ProfesorFinder profs = (ProfesorFinder) context
				.getBean("profesorFinder");
		ProfesorRowGateway prof = profs.create();
		Map params = new HashMap();
		params.put("id", prof.getId() + "");
		params.put("cedula", prof.getCedula());
		params.put("nombre", prof.getNombre());
		params.put("titulo", prof.getTitulo());
		params.put("area", prof.getArea());
		params.put("telefono", prof.getTelefono());
		request.setAttribute("profesor", params);
		forward("/detalleProfesor.jsp");
	}
}