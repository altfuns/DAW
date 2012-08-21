package domain;

import display.FrontCommand;
import data.GrupoFinder;
import data.GrupoRowGateway;
import data.ProfesorFinder;
import data.ProfesorRowGateway;

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import javax.servlet.ServletException;

public class EliminarGrupo extends FrontCommand {

	public void process() throws ServletException, IOException {
		GrupoFinder grupos = (GrupoFinder) context.getBean("grupoFinder");
		String id = request.getParameter("id");
		GrupoRowGateway grupo = grupos.find(id);
		if (grupo != null) {
			grupo.delete();
		}
		response.sendRedirect("universidad/domain.ListaGrupos");
	}
}