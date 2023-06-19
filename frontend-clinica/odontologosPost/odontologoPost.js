window.addEventListener('load', function () {

    //Al cargar la pagina buscamos y obtenemos el formulario donde estarán
    //los datos que el usuario cargará del nuevo odontologo
    const formulario = document.querySelector('.registrarForm');

    //Ante un submit del formulario se ejecutará la siguiente funcion
    formulario.addEventListener('submit', function (event) {
        event.preventDefault()

       //creamos un JSON que tendrá los datos del nuevo odontologo
        const formData = {
            nombre: document.querySelector('.nombreInput').value,
            apellido: document.querySelector('.apellidoInput').value,
            matricula: document.querySelector('.matriculaInput').value,

        };
        //invocamos utilizando la función fetch la API odontologos con el método POST que guardará
        //el odontologo que enviaremos en formato JSON
        const url = '/odontologos/registrar';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                 //Si no hay ningun error se muestra un mensaje diciendo que el odontologo
                 //se agrego bien
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> Odontólogo registrado </div>'

                 document.querySelector('.container').innerHTML = successAlert;
                 document.querySelector('.container').style.display = "block";
                 resetUploadForm();

            })
            .catch(error => {
                    //Si hay algun error se muestra un mensaje diciendo que el odontologo
                    //no se pudo guardar y se intente nuevamente
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error intente nuevamente</strong> </div>'

                      document.querySelector('.container').innerHTML = errorAlert;
                      document.querySelector('.container').style.display = "block";
                     //se dejan todos los campos vacíos por si se quiere ingresar otro odontologo
                     resetUploadForm();})
    });


    function resetUploadForm(){
        document.querySelector('.nombreInput').value = "";
        document.querySelector('.apellidoInput').value = "";
         document.querySelector('.matriculaInput').value = "";

    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/odontologoList.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});