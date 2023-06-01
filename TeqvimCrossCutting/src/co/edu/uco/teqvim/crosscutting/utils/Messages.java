package co.edu.uco.teqvim.crosscutting.utils;

public final class Messages {

	private Messages() {
	}

	public static final class UtilSqlMessages {

		private UtilSqlMessages() {
		}

		public static final String CONNECTION_IS_OPEN_USER_MESSAGE = "Se ha presentado un problema tratando de validar si una conexión con la fuente de información estaba o no abierta...";
		public static final String CONNECTION_IS_OPEN_TECHNICAL_NULL_CONNECTION = "No es posible validar si una conexión está abierta cuando se encuentra nula";
		public static final String CONNECTION_IS_OPEN_TECHNICAL_SQL_EXCEPTION = "Se ha presentado una excepcion de tipo SQLException tratando de validar si la conexión estaba o no abierta. Por favor valide la traza de errores completa de la excepcion presentada";
		public static final String CONNECTION_IS_OPEN_TECHNICAL_EXCEPTION = "Se ha presentado una excepcion inesperada de tipo Exception tratando de validar si la conexión estaba o no abierta. Por favor valide la traza de errores completa de la excepcion presentada...";
		public static final String CONNECTION_IS_OPEN_TECHNICAL_ILEGAL_ARGUMENT_EXCEPTION = "Se ha presentado un excepcion de tipo IlegalArgumentException tratando de validar si la conexion estaba o no abierta. Por favor valida la traza de errores completa de la excepcion presentada...";
		public static final String CONNECTION_IS_OPEN_TECHNICAL_SECURITY_EXCEPTION = "Se ha presentado un SecurityExcepcion de tipo IlegalArgumentException tratando de validar si la conexion estaba o no abierta. Por favor valida la traza de errores completa de la excepcion presentada...";
		public static final String CONNECTION_IS_OPEN_TECHNICAL_NULL_POINTER_EXCEPTION = "Se ha presentado un NullPointerExcepcion de tipo IlegalArgumentException tratando de validar si la conexion estaba o no abierta. Por favor valida la traza de errores completa de la excepcion presentada...";
		public static final String CONNECTION_IS_CLOSE_USER_MESSAGE = "Se ha presentado un problema tratando de cerrar la conexion con la fuente de informacion estaba o no activa";
		public static final String CONNECTION_IS_CLOSE_TECHNICAL_SQL_EXCEPTION = "Se ha presentado un excepcion de tipo SQLException tratando de validar si la conexion estaba abierta. Por favor valida la traza de errores completa de la excepcion presentada...";
		public static final String CONNECTION_IS_CLOSE_TECHNICAL_EXCEPTION = "Se ha presentado un excepcion de tipo Exception tratando de validar si la conexion estaba abierta. Por favor valida la traza de errores completa de la excepcion presentada...";
		public static final String COMMIT_IS_STARTED_USER_MESSAGE = "Se ha presentado un problema tratando de validar si una transaccion esta activa o no";
		public static final String COMMIT_IS_STARTED_TECHNICAL_AUTOCOMMIT = "No es posible validar si se ha iniciado la transaccion, verificar si esta se encuentra en True";
		public static final String COMMIT_IS_STARTED_TECHNICAL_EXCEPTION = "Se ha presentado un excepcion de tipo Exception tratando de validar si la transaccion esta activa. Por favor valida la traza de errores completa de la excepcion presentada...";
		public static final String COMMIT_IS_STARTED_TECHNICAL_SQL_EXCEPTION = "Se ha presentado un excepcion de tipo SQLException tratando de validar si la transaccion esta activa. Por favor valida la traza de errores completa de la excepcion presentada...";
		public static final String COMMIT_IS_STARTING_USER_MESSAGE = "Se ha presentado un problema tratando de validar la transaccion inicial";
		public static final String CONFIRM_COMMIT_USER_MESSAGE = "Se ha presentado un problema tratando de validar la confirmacion de la transaccion";
		public static final String CANCEL_COMMIT_USER_MESSAGE = "Se ha presentado un problema tratando de validar la cancelacion de transaccion";
		public static final String COMMIT_TECHNICAL_SQL_EXCEPTION = "Se ha presentado un excepcion de tipo SQLException tratando de validar la transaccion. Por favor valida la traza de errores completa de la excepcion presentada...";

	}

