window.addEventListener('load', function () {

    //*VARIABLES Y CONSTANTES 
    const section = document.querySelector("section")
    const url = "http://localhost:8080/dentist";
    const backButton = document.querySelector(".back");

    //*FETCH A LA API ----------------
    const settings = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    }

    fetch(url, settings)
        .then(response => response.json())
        .then(data => data.map(
            elem => {
                section.innerHTML += `<div class="cartas">
                     <p>Nombre: ${elem.nombre}</p>
                     <p>Apellido: ${elem.apellido}</p>
                     <p>Matrícula: ${elem.matricula}</p>
                     <button class="actualizarBtn"> Actualizar </button>
                 </div>`
            })
        )
        .catch(err => console.log(err))


    //*BOTÓN PARA REGRESAR A LA PÁGINA ANTERIOR -------------
    backButton.addEventListener("click", function () {
        location.replace("odontologoPost.html")
    })
})

