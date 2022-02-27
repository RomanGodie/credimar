$(document).ready(function() {
    //on ready
});

async function iniciarSesion(){
    let datos = {};
    datos.correo_electronico = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;


    if(datos.correo_electronico==""||datos.password==""){
        alert('!TODOS LOS CAMPOS SON OBLIGATORIOS¡');
        return;
    }


  const peticion = await fetch('api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  //location.reload();
  const respuesta = await peticion.text();

  if(respuesta !='FAIL'){
        localStorage.token = respuesta;
        localStorage.email = datos.correo_electronico;
        window.location.href = 'principal.html'
  }else{
        alert('Las credenciales son incorrectas.\nIntentalo de nuevo')
  }
}