	public static final class DuracionFacadeImplMessages {

		private DuracionFacadeImplMessages() {
		}

		public static final String REGISTER_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de registrar la informacion de la nueva duracion. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String REGISTER_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de registrar la nueva DuracionDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar la informacion de la duracion. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar la DuracionDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String MODIFY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de modificar la informacion de la duracion en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String MODIFY_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de modificar la DuracionDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String DROP_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de eliminar la informacion de la duracion en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String DROP_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de eliminar la DuracionDTO. Por favor valide la traza completa de la excepcion presentada...";

	}

	public static final class EstadoEstudianteFacadeImplMessages {

		private EstadoEstudianteFacadeImplMessages() {
		}

		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar la informacion del estado del estudiante. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar el EstadoEstudianteDTO. Por favor valide la traza completa de la excepcion presentada...";

	}

	public static final class EstadoEventoFacadeImplMessages {

		private EstadoEventoFacadeImplMessages() {
		}

		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar la informacion del estado del evento. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar el EstadoEventoDTO. Por favor valide la traza completa de la excepcion presentada...";

	}
	
	public static final class EstadoNotificacionFacadeImplMessages {
		private EstadoNotificacionFacadeImplMessages() {
		}
		
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar la informacion del estado notificacion. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar el EstadoNotificacionDTO. Por favor valide la traza completa de la excepcion presentada...";
	}

	public static final class EstadoPeriodoAcademicoFacadeImplMessages{
		private EstadoPeriodoAcademicoFacadeImplMessages() {
		}
		
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar la informacion del estado periodo academico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar el EstadoPeriodoAcademicoDTO. Por favor valide la traza completa de la excepcion presentada...";
	}
	
	public static final class EstudianteFacadeImplMessages{
		private EstudianteFacadeImplMessages() {
		}
		
		public static final String REGISTER_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de registrar la informacion del nuevo estudiante. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String REGISTER_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de registrar el nuevo EstudianteDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar la informacion del estudiante. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar el EstudianteDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String MODIFY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de modificar la informacion de un estudiante en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String MODIFY_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de modificar la EstudianteDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String DROP_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de eliminar la informacion de un estudiante en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String DROP_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de eliminar el EstudianteDTO. Por favor valide la traza completa de la excepcion presentada...";	
	}
	
	public static final class EventoFacadeImplMessages{
		private EventoFacadeImplMessages() {
		}
		
		public static final String REGISTER_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de registrar la informacion del nuevo evento. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String REGISTER_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de registrar el nuevo EventoDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar la informacion del evento. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar el EventoDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String MODIFY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de modificar la informacion de un evento en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String MODIFY_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de modificar la EventoDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String DROP_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de eliminar la informacion de un evento en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String DROP_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de eliminar el EventoDTO. Por favor valide la traza completa de la excepcion presentada...";
		
	}
	
	public static final class FestivoFacadeImplMessages{
		private FestivoFacadeImplMessages() {
		}
		
		public static final String REGISTER_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de registrar la informacion del nuevo festivo. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String REGISTER_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de registrar el nuevo FestivoDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar la informacion del festivo. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar el FestivoDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String MODIFY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de modificar la informacion de un festivo en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String MODIFY_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de modificar la FestivoDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String DROP_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de eliminar la informacion de un festivo en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String DROP_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de eliminar el FestivoDTO. Por favor valide la traza completa de la excepcion presentada...";
	}
	
	public static final class FrecuenciaFacadeImplMessages{
		private FrecuenciaFacadeImplMessages() {
		}
		
