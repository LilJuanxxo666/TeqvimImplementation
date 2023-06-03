const formulario = document.querySelector('form');
const tituloInput = document.getElementById('titulo-evento');
const descripcionInput = document.getElementById('descripcion-evento');
const fechaInput = document.getElementById('fecha');
const horaInicioInput = document.getElementById('horaInicial');
const horaFinInput = document.getElementById('hora');

//el evento y mostrar el alert
function crearEvento(event) {
  event.preventDefault();

  //valores de los inputs
  const titulo = tituloInput.value;
  const descripcion = descripcionInput.value;
  const fecha = fechaInput.value;
  const horaInicio = horaInicioInput.value;
  const horaFin = horaFinInput.value;

  // Mostrar los datos
  console.log('Datos del evento:');
  console.log('Título:', titulo);
  console.log('Descripción:', descripcion);
  console.log('Fecha:', fecha);
  console.log('Hora de inicio:', horaInicio);
  console.log('Hora de fin:', horaFin);

  alert('Se ha creado exitosamente el evento');

  formulario.reset();
}

formulario.addEventListener('submit', crearEvento);