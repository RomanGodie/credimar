$(document).ready(function() {
    //on ready
});

async function registrarCliente(){
    let datos = {};
    datos.numero_identificacion = document.getElementById('txtIdentificacion').value;
    datos.nombres = document.getElementById('txtNombres').value;
    datos.primer_apellido = document.getElementById('txtPrimerApellido').value;
    datos.segundo_apellido = document.getElementById('txtSegundoApellido').value;
    datos.correo_electronico = document.getElementById('txtEmail').value;
    datos.direccion_residencia = document.getElementById('txtDireccionResidencia').value;
    datos.telefono1 = document.getElementById('txtTelefono1').value;
    datos.telefono2 = document.getElementById('txtTelefono2').value;



    if(datos.numero_identificacion == ""||datos.nombres ==""||datos.primer_apellido ==""||datos.direccion_residencia==""||datos.telefono1==""){
        alert('!LOS CAMPOS CON ASTERISCO SON OBLIGATORIOS¡');
        return;
    }

  const peticion = await fetch('api/persona', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  alert('Cliente creado exitosamente');
  //window.location.href = 'index.html'
  location.reload();
  //const usuarios = await peticion.json();
}