		public static final String REGISTER_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de registrar la informacion de la nueva frecuencia. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String REGISTER_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de registrar el nuevo FrecuenciaDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar la informacion de la frecuencia. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar la FrecuenciaDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String MODIFY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de modificar la informacion de una frecuencia en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String MODIFY_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de modificar la FrecuenciaDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String DROP_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de eliminar la informacion de una frecuencia en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String DROP_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de eliminar una FrecuenciaDTO. Por favor valide la traza completa de la excepcion presentada...";
	}
	
	public static final class MateriaFacadeImplMessages{
		private MateriaFacadeImplMessages() {
		}
		
		public static final String REGISTER_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de registrar la informacion de una nueva materia. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String REGISTER_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de registrar la nueva MateriaDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar la informacion de la materia. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar la MateriaDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String MODIFY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de modificar la informacion de una materia en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String MODIFY_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de modificar la MateriaDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String DROP_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de eliminar la informacion de una materia en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String DROP_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de eliminar una MateriaDTO. Por favor valide la traza completa de la excepcion presentada...";
	}
	
	public static final class NotaFacadeImplMessages{
		private NotaFacadeImplMessages() {	
		}
		
		public static final String REGISTER_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de registrar la informacion de una nueva nota. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String REGISTER_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de registrar la nueva notaDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar la informacion de la nota. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar la NotaDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String MODIFY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de modificar la informacion de una nota en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String MODIFY_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de modificar la NotaDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String DROP_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de eliminar la informacion de una nota en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String DROP_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de eliminar una NotaDTO. Por favor valide la traza completa de la excepcion presentada...";
	}
	
	public static final class NotificacionFacadeImplMessages{
		private NotificacionFacadeImplMessages() {
		}
		
		public static final String REGISTER_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de registrar la informacion de una nueva notificacion. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String REGISTER_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de registrar la nueva NotificacionDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar la informacion de la notificacion. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar la NotificacionDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String MODIFY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de modificar la informacion de una notificacion en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String MODIFY_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de modificar la NotificacionDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String DROP_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de eliminar la informacion de una notificacion en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String DROP_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de eliminar una NotificacionDTO. Por favor valide la traza completa de la excepcion presentada...";
	}
	
	public static final class PaisFacadeImplMessages{
		private PaisFacadeImplMessages() {
		}
		
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar la informacion del pais. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar el PaisDTO. Por favor valide la traza completa de la excepcion presentada...";
		
	}
	
	public static final class PeriodoAcademicoFacadeImplMessages{
		private PeriodoAcademicoFacadeImplMessages() {
		}
		public static final String REGISTER_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de registrar la informacion de un nuevo periodo academico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String REGISTER_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de registrar el nuevo PeriodoAcademicoDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar la informacion del periodo academico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar la PeriodoAcademicoDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String MODIFY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de modificar la informacion de un periodo academico en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String MODIFY_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de modificar el PeriodoAcademicoDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String DROP_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de eliminar la informacion de un periodo academico en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String DROP_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de eliminar un PeriodoAcademicoDTO. Por favor valide la traza completa de la excepcion presentada...";
	}
	
	public static final class RepeticionFacadeImplMessage{
		private RepeticionFacadeImplMessage() {
		}
		public static final String REGISTER_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de registrar la informacion de una nueva repeticion. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String REGISTER_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de registrar la nueva RepeticionDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar la informacion de la repeticion. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar la RepeticionDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String MODIFY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de modificar la informacion de una repeticion en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String MODIFY_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de modificar la RepeticionDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String DROP_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de eliminar la informacion de una repeticion en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String DROP_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de eliminar una RepeticionDTO. Por favor valide la traza completa de la excepcion presentada...";
		
	}
	
	public static final class RespuestaFacadeImplMessages{
		private RespuestaFacadeImplMessages() {
		}
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar la respuesta. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar el RespuestaDTO. Por favor valide la traza completa de la excepcion presentada...";
	}
	
