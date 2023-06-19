window.addEventListener('load', function () {

    //*VARIABLES Y CONSTANTES 
    const url = "http://localhost:8080/dentist";
    const section = document.querySelector("section")
    const backButton = document.querySelector(".back");
    const queryButton = document.querySelector(".queryBtn");
    const queryInput = document.querySelector("input");
    const updateBtn = document.querySelectorAll(".actualizarBtn")

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

    //*BOTÓN PARA ACTUALIZAR
    updateBtn.forEach(elem => elem.addEventListener("click", function () {
        location.replace("actualizarOdontologo.html")
    }))

    //*BOTÓN PARA BUSCAR
    queryButton.addEventListener("submit", function () {

        const payload = {
            matricula: queryInput.value.trim()
        }

        const settings = {
            method: 'GET',
            body: JSON.stringify(payload),
            headers: {
                'Content-Type': 'application/json',
            },
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => section.innerHTML += `<div class="cartas">
                         <p>Nombre: ${data.nombre}</p>
                         <p>Apellido: ${data.apellido}</p>
                         <p>Matrícula: ${data.matricula}</p>
                         <button class="actualizarBtn"> Actualizar </button>
                     </div>`
            )
            .catch(err => console.log(err))
    })

})

