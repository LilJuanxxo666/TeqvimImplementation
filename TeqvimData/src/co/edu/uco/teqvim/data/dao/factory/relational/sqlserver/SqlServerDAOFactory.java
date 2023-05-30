package co.edu.uco.teqvim.data.dao.factory.relational.sqlserver;

import java.sql.Connection;

import co.edu.uco.teqvim.data.dao.DiaSemanaDAO;
import co.edu.uco.teqvim.data.dao.DuracionDAO;
import co.edu.uco.teqvim.data.dao.EstadoEstudianteDAO;
import co.edu.uco.teqvim.data.dao.EstadoEventoDAO;
import co.edu.uco.teqvim.data.dao.EstadoNotificacionDAO;
import co.edu.uco.teqvim.data.dao.EstadoPeriodoAcademicoDAO;
import co.edu.uco.teqvim.data.dao.EstudianteDAO;
import co.edu.uco.teqvim.data.dao.EventoDAO;
import co.edu.uco.teqvim.data.dao.FestivoDAO;
import co.edu.uco.teqvim.data.dao.FrecuenciaDAO;
import co.edu.uco.teqvim.data.dao.MateriaDAO;
import co.edu.uco.teqvim.data.dao.NombreDiaSemanaDAO;
import co.edu.uco.teqvim.data.dao.NotaDAO;
import co.edu.uco.teqvim.data.dao.NotificacionDAO;
import co.edu.uco.teqvim.data.dao.PaisDAO;
import co.edu.uco.teqvim.data.dao.PeriodoAcademicoDAO;
import co.edu.uco.teqvim.data.dao.RepeticionDAO;
import co.edu.uco.teqvim.data.dao.RespuestaDAO;
import co.edu.uco.teqvim.data.dao.TipoDocumentoDAO;
import co.edu.uco.teqvim.data.dao.TipoDuracionEventoDAO;
import co.edu.uco.teqvim.data.dao.TipoEventoDAO;
import co.edu.uco.teqvim.data.dao.TipoFestivoDAO;
import co.edu.uco.teqvim.data.dao.TipoFestivoFijoDAO;
import co.edu.uco.teqvim.data.dao.TipoFrecuenciaDAO;
import co.edu.uco.teqvim.data.dao.TipoNotaDAO;
import co.edu.uco.teqvim.data.dao.TipoNotificacionDAO;
import co.edu.uco.teqvim.data.dao.TipoPeriodoAcademicoDAO;
import co.edu.uco.teqvim.data.dao.UnidadTiempoDAO;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.DiaSemanaSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.DuracionSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.EstadoEstudianteSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.EstadoEventoSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.EstadoNotificacionSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.EstadoPeriodoAcademicoSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.EstudianteSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.EventoSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.FestivoSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.FrecuenciaSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.MateriaSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.NombreDiaSemanaSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.NotaSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.NotificacionSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.PaisSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.PeriodoAcademicoSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.RepeticionSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.RespuestaSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.TipoDocumentoSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.TipoDuracionEventoSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.TipoEventoSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.TipoFestivoFijoSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.TipoFestivoSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.TipoFrecuenciaSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.TipoNotaSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.TipoNotificacionSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.TipoPeriodoAcademicoSqlServerDAO;
import co.edu.uco.teqvim.data.dao.relational.sqlserver.UnidadTiempoSqlServerDAO;

public final class SqlServerDAOFactory extends DAOFactory {

	private Connection connection;

	public SqlServerDAOFactory() {
		openConection();
	}

	@Override
	protected void openConection() {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeConection() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initTransaction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void commitTransaction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelTransaction() {
		// TODO Auto-generated method stub

	}

	@Override
	public DuracionDAO getDuracionDAO() {
		return new DuracionSqlServerDAO(connection);
	}

	@Override
	public EstadoEstudianteDAO getEstadoEstudianteDAO() {
		return new EstadoEstudianteSqlServerDAO(connection);
	}

	@Override
	public EstadoEventoDAO getEstadoEventoDAO() {
		return new EstadoEventoSqlServerDAO(connection);
	}

	@Override
	public EstadoNotificacionDAO getEstadoNotificacionDAO() {
		return new EstadoNotificacionSqlServerDAO(connection);
	}

	@Override
	public EstadoPeriodoAcademicoDAO getEstadoPeriodoAcademicoDAO() {
		return new EstadoPeriodoAcademicoSqlServerDAO(connection);
	}

	@Override
	public EstudianteDAO getEstudianteDAO() {
		return new EstudianteSqlServerDAO(connection);
	}

	@Override
	public EventoDAO getEventoDAO() {
		return new EventoSqlServerDAO(connection);
	}

	@Override
	public FestivoDAO getFestivoDAO() {
		return new FestivoSqlServerDAO(connection);
	}

	@Override
	public FrecuenciaDAO getFrecuenciaDAO() {
		return new FrecuenciaSqlServerDAO(connection);
	}

	@Override
	public MateriaDAO getMateriaDAO() {
		return new MateriaSqlServerDAO(connection);
	}

	@Override
	public NotaDAO getNotaDAO() {
		return new NotaSqlServerDAO(connection);
	}

	@Override
	public NotificacionDAO getNotificacionDAO() {
		return new NotificacionSqlServerDAO(connection);
	}

	@Override
	public PaisDAO getPaisDAO() {
		return new PaisSqlServerDAO(connection);
	}

	@Override
	public PeriodoAcademicoDAO getPeriodoAcademicoDAO() {
		return new PeriodoAcademicoSqlServerDAO(connection);
	}

	@Override
	public RepeticionDAO getRepeticionDAO() {
		return new RepeticionSqlServerDAO(connection);
	}

	@Override
	public RespuestaDAO getRespuestaDAO() {
		return new RespuestaSqlServerDAO(connection);
	}

	@Override
	public TipoDocumentoDAO getTipoDocumentoDAO() {
		return new TipoDocumentoSqlServerDAO(connection);
	}

	@Override
	public TipoDuracionEventoDAO getTipoDuracionEventoDAO() {
		return new TipoDuracionEventoSqlServerDAO(connection);
	}

	@Override
	public TipoEventoDAO getTipoEventoDAO() {
		return new TipoEventoSqlServerDAO(connection);
	}

	@Override
	public TipoFestivoDAO getTipoFestivoDAO() {
		return new TipoFestivoSqlServerDAO(connection);
	}

	@Override
	public TipoFestivoFijoDAO getTipoFestivoFijoDAO() {
		return new TipoFestivoFijoSqlServerDAO(connection);
	}

	@Override
	public TipoFrecuenciaDAO getTipoFrecuenciaDAO() {
		return new TipoFrecuenciaSqlServerDAO(connection);
	}

	@Override
	public TipoNotaDAO getTipoNotaDAO() {
		return new TipoNotaSqlServerDAO(connection);
	}

	@Override
	public TipoNotificacionDAO getTipoNotificacionDAO() {
		return new TipoNotificacionSqlServerDAO(connection);
	}

	@Override
	public TipoPeriodoAcademicoDAO getTipoPeriodoAcademicoDAO() {
		return new TipoPeriodoAcademicoSqlServerDAO(connection);
	}

	@Override
	public UnidadTiempoDAO getUnidadTiempoDAO() {
		return new UnidadTiempoSqlServerDAO(connection);
	}

	@Override
	public NombreDiaSemanaDAO getNombreDiaSemanaDAO() {
		return new NombreDiaSemanaSqlServerDAO(connection);
	}

	@Override
	public DiaSemanaDAO getDiaSemanaDAO() {
		return new DiaSemanaSqlServerDAO(connection);
	}
	

}
