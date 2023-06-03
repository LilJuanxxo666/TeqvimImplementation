document.getElementById("formulario").addEventListener("submit", function(event) {
    event.preventDefault();
  
    var primerNombre = document.getElementById("primer-nombre").value;
    var segundoNombre = document.getElementById("segundo-nombre").value;
    var primerApellido = document.getElementById("primer-apellido").value;
    var segundoApellido = document.getElementById("segundo-apellido").value;
    var numeroTelefonico = document.getElementById("numero-telefonico").value;
    var correo = document.getElementById("correo").value;
    var pais = document.getElementById("pais").value;
    var confirmacionCorreo = document.getElementById("confirmacion-correo").value;
    var tipoDocumento = document.getElementById("tipo-documento").value;
    var numeroDocumento = document.getElementById("numero-documento").value;
    var estadoEstudiante = document.getElementById("estado-estudiante").value;
    var fechaNacimiento = document.getElementById("nacimiento").value;
    var contraseña = document.getElementById("contraseña").value;
  
  
    alert("Estudiante registrado con éxito");
  

    console.log("Primer Nombre: " + primerNombre);
    console.log("Segundo Nombre: " + segundoNombre);
    console.log("Primer Apellido: " + primerApellido);
    console.log("Segundo Apellido: " + segundoApellido);
    console.log("Número Telefónico: " + numeroTelefonico);
    console.log("Correo Electrónico: " + correo);
    console.log("País: " + pais);
    console.log("Confirmación de Correo: " + confirmacionCorreo);
    console.log("Tipo de Documento: " + tipoDocumento);
    console.log("Número de Documento: " + numeroDocumento);
    console.log("Estado del Estudiante: " + estadoEstudiante);
    console.log("Fecha de Nacimiento: " + fechaNacimiento);
    console.log("Contraseña: " + contraseña);
  

    var estudiante = {
      primerNombre: primerNombre,
      segundoNombre: segundoNombre,
      primerApellido: primerApellido,
      segundoApellido: segundoApellido,
      numeroTelefonico: numeroTelefonico,
      correo: correo,
      pais: pais,
      confirmacionCorreo: confirmacionCorreo,
      tipoDocumento: tipoDocumento,
      numeroDocumento: numeroDocumento,
      estadoEstudiante: estadoEstudiante,
      fechaNacimiento: fechaNacimiento,
      contraseña: contraseña
    };

    fetch('http://localhost:8080/publiuco/api/estudiante', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(estudiante)
    })
    .then(function(response) {
      if (response.ok) {
        alert('Estudiante registrado con éxito');
      } else {
        alert('Error al registrar estudiante');
      }
    })
    .catch(function(error) {
      alert('Error de conexión');
    });
  });
