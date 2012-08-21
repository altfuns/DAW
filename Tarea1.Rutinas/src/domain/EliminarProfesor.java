package domain;

import java.io.IOException;

import javax.servlet.ServletException;

import data.ProfesorFinder;
import data.ProfesorRowGateway;
import display.FrontCommand;

public class EliminarProfesor extends FrontCommand {

	  public void process()
	    throws ServletException, IOException {
	      ProfesorFinder profs =
	        (ProfesorFinder) context.getBean("profesorFinder");
	      String id = request.getParameter("id");
	    ProfesorRowGateway prof = profs.find(id);
	    if (prof!=null) {
	      prof.delete();
	    }
	    response.sendRedirect("universidad/domain.ListaProfesores");
	  }
	}
