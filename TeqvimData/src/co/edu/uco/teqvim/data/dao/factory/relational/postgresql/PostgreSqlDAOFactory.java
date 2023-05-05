package co.edu.uco.teqvim.data.dao.factory.relational.postgresql;

import java.sql.Connection;

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
import co.edu.uco.teqvim.data.dao.relational.postgresql.NotaPostgreSqlDAO;
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

	private Connection connection;

	public PostgreSqlDAOFactory() {
		abrirConexion();
	}

	@Override
	protected void abrirConexion() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cerrarConexion() {
		// TODO Auto-generated method stub

	}

	@Override
	public void iniciarTransaccion() {
		// TODO Auto-generated method stub

	}

	@Override
	public void confirmarTransaccion() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelarTransaccion() {
		// TODO Auto-generated method stub

	}

	@Override
	public DuracionDAO getDuracionDAO() {
		return new DuracionPostgreSqlDAO(connection);
	}

	@Override
	public EstadoEstudianteDAO getEstadoEstudianteDAO() {
		return new EstadoEstudiantePostgreSqlDAO(connection);
	}

	@Override
	public EstadoEventoDAO getEstadoEventoDAO() {
		return new EstadoEventoPostgreSqlDAO(connection);
	}

	@Override
	public EstadoNotificacionDAO getEstadoNotificacionDAO() {
		return new EstadoNotificacionPostgreSqlDAO(connection);
	}

	@Override
	public EstadoPeriodoAcademicoDAO getEstadoPeriodoAcademicoDAO() {
		return new EstadoPeriodoAcademicoPostgreSqlDAO(connection);
	}

	@Override
	public EstudianteDAO getEstudianteDAO() {
		return new EstudiantePostgreSqlDAO(connection);
	}

	@Override
	public EventoDAO getEventoDAO() {
		return new EventoPostgreSqlDAO(connection);
	}

	@Override
	public FestivoDAO getFestivoDAO() {
		return new FestivoPostgreSqlDAO(connection);
	}

	@Override
	public FrecuenciaDAO getFrecuenciaDAO() {
		return new FrecuenciaPostgreSqlDAO(connection);
	}

	@Override
	public MateriaDAO getMateriaDAO() {
		return new MateriaPostgreSqlDAO(connection);
	}

	@Override
	public NotaDAO getNotaDAO() {
		return new NotaPostgreSqlDAO(connection);
	}

	@Override
	public NotificacionDAO getNotificacionDAO() {
		return new NotificacionPostgreSqlDAO(connection);
	}

	@Override
	public PaisDAO getPaisDAO() {
		return new PaisPostgreSqlDAO(connection);
	}

	@Override
	public PeriodoAcademicoDAO getPeriodoAcademicoDAO() {
		return new PeriodoAcademicoPostgreSqlDAO(connection);
	}

	@Override
	public RepeticionDAO getRepeticionDAO() {
		return new RepeticionPostgreSqlDAO(connection);
	}

	@Override
	public RespuestaDAO getRespuestaDAO() {
		return new RespuestaPostgreSqlDAO(connection);
	}

	@Override
	public TipoDocumentoDAO getTipoDocumentoDAO() {
		return new TipoDocumentoPostgreSqlDAO(connection);
	}

	@Override
	public TipoDuracionEventoDAO getTipoDuracionEventoDAO() {
		return new TipoDuracionEventoPostgreSqlDAO(connection);
	}

	@Override
	public TipoEventoDAO getTipoEventoDAO() {
		return new TipoEventoPostgreSqlDAO(connection);
	}

	@Override
	public TipoFestivoDAO getTipoFestivoDAO() {
		return new TipoFestivoPostgreSqlDAO(connection);
	}

	@Override
	public TipoFestivoFijoDAO getTipoFestivoFijoDAO() {
		return new TipoFestivoFijoPostgreSqlDAO(connection);
	}

	@Override
	public TipoFrecuenciaDAO getTipoFrecuenciaDAO() {
		return new TipoFrecuenciaPostgreSqlDAO(connection);
	}

	@Override
	public TipoNotaDAO getTipoNotaDAO() {
		return new TipoNotaPostgreSqlDAO(connection);
	}

	@Override
	public TipoNotificacionDAO getTipoNotificacionDAO() {
		return new TipoNotificacionPostgreSqlDAO(connection);
	}

	@Override
	public TipoPeriodoAcademicoDAO getTipoPeriodoAcademicoDAO() {
		return new TipoPeriodoAcademicoPostgreSqlDAO(connection);
	}

	@Override
	public UnidadTiempoDAO getUnidadTiempoDAO() {
		return new UnidadTiempoPostgreSqlDAO(connection);
	}

}
