package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class GrupoFinder {

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public GrupoRowGateway create() {
		return GrupoRowGateway.load(dataSource, null);
	}

	private final static String findStatement = "SELECT * " + "FROM grupo "
			+ "WHERE id = ?";

	public GrupoRowGateway find(String id) {
		List grupos = jdbcTemplate.queryForList(findStatement, id);
		GrupoRowGateway grupo = GrupoRowGateway.load(dataSource,
				(Map) grupos.get(0));
		return grupo;
	}

	private final static String findAllStatement = "SELECT * "
			+ "FROM grupo ";

	public List<GrupoRowGateway> findAll() {
		List result = new ArrayList();
		List grupos = jdbcTemplate.queryForList(findAllStatement);
		for (int i = 0; i < grupos.size(); i++)
			result.add(GrupoRowGateway.load(dataSource, (Map) grupos.get(i)));
		return result;
	}
}
