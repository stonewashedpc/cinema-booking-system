package utilities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import db.connection.NoConnectionException;
import db.executer.PersistenceDMLExecuter;
import db.executer.PersistenceException;
import db.executer.PersistenceExecuterFactory;
/**
 * Performs initial load of all relations of type <tableName>
 */
public class InitialRelationLoader {
	private String tableName;
	private PersistenceDMLExecuter dmlExecuter;
	public InitialRelationLoader(String tableName) {
		super();
		this.tableName = tableName;
		this.dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
	}
	public Map<Integer, IntegerPair> perform() throws PersistenceException{
		Map<Integer, IntegerPair> result = new HashMap<>();
		try {
			Optional<ResultSet> rs = this.dmlExecuter.selectAllEntriesOfRelationTable(tableName);
			if(rs.isEmpty()) return result;   // No relations present in NoDB Mode
			while(rs.get().next()) result.put(rs.get().getInt(1), new IntegerPair(rs.get().getInt(2), rs.get().getInt(3)));
		} catch (SQLException | NoConnectionException e) {
			throw new PersistenceException("Error when retrieving relation objects during initial load: " + e.getClass().getName() + ": " + e.getMessage());
		}
		return result;
	}
	public class IntegerPair{
		private Integer p1;
		private Integer p2;
		public IntegerPair(Integer p1, Integer p2) {
			super();
			this.p1 = p1;
			this.p2 = p2;
		}
		public Integer getP1() {
			return this.p1;
		}
		public Integer getP2() {
			return this.p2;
		}
	}
}
