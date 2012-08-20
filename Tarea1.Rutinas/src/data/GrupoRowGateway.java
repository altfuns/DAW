package data;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class GrupoRowGateway {

	private int id;
	private int numero;
	private String sigla;
	private String nombre;
	private String horario;
	private String aula;
	private int idProfesor;

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

	public GrupoRowGateway() {
		super();
	}

	public GrupoRowGateway(int id, int numero, String sigla, String nombre,
			String horario, String aula, int idProfesor) {
		super();
		this.id = id;
		this.numero = numero;
		this.sigla = sigla;
		this.nombre = nombre;
		this.horario = horario;
		this.aula = aula;
		this.idProfesor = idProfesor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public int getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private void createJdbcTemplate() {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public static Map getPropertiesMap(GrupoRowGateway group){
		Map item = new HashMap();
		item.put("id", group.getId() + "");
		item.put("numero", group.getNumero());
		item.put("sigla", group.getSigla());
		item.put("nombre", group.getNombre());
		item.put("horario", group.getHorario());
		item.put("aula", group.getAula());
		item.put("idProfesor", group.getIdProfesor());
		return item;
	}

	private static final String insertStatement = "INSERT INTO grupo "
			+ "VALUES (?,?,?,?,?,?,?)";

	public int insert() {
		Random generator = new Random();
		int id = generator.nextInt();
		if (jdbcTemplate == null)
			createJdbcTemplate();
		jdbcTemplate.update(insertStatement, id, numero, sigla, nombre,
				horario, aula, idProfesor);
		return id;
	}

	private static final String updateStatement = "UPDATE grupo "
			+ "SET numero = ?, sigla = ?, nombre = ?, "
			+ "horario = ?, aula = ?, id_profesor = ? WHERE id = ?";

	public void update() {
		if (jdbcTemplate == null)
			createJdbcTemplate();
		jdbcTemplate.update(updateStatement, numero, sigla, nombre, horario,
				aula, idProfesor, id);
	}

	private static final String deleteStatement = "DELETE FROM grupo "
			+ "WHERE id = ?";

	public void delete() {
		if (jdbcTemplate == null)
			createJdbcTemplate();
		jdbcTemplate.update(deleteStatement, id);
	}

	public static GrupoRowGateway load(DataSource ds, Map map) {
		GrupoRowGateway grupo = null;
		if (map == null)
			grupo = new GrupoRowGateway();
		else {
			int id = ((Integer) map.get("id")).intValue();
			grupo = new GrupoRowGateway();

			grupo.setId(id);
			grupo.setNumero(((Integer) map.get("numero")).intValue());
			grupo.setIdProfesor(((Integer) map.get("id_profesor")).intValue());
			grupo.setSigla((String) map.get("sigla"));
			grupo.setNombre((String) map.get("nombre"));
			grupo.setHorario((String) map.get("horario"));
			grupo.setAula((String) map.get("aula"));
		}
		grupo.setDataSource(ds);
		return grupo;
	}

}
