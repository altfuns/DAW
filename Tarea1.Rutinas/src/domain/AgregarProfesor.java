package domain;

import java.io.IOException;
import java.util.ArrayList;
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
		params.put("id", "-1");
		params.put("cedula", "");
		params.put("nombre", "");
		params.put("titulo", "");
		params.put("area", "");
		params.put("telefono", "");
		request.setAttribute("profesor", params);
		request.setAttribute("grupos", new ArrayList<Integer>());
		forward("/detalleProfesor.jsp");
	}
}