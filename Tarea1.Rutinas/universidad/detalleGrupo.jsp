<%@ page import="java.util.*" %>
<html>
  <head>
    <title>Sistema Universitario</title>
  </head>
  <h1>Sistema Universitario</h1>
  <h2>Detalle de Grupo</h2>
  <% 
  	Map grupo = (Map)request.getAttribute("grupo");
  	int idProfesor = Integer.parseInt(grupo.get("idProfesor").toString()); 
  %>
  <form name="ActualizarGrupo"
        action="/universidad/domain.ActualizarGrupo" method="get">
  <input type="hidden" name="id" value="<%= grupo.get("id") %>"/>
  <table>
    <tr><td>Numero:</td><td><input type="text" name="numero"
            value="<%= grupo.get("numero") %>"/></td></tr>
    <tr><td>Sigla:</td><td><input type="text" name="sigla"
            value="<%= grupo.get("sigla") %>"/></td></tr>
    <tr><td>Nombre:</td><td><input type="text" name="nombre"
            value="<%= grupo.get("nombre") %>"/></td></tr>
    <tr><td>Horario:</td><td><input type="text" name="horario"
            value="<%= grupo.get("horario") %>"/></td></tr>
    <tr><td>Aula:</td><td><input type="text" name="aula"
            value="<%= grupo.get("aula") %>"/></td></tr>
	<tr><td>Profesor:</td>
	<td>
		<select name="profesor">
		<% List profesores = (List)request.getAttribute("profesores"); %>
		<% for(int i = 0, n = profesores.size(); i < n; i++) {
        		Map profesor = (Map) profesores.get(i);
        		int id = Integer.parseInt(profesor.get("id").toString());
        %>
        	<option value="<%= profesor.get("id") %>" 
        		<%= id == idProfesor? "selected" : "" %>
        	><%= profesor.get("nombre") %>
        	</option>
        <% } %>
		</select>
	</td></tr>
    <tr><td></td><td><input type="submit" value="Actualizar" /></td></tr>
  </table>
  </form>
</html>