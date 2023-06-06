package co.edu.uco.teqvim.data.dao.factory.relational.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimCrossCuttingException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimDataException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.UtilSqlMessages;
import co.edu.uco.teqvim.crosscutting.utils.UtilSql;
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
import co.edu.uco.teqvim.data.dao.relational.postgresql.DiaSemanaPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.DuracionPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.EstadoEstudiantePostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.EstadoEventoPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.EstadoNotificacionPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.EstadoPeriodoAcademicoPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.EstudiantePostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.EventoPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.FestivoPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.FrecuenciaPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.MateriaPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.NombreDiaSemanaPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.NotaPostgrePostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.NotificacionPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.PaisPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.PeriodoAcademicoPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.RepeticionPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.RespuestaPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.TipoDocumentoPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.TipoDuracionEventoPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.TipoEventoPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.TipoFestivoFijoPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.TipoFestivoPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.TipoFrecuenciaPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.TipoNotaPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.TipoNotificacionPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.TipoPeriodoAcademicoPostgreSqlDAO;
import co.edu.uco.teqvim.data.dao.relational.postgresql.UnidadTiempoPostgreSqlDAO;

public final class PostgreSqlDAOFactory extends DAOFactory {

	private static Connection conexion;

	public PostgreSqlDAOFactory() {
		openConection();
	}

	@Override
	protected final void openConection() {
		try {
			conexion = DriverManager.getConnection("jdbc:postgresql://mahmud.db.elephantsql.com/rrqjiyyt", "rrqjiyyt", "L-G7WHZNqj50laWZH3KTt0OFIpieh3X2");
			UtilSql.connectionIsOpen(conexion);
		} catch (final TeqvimException exception) {
			throw exception;
		} catch (IllegalArgumentException exception) {
			var userMessage = UtilSqlMessages.CONNECTION_IS_OPEN_USER_MESSAGE;
			var technicalMessage = UtilSqlMessages.CONNECTION_IS_OPEN_TECHNICAL_ILEGAL_ARGUMENT_EXCEPTION;

			throw TeqvimDataException.create(userMessage, technicalMessage, exception);
		} catch (final NullPointerException exception) {
			var userMessage = UtilSqlMessages.CONNECTION_IS_OPEN_USER_MESSAGE;
			var technicalMessage = UtilSqlMessages.CONNECTION_IS_OPEN_TECHNICAL_NULL_POINTER_EXCEPTION;

			throw TeqvimDataException.create(userMessage, technicalMessage, exception);
		} catch (final Exception exception) {
			var userMessage = UtilSqlMessages.CONNECTION_IS_OPEN_USER_MESSAGE;
			var technicalMessage = UtilSqlMessages.CONNECTION_IS_OPEN_TECHNICAL_EXCEPTION;

			throw TeqvimDataException.create(userMessage, technicalMessage, exception);
		}

	}

	@Override
	public final void closeConection() {
		try {
			UtilSql.closeConnection(conexion);
		} catch (final TeqvimException exception) {
			throw exception;
		}

	}

	@Override
	public final void initTransaction() {
		try {
			if(UtilSql.connectionIsOpen(conexion)) {
				conexion.setAutoCommit(false);
			}
		} catch (final TeqvimException exception) {
			throw exception;
		} catch (final SQLException exception) {
			var userMessage = UtilSqlMessages.COMMIT_IS_STARTING_USER_MESSAGE;
			var technicalMessage = UtilSqlMessages.COMMIT_TECHNICAL_SQL_EXCEPTION;

			throw TeqvimCrossCuttingException.create(userMessage, technicalMessage, exception);
		}

	}

	@Override
	public void commitTransaction() {
		try {
			if(UtilSql.initCommitIsReady(conexion) && UtilSql.connectionIsOpen(conexion)) {
				conexion.commit();
			}
		} catch (TeqvimException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw TeqvimCrossCuttingException.create(UtilSqlMessages.CONFIRM_COMMIT_USER_MESSAGE, UtilSqlMessages.COMMIT_TECHNICAL_SQL_EXCEPTION, exception);
		}

	}

	@Override
	public void cancelTransaction() {
		try {
			if(UtilSql.initCommitIsReady(conexion) && UtilSql.connectionIsOpen(conexion)) {
				conexion.rollback();
			}
		} catch (TeqvimException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw TeqvimCrossCuttingException.create(UtilSqlMessages.CANCEL_COMMIT_USER_MESSAGE, UtilSqlMessages.COMMIT_TECHNICAL_SQL_EXCEPTION, exception);
		}

	}

