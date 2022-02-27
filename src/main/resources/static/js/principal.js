// Call the dataTables jQuery plugin
$(document).ready(function() {

    actualizarEmailAgente();
    cargarCreditos();

  $('#creditos').DataTable();
});

let datosCreditoHtml = '';
var nombreCliente ='';

function actualizarEmailAgente(){
    document.getElementById('txt-email-agente').outerHTML = localStorage.email;
}

async function cargarCreditos(){

  const peticion = await fetch('api/creditos', {
    method: 'GET',
    headers: getHeaders()
  });
  const creditos = await peticion.json();


    let listadoHtml = '';

  for(let credito of creditos){
            consultarPersona(credito.id_cliente1);
            let variableNombre = nombreCliente;
            let botonConsultar = '<a href="#modalCredito" onclick="consultarCredito('+ credito.id_credito +')" class="btn btn-primary btn-sm" data-toggle="modal">CONSULTAR</a>';
            //let botonEliminar = '<a href="#" onclick="eliminarDeudor('+ deudor.id_deudor +')" class="btn btn-danger btn-sm">ELIMINAR</a>';
            let creditoHtml = '<tr><td>'+credito.id_credito
                             +'</td><td>'+variableNombre
                             +'</td><td>$'+credito.valor_credito
                             +'</td><td>'+ botonConsultar +'</td></tr>';
            listadoHtml += creditoHtml;
  }

  document.querySelector('#creditos tbody').outerHTML = listadoHtml;
}

async function consultarCredito(id){

datosCreditoHtml = '';

    const peticion1 = await fetch('api/credito/'+id, {
            method: 'GET',
            headers: getHeaders()
          });
      const creditoSelect = await peticion1.json();


      let creditoModalHtml = '<tr><td><b>No. Credito:</b> '+creditoSelect.id_credito+'</td>'+
                            '<td><b>Articulo:</b> '+creditoSelect.articulo_credito+'</td>'+
                            '<td><b>Valor Credito:</b> $'+creditoSelect.valor_credito+'</td>'+
                            '<td><b>No. Cuotas:</b> '+creditoSelect.numero_cuotas+'</td></tr>';

      datosCreditoHtml += creditoModalHtml;

      consultarCliente(creditoSelect.id_cliente1);
}

async function consultarCliente(id){

      const peticion2 = await fetch('api/cliente/'+id, {
              method: 'GET',
              headers: getHeaders()
            });
            const clienteCredito = await peticion2.json();

            let telefonoAlternoTexto = clienteCredito.telefono_alterno == null ? '-' : clienteCredito.telefono_alterno;

      consultarPersona(clienteCredito.id_persona1, telefonoAlternoTexto);
}

async function consultarPersona(id, telefonoAlternoTexto){

        const peticion3 = await fetch('api/persona/'+id, {
                       method: 'GET',
                       headers: getHeaders()
                    });
              const personaCliente = await peticion3.json();

                    let telefono2Texto = personaCliente.telefono2 == null ? '-' : personaCliente.telefono2;
                    let clienteModalHtml = '<tr><td><b>No. Identificacion:</b> '+personaCliente.numero_identificacion+'</td>'+
                                           '<td><b>Nombre:</b> '+personaCliente.nombres+' '+personaCliente.primer_apellido+' '+personaCliente.segundo_apellido+'</td>'+
                                           '<td><b>Email:</b> '+personaCliente.correo_electronico+'</td>'+
                                           '<td><b>Dir. Residencia:</b> '+personaCliente.direccion_residencia+'</td></tr>'+
                                           '<tr><td><b>Telefono 1:</b> '+personaCliente.telefono1+'</td>'+
                                           '<td><b>Telefono 2:</b> '+telefono2Texto+'</td>'+
                                           '<td><b>Telefono 3:</b> '+telefonoAlternoTexto+'</td></tr>';

                    datosCreditoHtml += clienteModalHtml;

                    document.querySelector('#creditoTableModal tbody').outerHTML = datosCreditoHtml;

}

async function consultarPersona(id){

    const peticion4 = await fetch('api/cliente/'+id, {
                      method: 'GET',
                      headers: getHeaders()
                      });
    const clienteCredito = await peticion4.json();

    const peticion5 = await fetch('api/persona/'+clienteCredito.id_persona1, {
                      method: 'GET',
                      headers: getHeaders()
                      });
    const personaCliente = await peticion5.json();

    nombreCliente = personaCliente.nombres+' '+personaCliente.primer_apellido;
}

async function eliminarDeudor(id){

        if(confirm('¿Esta Seguro de Proceder?')){

                  const peticion = await fetch('api/deudores/'+id, {
                  method: 'DELETE',
                  headers: getHeaders()
                });
                location.reload();

        }else{
            return;
        }
}

function registrarCliente(){
    alert('Creado Exitosamente');
}

function getHeaders(){

return{
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };

}