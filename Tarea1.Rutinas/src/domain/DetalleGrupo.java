package domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import data.GrupoFinder;
import data.GrupoRowGateway;
import data.ProfesorFinder;
import data.ProfesorRowGateway;
import display.FrontCommand;

public class DetalleGrupo extends FrontCommand {
	public void process() throws ServletException, IOException {
		GrupoFinder grupos = (GrupoFinder) context.getBean("grupoFinder");
		String id = request.getParameter("id");
		GrupoRowGateway grupo = grupos.find(id);

		request.setAttribute("grupo", GrupoRowGateway.getPropertiesMap(grupo));
		request.setAttribute("profesores", getProfesorParams());
		forward("/detalleGrupo.jsp");
	}
	
	private List getProfesorParams() {
		ProfesorFinder profesores = (ProfesorFinder) context.getBean("profesorFinder");
		List<ProfesorRowGateway> data = profesores.findAll();
		List param = new ArrayList();
		for (int i = 0; i < data.size(); i++) {
			param.add(ProfesorRowGateway.getPropertiesMap(data.get(i)));
		}
		return param;
	}
}
