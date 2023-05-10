package co.edu.uco.teqvim.data.dao.factory;

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
import co.edu.uco.teqvim.data.dao.factory.relational.postgresql.PostgreSqlDAOFactory;
import co.edu.uco.teqvim.data.dao.factory.relational.sqlserver.SqlServerDAOFactory;

public abstract class DAOFactory {

	public static DAOFactory getFactory(final Factory factory) {

		DAOFactory daoFactory;

		switch (factory) {
		case SQLSERVER: {
			daoFactory = new SqlServerDAOFactory();
			break;
		}
		case POSTGRESQL: {
			daoFactory = new PostgreSqlDAOFactory();
			break;
		}
		default:
			throw new IllegalArgumentException("Not implemented yet");
		}

		return daoFactory;
	}

	protected abstract void openConection();

	public abstract void closeConection();

	public abstract void initTransaction();

	public abstract void commitTransaction();

	public abstract void cancelTransaction();

	public abstract DuracionDAO getDuracionDAO();

	public abstract EstadoEstudianteDAO getEstadoEstudianteDAO();

	public abstract EstadoEventoDAO getEstadoEventoDAO();

	public abstract EstadoNotificacionDAO getEstadoNotificacionDAO();

	public abstract EstadoPeriodoAcademicoDAO getEstadoPeriodoAcademicoDAO();

	public abstract EstudianteDAO getEstudianteDAO();

	public abstract EventoDAO getEventoDAO();

	public abstract FestivoDAO getFestivoDAO();

	public abstract FrecuenciaDAO getFrecuenciaDAO();

	public abstract MateriaDAO getMateriaDAO();

	public abstract NotaDAO getNotaDAO();

	public abstract NotificacionDAO getNotificacionDAO();

	public abstract PaisDAO getPaisDAO();

	public abstract PeriodoAcademicoDAO getPeriodoAcademicoDAO();

	public abstract RepeticionDAO getRepeticionDAO();

	public abstract RespuestaDAO getRespuestaDAO();

	public abstract TipoDocumentoDAO getTipoDocumentoDAO();

	public abstract TipoDuracionEventoDAO getTipoDuracionEventoDAO();

	public abstract TipoEventoDAO getTipoEventoDAO();

	public abstract TipoFestivoDAO getTipoFestivoDAO();

	public abstract TipoFestivoFijoDAO getTipoFestivoFijoDAO();

	public abstract TipoFrecuenciaDAO getTipoFrecuenciaDAO();

	public abstract TipoNotaDAO getTipoNotaDAO();

	public abstract TipoNotificacionDAO getTipoNotificacionDAO();

	public abstract TipoPeriodoAcademicoDAO getTipoPeriodoAcademicoDAO();

	public abstract UnidadTiempoDAO getUnidadTiempoDAO();

}
