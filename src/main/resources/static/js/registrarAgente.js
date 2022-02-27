$(document).ready(function() {
    //on ready
});

async function registrarAgente(){
    let datos = {};
    datos.nombre_agente = document.getElementById('txtNombre').value;
    datos.primer_apellido = document.getElementById('txtApellido').value;
    datos.correo_electronico = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtNuevaPassword').value;
    let repetirPassword = document.getElementById('txtRepetirPassword').value;



    if(datos.nombre_agente == ""||datos.primer_apellido ==""||datos.correo_electronico==""||datos.password==""||datos.repetirPassword==""){
        alert('!TODOS LOS CAMPOS SON OBLIGATORIOS¡');
        return;
    }
    if(repetirPassword != datos.password){
        alert('El password escrito es diferente');
        return;
    }

  const peticion = await fetch('api/agente', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  alert('Cuenta creada Exitosamente');
  window.location.href = 'index.html'
  //location.reload();
  //const usuarios = await peticion.json();
}