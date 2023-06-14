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
	
	public static final class EstadoEstudiantePostgresSqlDAOMessages{
		private EstadoEstudiantePostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion de estado estudiante. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase EstadoEstudiantePostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase EstadoEstudiantePostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos del estado estudiante. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase EstadoEstudiantePostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase EstadoEstudiantePostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos del estado estudiante. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase EstadoEstudiantePostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase EstadoEstudiantePostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
	}
	
	public static final class EstadoEventoPostgresSqlDAOMessages{
		private EstadoEventoPostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion de estado evento. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase EstadoEventoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase EstadoEventoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos del estado evento. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase EstadoEventoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase EstadoEventoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos del estado evento. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase EstadoEventoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase EstadoEventoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
	}
	
	public static final class EstadoNotificacionPostgresSqlDAOMessages{
		private EstadoNotificacionPostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion de estado notificacion. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase EstadoNotificacionPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase EstadoNotificacionPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos del estado notificacion. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase EstadoNotificacionPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase EstadoNotificacionPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos del estado notificacion. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase EstadoNotificacionPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase EstadoNotificacionPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
	}
	
	public static final class EstadoPeriodoAcademicoPostgresSqlDAOMessages{
		private EstadoPeriodoAcademicoPostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion de estado periodo academico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase EstadoPeriodoAcademicoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase EstadoPeriodoAcademicoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos del estado periodo academico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase EstadoPeriodoAcademicoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase EstadoPeriodoAcademicoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos del estado periodo academico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase EstadoPeriodoAcademicoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase EstadoPeriodoAcademicoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
	}
	
	public static final class UnidadTiempoPostgresSqlDAOMessages{
		private UnidadTiempoPostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion de las unidades tiempo. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase UnidadTiempoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase UnidadTiempoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos de unidad tiempo. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase UnidadTiempoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase UnidadTiempoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos de unidad tiempo. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase UnidadTiempoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase UnidadTiempoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
	}
	
	public static final class TipoPeriodoAcademicoPostgresSqlDAOMessages{
		private TipoPeriodoAcademicoPostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion de los tipo periodo academico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase TipoPeriodoAcademicoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase TipoPeriodoAcademicoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos de los tipo periodo academico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase TipoPeriodoAcademicoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase TipoPeriodoAcademicoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos de los tipo periodo academico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase TipoPeriodoAcademicoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase TipoPeriodoAcademicoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		
	}
	
	public static final class TipoNotificacionPostgresSqlDAOMessages{
		private TipoNotificacionPostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion de los tipo notificacion. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase TipoNotificacionPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase TipoNotificacionPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos de los tipo notificacion. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase TipoNotificacionPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase TipoNotificacionPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos de los tipo notificacion. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase TipoNotificacionPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase TipoNotificacionPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		
	}
	
	public static final class TipoNotaPostgresSqlDAOMessages{
		private TipoNotaPostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion de los tipo nota. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase TipoNotaPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase TipoNotaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos de los tipo nota. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase TipoNotaPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase TipoNotaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos de los tipo nota. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase TipoNotaPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase TipoNotaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";	
	}
	
	public static final class TipoFrecuenciaPostgresSqlDAOMessages{
		private TipoFrecuenciaPostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion de los tipo frecuencia. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase TipoFrecuenciaPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase TipoFrecuenciaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos de los tipo frecuencia. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase TipoFrecuenciaPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase TipoFrecuenciaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos de los tipo frecuencia. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase TipoFrecuenciaPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase TipoFrecuenciaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";	
	}
	
	public static final class TipoFestivoPostgresSqlDAOMessages{
		private TipoFestivoPostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion de los tipo festivo. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase TipoFestivoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase TipoFestivoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos de los tipo festivo. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase TipoFestivoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase TipoFestivoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos de los tipo festivo. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase TipoFestivoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase TipoFestivoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";	
	}
	
	public static final class TipoFestivoFijoPostgresSqlDAOMessages{
		private TipoFestivoFijoPostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion de los tipo festivo fijo. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase TipoFestivoFijoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase TipoFestivoFijoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos de los tipo festivo fijo. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase TipoFestivoFijoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase TipoFestivoFijoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos de los tipo festivo fijo. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase TipoFestivoFijoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase TipoFestivoFijoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";	
	}
	
	public static final class TipoEventoPostgresSqlDAOMessages{
		private TipoEventoPostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion de los tipo evento. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase TipoEventoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase TipoEventoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos de los tipo evento. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase TipoEventoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase TipoEventoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos de los tipo evento. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase TipoEventoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase TipoEventoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";	
	}
	
	public static final class TipoDuracionEventoPostgresSqlDAOMessages{
		private TipoDuracionEventoPostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion de los tipo duracion evento. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase TipoDuracionEventoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase TipoDuracionEventoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos de los tipo duracion evento. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase TipoDuracionEventoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase TipoDuracionEventoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos de los tipo duracion evento. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase TipoDuracionEventoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase TipoDuracionEventoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";	
	}
	
	public static final class TipoDocumentoPostgresSqlDAOMessages{
		private TipoDocumentoPostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion de los tipo documento. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase TipoDocumentoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase TipoDocumentoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos de los tipo documento. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase TipoDocumentoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase TipoDocumentoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos de los tipo documento. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase TipoDocumentoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase TipoDocumentoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";	
	}
	
	public static final class RespuestaPostgresSqlDAOMessages{
		private RespuestaPostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion de la respuesta. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase RespuestaPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase RespuestaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos de las respuesta. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase RespuestaPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase RespuestaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos de las respuesta. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase RespuestaPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase RespuestaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";	
	}
	
	public static final class PaisPostgresSqlDAOMessages{
		private PaisPostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion del pais. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase PaisPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase PaisPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos del pais. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase PaisPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase PaisPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos del pais. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase PaisPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase PaisPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";	
	}
	
	public static final class DuracionPostgresSqlDAOMessages{
		private DuracionPostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion de la duracion. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase DuracionPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase DuracionPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos de la duracion. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase DuracionPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase DuracionPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos de la duracion. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase DuracionPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase DuracionPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String CREATE_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema tratando de registrar la informacion del nuevo duracion. Por favor intente de nuevo y si el problema persiste contacte al administrador respectivo";
		public static final String CREATE_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del método create de la clase DuracionPostgreSqlDAO de tipo Sqlexception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String CREATE_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema inesperado dentro del método create de la clase DuracionSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String UPDATE_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema tratando de modificar la informacion del nuevo duracion. Por favor intente de nuevo y si el problema persiste contacte al administrador respectivo";
		public static final String UPDATE_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del método update de la clase DuracionPostgreSqlDAO de tipo Sqlexception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String UPDATE_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema inesperado dentro del método update de la clase DuracionSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String DELETE_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema tratando de dar de baja la informacion del nuevo duracion. Por favor intente de nuevo y si el problema persiste contacte al administrador respectivo";
		public static final String DELETE_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del método delete de la clase DuracionPostgreSqlDAO de tipo Sqlexception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String DELETE_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema inesperado dentro del método delete de la clase DuracionSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
	}
	
	public static final class EstudiantePostgresSqlDAOMessages{
		private EstudiantePostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion del estudiante. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase EstudiantePostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase EstudiantePostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos del estudiante. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase EstudiantePostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase EstudiantePostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos del estudiante. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase EstudiantePostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase EstudiantePostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String CREATE_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema tratando de registrar la informacion del nuevo estudiante. Por favor intente de nuevo y si el problema persiste contacte al administrador respectivo";
		public static final String CREATE_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del método create de la clase EstudiantePostgreSqlDAO de tipo Sqlexception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String CREATE_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema inesperado dentro del método create de la clase EstudiantePostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String UPDATE_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema tratando de modificar la informacion del nuevo estudiante. Por favor intente de nuevo y si el problema persiste contacte al administrador respectivo";
		public static final String UPDATE_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del método update de la clase EstudiantePostgreSqlDAO de tipo Sqlexception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String UPDATE_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema inesperado dentro del método update de la clase EstudiantePostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String DELETE_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema tratando de dar de baja la informacion del estudiante. Por favor intente de nuevo y si el problema persiste contacte al administrador respectivo";
		public static final String DELETE_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del método delete de la clase EstudiantePostgreSqlDAO de tipo Sqlexception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String DELETE_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema inesperado dentro del método delete de la clase EstudiantePostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
	}
	
	public static final class EventoPostgresSqlDAOMessages{
		private EventoPostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion del evento. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase EventoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase EventoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos del evento. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase EventoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase EventoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos del evento. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase EventoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase EventoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String CREATE_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema tratando de registrar la informacion del nuevo evento. Por favor intente de nuevo y si el problema persiste contacte al administrador respectivo";
		public static final String CREATE_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del método create de la clase EventoPostgreSqlDAO de tipo Sqlexception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String CREATE_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema inesperado dentro del método create de la clase EventoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String UPDATE_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema tratando de modificar la informacion del nuevo evento. Por favor intente de nuevo y si el problema persiste contacte al administrador respectivo";
		public static final String UPDATE_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del método update de la clase EventoPostgreSqlDAO de tipo Sqlexception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String UPDATE_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema inesperado dentro del método update de la clase EventoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String DELETE_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema tratando de dar de baja la informacion del evento. Por favor intente de nuevo y si el problema persiste contacte al administrador respectivo";
		public static final String DELETE_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del método delete de la clase EventoPostgreSqlDAO de tipo Sqlexception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String DELETE_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema inesperado dentro del método delete de la clase EventoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
	}
	public static final class IdentificadorValidationMessage {
        private IdentificadorValidationMessage() {
        }

        public static final String IDENTIFICADOR_EMPTY_MESSAGE = "No es posible continuar con el identificador vacio";
        public static final String IDENTIFICADOR_DEFAULT_MESSAGE = "No es posible continuar con el identificador vacio";
    }
	
	public static final class EstudianteValidatorMessage {
        private EstudianteValidatorMessage() {
        }

        public static final String UPDATE_ESTUDIANTE_OBJECT_NULL_MESSAGE = "No es posible actualizar un estudiante vacio";
        public static final String CREATE_ESTUDIANTE_OBJECT_NULL_MESSAGE = "No es posible crear un estudiante vacio";
        public static final String NUMERO_TELEFONO_EMPTY_MESSAGE = "El numero telefonico del estudiante no puede estar vacío";
        public static final String NUMERO_TELEFONO_LENGTH_MESSAGE = "El numero telefonico del estudiante no ser mayor a 15 digitos";
        public static final String NOMBRE_EMPTY_MESSAGE = "El nombre o apellido del estudiante no puede estar vacío";
        public static final String NOMBRE_LENGTH_MESSAGE = "El nombre o apellido no puede ser mayor a 20 caracteres";
        public static final String CORREO_EMPTY_MESSAGE = "El correo del estudiante no puede estar vacío";
        public static final String CORREO_VALID_MESSAGE = "El correo del estudiante no cumple con el formato adecuado";
        public static final String CONTRASENA_EMPTY_MESSAGE = "La contraseña del estudiante no puede estar vacío";
        public static final String CONTRASENA_VALID_MESSAGE = "La contraseña del estudiante no puede tener caracteres especiales";
        public static final String CONTRASENA_LENGHT_MORE_MESSAGE = "La contraseña del estudiante no puede tener mas de 16 caracteres";
        public static final String CONTRASENA_LENGHT_LESS_MESSAGE = "La contraseña del estudiante no puede tener menos de 8 caracteres";
        public static final String FECHA_NACIMIENTO_EMPTY_LESS_MESSAGE = "La fecha de nacimiento no puede estar vacía";
        public static final String FECHA_NACIMIENTO_IS_AFTER_LESS_MESSAGE = "La fecha de nacimiento esta después de la fecha actual";
        public static final String NUMERO_DOCUMENTO_EMPTY_LESS_MESSAGE = "El numero de documento del estudiante no puede estar vacío";
        public static final String NUMERO_DOCUMENTO_LENGHT_LESS_MESSAGE = "El numero de documento del estudiante ser mayor a 15 caracteres";
    }
	
	public static final class EstudianteControllerMessages{
		private EstudianteControllerMessages() {
			
		}
		public static final String READ_ESTUDIANTE_RIGHT_MESSAGE = "Estudiante consultados correctamente";
		public static final String CREATE_ESTUDIANTE_RIGHT_MESSAGE = "El estudiante se ha creado correctamente";
		public static final String UPDATE_ESTUDIANTE_RIGHT_MESSAGE = "El estudiante se ha actualizado correctamente";
		public static final String DELETE_ESTUDIANTE_RIGHT_MESSAGE = "El estudiante se ha elimidado correctamente";
		public static final String UNEXPECTED_PROBLEM_MESSAGE = "Se ha presentado un problema inesperado. Por favor, intenta de nuevo y si el problema persiste, contacta al administrador de la aplicación";
		public static final String UNEXPECTED_PROBLEM_CREATE_LOG_MESSAGE = "Se ha presentado un problema inesperado en el metodo create. Por favor validar la consola de errores...";
		public static final String UNEXPECTED_PROBLEM_UPDATE_LOG_MESSAGE = "Se ha presentado un problema inesperado en el metodo update. Por favor validar la consola de errores...";
		public static final String UNEXPECTED_PROBLEM_DELETE_LOG_MESSAGE = "Se ha presentado un problema inesperado en el metodo delete. Por favor validar la consola de errores...";
	}
	
	public static final class EstudianteBusinessImplMessages{
		private EstudianteBusinessImplMessages() {
			
		}
		public static final String NUMERO_IDENTIFICACION_MESSAGE = "El estudiante que intenta crear ya se encuentra registrado, por favor intente con un nuevo numero de identificación o de ser necesario actualizarlo";
		public static final String CORREO_MESSAGE = "El estudiante que intenta crear ya se encuentra registrado, por favor intente con un nuevo correo electronico o de ser necesario actualizarlo";
		public static final String NUMERO_TELEFONICO_MESSAGE = "El estudiante que intenta crear ya se encuentra registrado, por favor intente con un nuevo numero telefónico o de ser necesario actualizarlo";
	}
	
	public static final class PeriodoAcademicoPostgresSqlDAOMessages{
		private PeriodoAcademicoPostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion del periodo academico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase PeriodoAcademicoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase PeriodoAcademicoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos del periodo academico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase PeriodoAcademicoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase PeriodoAcademicoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos del periodo academico. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase PeriodoAcademicoPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase PeriodoAcademicoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String CREATE_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema tratando de registrar la informacion del nuevo periodo academico. Por favor intente de nuevo y si el problema persiste contacte al administrador respectivo";
		public static final String CREATE_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del método create de la clase PeriodoAcademicoPostgreSqlDAO de tipo Sqlexception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String CREATE_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema inesperado dentro del método create de la clase PeriodoAcademicoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String UPDATE_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema tratando de modificar la informacion del nuevo periodo academico. Por favor intente de nuevo y si el problema persiste contacte al administrador respectivo";
		public static final String UPDATE_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del método update de la clase PeriodoAcademicoPostgreSqlDAO de tipo Sqlexception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String UPDATE_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema inesperado dentro del método update de la clase PeriodoAcademicoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String DELETE_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema tratando de dar de baja la informacion del periodo academico. Por favor intente de nuevo y si el problema persiste contacte al administrador respectivo";
		public static final String DELETE_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del método delete de la clase PeriodoAcademicoPostgreSqlDAO de tipo Sqlexception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String DELETE_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema inesperado dentro del método delete de la clase PeriodoAcademicoPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
	}
	public static final class NombreDiaSemanaPostgresSqlDAOMessages{
		private NombreDiaSemanaPostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion de los nombres del dia de la semana. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase NombreDiaSemanaPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase NombreDiaSemanaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos de los nombres del dia de la semana. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase NombreDiaSemanaPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase NombreDiaSemanaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos de los nombres del dia de la semana. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase NombreDiaSemanaPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase NombreDiaSemanaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";	
	}
	
	public static final class PeriodoAcademicoControllerMessages{
		private PeriodoAcademicoControllerMessages() {
			
		}
		public static final String READ_ESTUDIANTE_RIGHT_MESSAGE = "Periodo Academico consultados correctamente";
		public static final String CREATE_ESTUDIANTE_RIGHT_MESSAGE = "El Periodo Academico se ha creado correctamente";
		public static final String UPDATE_ESTUDIANTE_RIGHT_MESSAGE = "El Periodo Academico se ha actualizado correctamente";
		public static final String DELETE_ESTUDIANTE_RIGHT_MESSAGE = "El Periodo Academico  se ha elimidado correctamente";
		public static final String UNEXPECTED_PROBLEM_MESSAGE = "Se ha presentado un problema inesperado. Por favor, intenta de nuevo y si el problema persiste, contacta al administrador de la aplicación";
		public static final String UNEXPECTED_PROBLEM_CREATE_LOG_MESSAGE = "Se ha presentado un problema inesperado en el metodo create. Por favor validar la consola de errores...";
		public static final String UNEXPECTED_PROBLEM_UPDATE_LOG_MESSAGE = "Se ha presentado un problema inesperado en el metodo update. Por favor validar la consola de errores...";
		public static final String UNEXPECTED_PROBLEM_DELETE_LOG_MESSAGE = "Se ha presentado un problema inesperado en el metodo delete. Por favor validar la consola de errores...";
	}
	
	public static final class PeriodoAcademicoValidatorMessage {
        private PeriodoAcademicoValidatorMessage() {
        }

        public static final String UPDATE_ESTUDIANTE_OBJECT_NULL_MESSAGE = "No es posible actualizar un periodo academico vacio";
        public static final String CREATE_ESTUDIANTE_OBJECT_NULL_MESSAGE = "No es posible crear un periodo academico vacio";
        public static final String FECHA_INICIO_EMPTY_MESSAGE = "La fecha inicio no puede estar vacía";
        public static final String FECHA_FIN_EMPTY_MESSAGE = "La fecha fin no puede estar vacía";
        public static final String NOMBRE_EMPTY_MESSAGE = "El nombre del periodo academico no puede estar vacío";
        public static final String NOMBRE_LENGTH_MESSAGE = "La longitud del nombre del periodo academico no puede ser mayor a 20 caracteres";
        public static final String PROMEDIO_PERIODO_EMPTY_MESSAGE = "El promedio materia del periodo academico no puede estar vacío";
        public static final String PROMEDIO_PERIODO_MORE_MESSAGE = "El promedio materia del periodo academico no puede ser mayor a 5";
        public static final String PROMEDIO_PERIODO_LESS_MESSAGE = "El promedio materia del periodo academico no puede ser menor a 0";
        public static final String PROMEDIO_PERIODO_FORMAT_MESSAGE = "El promedio materia no cumple con el formato adecuado";
    }
	
	public static final class PeriodoAcademicoBusinessImplMessage {
		private PeriodoAcademicoBusinessImplMessage() {
		}
		public static final String DATE_IS_AFTER = "No es posible tener una fecha inicio igual o mayor a la fecha fin";
        public static final String DATE_IS_LESS_A_WEEK = "El periodo academico debe durar minimo una semana";
        public static final String DATE_IS_INVALID = "El periodo academico no se puede crear con mas de una año de anticipación";
	}
	public static final class ConsultedControllerMessage{
		private ConsultedControllerMessage() {
		}
		public static final String TIPO_EVENTO_CONSULTED = "Tipo evento consultadas correctamente";
		public static final String UNIDAD_TIEMPO_CONSULTED = "Unidad tiempo consultados correctamente";
		public static final String PAIS_CONSULTED = "Paises consultados correctamente";
		public static final String TIPO_PERIODO_ACADEMICO_CONSULTED = "Tipo periodo academico consultadas correctamente";
		public static final String TIPO_NOTIFICACION_CONSULTED = "Tipo notificacion consultadas correctamente";
		public static final String TIPO_NOTA_CONSULTED = "Tipo nota consultadas correctamente";
		public static final String TIPO_FRECUENCIA_CONSULTED = "Tipo frecuencia consultadas correctamente";
		public static final String TIPO_FESTIVO_FIJO_CONSULTED = "Tipo festivo fijo consultadas correctamente";
		public static final String TIPO_FESTIVO_CONSULTED = "Tipo festivo consultadas correctamente";
		public static final String TIPO_DURACION_EVENTO_CONSULTED = "Tipo duracion evento consultados correctamente";
		public static final String TIPO_DOCUMENTO_CONSULTED = "Tipo documento consultadas correctamente";
		public static final String RESPUESTA_CONSULTED = "Respuesta consultadas correctamente";
		public static final String NOMBRE_DIA_SEMANA_CONSULTED = "Nombre dia semana consultados correctamente";
		public static final String ESTADO_PERIODO_ACADEMICO_CONSULTED = "Estado periodo academico consultados correctamente";
		public static final String ESTADO_NOTIFICACION_CONSULTED = "Estado notificación consultados correctamente";
		public static final String ESTADO_EVENTO_CONSULTED = "Estado evento consultados correctamente";
		public static final String ESTADO_ESTUDIANTE_CONSULTED = "Estado estudiante consultadas correctamente";
	}
	public static final class MateriaPostgresSqlDAOMessages{
		private MateriaPostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion de la materia. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase MateriaPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase MateriaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos de la materia. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase MateriaPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase MateriaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos de la materia. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase MateriaPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase MateriaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String CREATE_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema tratando de registrar la informacion de la nueva materia. Por favor intente de nuevo y si el problema persiste contacte al administrador respectivo";
		public static final String CREATE_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del método create de la clase MateriaPostgreSqlDAO de tipo Sqlexception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String CREATE_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema inesperado dentro del método create de la clase MateriaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String UPDATE_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema tratando de modificar la informacion de la nueva materia. Por favor intente de nuevo y si el problema persiste contacte al administrador respectivo";
		public static final String UPDATE_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del método update de la clase MateriaPostgreSqlDAO de tipo Sqlexception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String UPDATE_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema inesperado dentro del método update de la clase MateriaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String DELETE_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema tratando de dar de baja la informacion de la materia. Por favor intente de nuevo y si el problema persiste contacte al administrador respectivo";
		public static final String DELETE_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del método delete de la clase MateriaPostgreSqlDAO de tipo Sqlexception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String DELETE_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema inesperado dentro del método delete de la clase MateriaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
	}
	public static final class NotaPostgresSqlDAOMessages{
		private NotaPostgresSqlDAOMessages() {
		}
		public static final String READ_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de traer la informacion de la nota. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String READ_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase NotaPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String READ_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo READ de la clase NotaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de asignar los datos de la nota. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase NotaPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo setParameters de la clase NotaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema trantando de ejecutar los datos de la nota. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion.";
		public static final String EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase NotaPostgreSqlDAO de tipo SqlException. Por favor verifique la traza completa de la excepcion presentada";
		public static final String EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del metodo executeQuery de la clase NotaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String CREATE_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema tratando de registrar la informacion de la nueva nota. Por favor intente de nuevo y si el problema persiste contacte al administrador respectivo";
		public static final String CREATE_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del método create de la clase NotaPostgreSqlDAO de tipo Sqlexception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String CREATE_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema inesperado dentro del método create de la clase NotaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String UPDATE_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema tratando de modificar la informacion de la nueva nota. Por favor intente de nuevo y si el problema persiste contacte al administrador respectivo";
		public static final String UPDATE_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del método update de la clase NotaPostgreSqlDAO de tipo Sqlexception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String UPDATE_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema inesperado dentro del método update de la clase NotaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String DELETE_EXCEPTION_USER_MESSAGE = "Se ha presentado un problema tratando de dar de baja la informacion de la nota. Por favor intente de nuevo y si el problema persiste contacte al administrador respectivo";
		public static final String DELETE_TECHNICAL_SQL_EXCEPTION_MESSAGE = "Se ha presentado un problema dentro del método delete de la clase NotaPostgreSqlDAO de tipo Sqlexception. Por favor verifique la traza completa de la excepcion presentada";
		public static final String DELETE_TECHNICAL_EXCEPTION_MESSAGE = "Se ha presentado un problema inesperado dentro del método delete de la clase NotaPostgreSqlDAO de tipo Exception. Por favor verifique la traza completa de la excepcion presentada";
	}
	public static final class MateriaControllerMessages{
		private MateriaControllerMessages() {
			
		}
		public static final String READ_ESTUDIANTE_RIGHT_MESSAGE = "Estudiante consultados correctamente";
		public static final String CREATE_ESTUDIANTE_RIGHT_MESSAGE = "El estudiante se ha creado correctamente";
		public static final String UPDATE_ESTUDIANTE_RIGHT_MESSAGE = "El estudiante se ha actualizado correctamente";
		public static final String DELETE_ESTUDIANTE_RIGHT_MESSAGE = "El estudiante se ha elimidado correctamente";
		public static final String UNEXPECTED_PROBLEM_MESSAGE = "Se ha presentado un problema inesperado. Por favor, intenta de nuevo y si el problema persiste, contacta al administrador de la aplicación";
		public static final String UNEXPECTED_PROBLEM_CREATE_LOG_MESSAGE = "Se ha presentado un problema inesperado en el metodo create. Por favor validar la consola de errores...";
		public static final String UNEXPECTED_PROBLEM_UPDATE_LOG_MESSAGE = "Se ha presentado un problema inesperado en el metodo update. Por favor validar la consola de errores...";
		public static final String UNEXPECTED_PROBLEM_DELETE_LOG_MESSAGE = "Se ha presentado un problema inesperado en el metodo delete. Por favor validar la consola de errores...";
	}
	public static final class NotaControllerMessages{
		private NotaControllerMessages() {
			
		}
		public static final String READ_ESTUDIANTE_RIGHT_MESSAGE = "Estudiante consultados correctamente";
		public static final String CREATE_ESTUDIANTE_RIGHT_MESSAGE = "El estudiante se ha creado correctamente";
		public static final String UPDATE_ESTUDIANTE_RIGHT_MESSAGE = "El estudiante se ha actualizado correctamente";
		public static final String DELETE_ESTUDIANTE_RIGHT_MESSAGE = "El estudiante se ha elimidado correctamente";
		public static final String UNEXPECTED_PROBLEM_MESSAGE = "Se ha presentado un problema inesperado. Por favor, intenta de nuevo y si el problema persiste, contacta al administrador de la aplicación";
		public static final String UNEXPECTED_PROBLEM_CREATE_LOG_MESSAGE = "Se ha presentado un problema inesperado en el metodo create. Por favor validar la consola de errores...";
		public static final String UNEXPECTED_PROBLEM_UPDATE_LOG_MESSAGE = "Se ha presentado un problema inesperado en el metodo update. Por favor validar la consola de errores...";
		public static final String UNEXPECTED_PROBLEM_DELETE_LOG_MESSAGE = "Se ha presentado un problema inesperado en el metodo delete. Por favor validar la consola de errores...";
	}
}