	@Override
	public DuracionDAO getDuracionDAO() {
		return new DuracionPostgreSqlDAO(conexion);
	}

	@Override
	public EstadoEstudianteDAO getEstadoEstudianteDAO() {
		return new EstadoEstudiantePostgreSqlDAO(conexion);
	}

	@Override
	public EstadoEventoDAO getEstadoEventoDAO() {
		return new EstadoEventoPostgreSqlDAO(conexion);
	}

	@Override
	public EstadoNotificacionDAO getEstadoNotificacionDAO() {
		return new EstadoNotificacionPostgreSqlDAO(conexion);
	}

	@Override
	public EstadoPeriodoAcademicoDAO getEstadoPeriodoAcademicoDAO() {
		return new EstadoPeriodoAcademicoPostgreSqlDAO(conexion);
	}

	@Override
	public EstudianteDAO getEstudianteDAO() {
		return new EstudiantePostgreSqlDAO(conexion);
	}

	@Override
	public EventoDAO getEventoDAO() {
		return new EventoPostgreSqlDAO(conexion);
	}

	@Override
	public FestivoDAO getFestivoDAO() {
		return new FestivoPostgreSqlDAO(conexion);
	}

	@Override
	public FrecuenciaDAO getFrecuenciaDAO() {
		return new FrecuenciaPostgreSqlDAO(conexion);
	}

	@Override
	public MateriaDAO getMateriaDAO() {
		return new MateriaPostgreSqlDAO(conexion);
	}

	@Override
	public NotaDAO getNotaDAO() {
		return new NotaPostgrePostgreSqlDAO(conexion);
	}

	@Override
	public NotificacionDAO getNotificacionDAO() {
		return new NotificacionPostgreSqlDAO(conexion);
	}

	@Override
	public PaisDAO getPaisDAO() {
		return new PaisPostgreSqlDAO(conexion);
	}

	@Override
	public PeriodoAcademicoDAO getPeriodoAcademicoDAO() {
		return new PeriodoAcademicoPostgreSqlDAO(conexion);
	}

	@Override
	public RepeticionDAO getRepeticionDAO() {
		return new RepeticionPostgreSqlDAO(conexion);
	}

	@Override
	public RespuestaDAO getRespuestaDAO() {
		return new RespuestaPostgreSqlDAO(conexion);
	}

	@Override
	public TipoDocumentoDAO getTipoDocumentoDAO() {
		return new TipoDocumentoPostgreSqlDAO(conexion);
	}

	@Override
	public TipoDuracionEventoDAO getTipoDuracionEventoDAO() {
		return new TipoDuracionEventoPostgreSqlDAO(conexion);
	}

	@Override
	public TipoEventoDAO getTipoEventoDAO() {
		return new TipoEventoPostgreSqlDAO(conexion);
	}

	@Override
	public TipoFestivoDAO getTipoFestivoDAO() {
		return new TipoFestivoPostgreSqlDAO(conexion);
	}

	@Override
	public TipoFestivoFijoDAO getTipoFestivoFijoDAO() {
		return new TipoFestivoFijoPostgreSqlDAO(conexion);
	}

	@Override
	public TipoFrecuenciaDAO getTipoFrecuenciaDAO() {
		return new TipoFrecuenciaPostgreSqlDAO(conexion);
	}

	@Override
	public TipoNotaDAO getTipoNotaDAO() {
		return new TipoNotaPostgreSqlDAO(conexion);
	}

	@Override
	public TipoNotificacionDAO getTipoNotificacionDAO() {
		return new TipoNotificacionPostgreSqlDAO(conexion);
	}

	@Override
	public TipoPeriodoAcademicoDAO getTipoPeriodoAcademicoDAO() {
		return new TipoPeriodoAcademicoPostgreSqlDAO(conexion);
	}

	@Override
	public UnidadTiempoDAO getUnidadTiempoDAO() {
		return new UnidadTiempoPostgreSqlDAO(conexion);
	}

	@Override
	public NombreDiaSemanaDAO getNombreDiaSemanaDAO() {
		return new NombreDiaSemanaPostgreSqlDAO(conexion);
	}

	@Override
	public DiaSemanaDAO getDiaSemanaDAO() {
		return new DiaSemanaPostgreSqlDAO(conexion);
	}
}
