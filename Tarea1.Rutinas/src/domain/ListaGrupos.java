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

public class ListaGrupos extends FrontCommand {

	public void process() throws ServletException, IOException {
		GrupoFinder grupos = (GrupoFinder) context.getBean("grupoFinder");
		List<GrupoRowGateway> data = grupos.findAll();
		List param = new ArrayList();
		for (int i = 0; i < data.size(); i++) {
			param.add(GrupoRowGateway.getPropertiesMap(data.get(i)));
		}
		request.setAttribute("grupos", param);
		forward("/listaGrupos.jsp");
	}
}