	public static final class TipoDuracionEventoFacadeImplMessages{
		private TipoDuracionEventoFacadeImplMessages() {
		}
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar el tipo duracion evento. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar el TipoDuracionEventoDTO. Por favor valide la traza completa de la excepcion presentada...";
	}
	
	public static final class TipoEventoFacadeImplMessages{
		private TipoEventoFacadeImplMessages() {
		}
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar el tipo evento. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar el TipoEventoDTO. Por favor valide la traza completa de la excepcion presentada...";
	}
	
	public static final class TipoFestivoFacadeImplMessages{
		private TipoFestivoFacadeImplMessages() {
		}
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar el tipo festivo. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar el TipoFestivoDTO. Por favor valide la traza completa de la excepcion presentada...";
	}
	
	public static final class TipoFestivoFijoFacadeImplMessages{
		private TipoFestivoFijoFacadeImplMessages() {
		}
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar el tipo festivo fijo. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar el TipoFestivoFijoDTO. Por favor valide la traza completa de la excepcion presentada...";
	}
	
	public static final class TipoFrecuenciaFacadeImplMessages{
		private TipoFrecuenciaFacadeImplMessages() {
		}
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar el tipo frecuencia. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar el TipoFrecuenciaDTO. Por favor valide la traza completa de la excepcion presentada...";	
	}
	
	public static final class TipoNotaFacadeImplMessages{
		private TipoNotaFacadeImplMessages() {
		}
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar el tipo nota. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar el TipoNotaDTO. Por favor valide la traza completa de la excepcion presentada...";	
	}
	
	public static final class TipoNotificacionFacadeImplMessages{
		private TipoNotificacionFacadeImplMessages() {
		}
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar el tipo notificacion. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar el TipoNotificacionDTO. Por favor valide la traza completa de la excepcion presentada...";	
	}
	
	public static final class TipoPeriodoAcademicoFacadeImplMessages{
		private TipoPeriodoAcademicoFacadeImplMessages() {
		}
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar el tipo periodo academico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar el TipoPeriodoAcademicoDTO. Por favor valide la traza completa de la excepcion presentada...";	
	}
	
	public static final class UnidadTiempoFacadeImplMessages{
		private UnidadTiempoFacadeImplMessages() {
		}
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar las unidades de tiempo. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar la UnidadTiempoDTO. Por favor valide la traza completa de la excepcion presentada...";	
	}
	
	public static final class NombreDiasemanaFacadeImplMessages{
		private NombreDiasemanaFacadeImplMessages() {
		}
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar los nombres del dia de la semana. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar la NombreDiaSemanaDTO. Por favor valide la traza completa de la excepcion presentada...";	
	}
	public static final class DiaSemanaFacadeImplMessages{
		private DiaSemanaFacadeImplMessages() {
		}
		public static final String REGISTER_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de registrar la informacion de un nuevo dia de semana. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String REGISTER_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de registrar un nuevo DiaSemanaDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String LIST_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de listar la informacion del dia semana. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String LIST_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de listar el DiaSemanaDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String MODIFY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de modificar la informacion de un dia semana en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String MODIFY_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de modificar un DiaSemanaDTO. Por favor valide la traza completa de la excepcion presentada...";
		public static final String DROP_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de eliminar la informacion de un dia semana en específico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String DROP_EXCEPTION_TECHNICAL_MESSAGE = "Se ha presentado un excepción no conocida al momento de eliminar un DiaSemanaDTO. Por favor valide la traza completa de la excepcion presentada...";
		
	}
	
	public static final class SqlDAOMessages{
		private SqlDAOMessages() {}
		public static final String USER_MESSAGE = "Se ha presentado un problema tratando de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste comuniquese con el administrador de la aplicacion.";
		public static final String TECHNICAL_MESSAGE = "No se ha podido crear el SqlDAO, debido a que la conexion no esta abierta";
	}
	
	
}
