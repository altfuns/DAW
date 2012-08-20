package domain;

import display.FrontCommand;
import data.GrupoFinder;
import data.GrupoRowGateway;
import data.ProfesorFinder;
import data.ProfesorRowGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import javax.servlet.ServletException;

public class DetalleProfesor extends FrontCommand {

	public void process() throws ServletException, IOException {
		ProfesorFinder profs = (ProfesorFinder) context
				.getBean("profesorFinder");
		String id = request.getParameter("id");
		ProfesorRowGateway prof = profs.find(id);
		Map params = new HashMap();
		params.put("id", prof.getId() + "");
		params.put("cedula", prof.getCedula());
		params.put("nombre", prof.getNombre());
		params.put("titulo", prof.getTitulo());
		params.put("area", prof.getArea());
		params.put("telefono", prof.getTelefono());
		request.setAttribute("profesor", params);
		request.setAttribute("grupos", getGroupParams(prof.getId()));
		
		forward("/detalleProfesor.jsp");
	}

	private List getGroupParams(int profesorId) {
		GrupoFinder groups = (GrupoFinder) context.getBean("grupoFinder");
		List<GrupoRowGateway> data = groups.findWithProfesorId(profesorId);
		List param = new ArrayList();
		for (int i = 0; i < data.size(); i++) {
			param.add(GrupoRowGateway.getPropertiesMap(data.get(i)));
		}
		return param;
	}
}