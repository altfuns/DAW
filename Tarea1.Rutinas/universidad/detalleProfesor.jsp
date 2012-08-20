<%@ page import="java.util.*" %>
<html>
  <head>
    <title>Sistema Universitario</title>
  </head>
  <h1>Sistema Universitario</h1>
  <h2>Detalle de Profesor</h2>
  <% Map prof = (Map)request.getAttribute("profesor"); %>
  <form name="ActualizarProfesor"
        action="/universidad/domain.ActualizarProfesor" method="get">
  <input type="hidden" name="id" value="<%= prof.get("id") %>"/>
  <table>
    <tr><td>Nombre:</td><td><input type="text" name="nombre"
            value="<%= prof.get("nombre") %>"/></td></tr>
    <tr><td>Cédula:</td><td><input type="text" name="cedula"
            value="<%= prof.get("cedula") %>"/></td></tr>
    <tr><td>Título:</td><td><input type="text" name="titulo"
            value="<%= prof.get("titulo") %>"/></td></tr>
    <tr><td>Area:</td><td><input type="text" name="area"
            value="<%= prof.get("area") %>"/></td></tr>
    <tr><td>Teléfono:</td><td><input type="text" name="telefono"
            value="<%= prof.get("telefono") %>"/></td></tr>
    <tr><td></td><td><input type="submit" value="Actualizar" /></td></tr>
  </table>
  <% List grupos = (List)request.getAttribute("grupos"); %>
  <table>
    <tr><th>Numero</th><th>Sigla</th><th>Area</th><th>Nombre</th><th>Acciones</th></tr>
    <% for(int i = 0, n = grupos.size(); i < n; i++) {
        Map grupo = (Map) grupos.get(i); %>
        <tr><td><%= grupo.get("numero") %></td>
        <td><%= grupo.get("sigla") %></td>
        <td><%= grupo.get("nombre") %></td>
        <td><a href='/universidad/domain.DetalleGrupo?id=<%= grupo.get("id") %>'>
              Detalle</a>
            </td></tr>
    <% } %>
  </table>
  </form>
</html>