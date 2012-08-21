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

public class ActualizarGrupo extends FrontCommand {

	public void process() throws ServletException, IOException {
		GrupoFinder grupos = (GrupoFinder) context.getBean("grupoFinder");
		String id = request.getParameter("id");
		int gId = Integer.parseInt(id);
		// Si
		GrupoRowGateway grupo = gId == -1 ? grupos.create() : grupos.find(id);
		if (grupo != null) {
			int numero = Integer.parseInt(request.getParameter("numero"));
			if (numero > 0)
				grupo.setNumero(numero);
			String sigla = request.getParameter("sigla");
			if (sigla != null)
				grupo.setSigla(sigla);
			String nombre = request.getParameter("nombre");
			if (nombre != null)
				grupo.setNombre(nombre);
			String horario = request.getParameter("horario");
			if (horario != null)
				grupo.setHorario("horario");
			String aula = request.getParameter("aula");
			if (aula != null)
				grupo.setAula(aula);
			int profesor = Integer.parseInt(request.getParameter("profesor"));
			if (profesor > 0)
				grupo.setIdProfesor(profesor);
			if (gId == -1)
				grupo.insert();
			else
				grupo.update();
		}
		response.sendRedirect("universidad/domain.ListaGrupos");
	}
}