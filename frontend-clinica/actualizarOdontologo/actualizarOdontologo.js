window.addEventListener('load', function () {

    //const url = "";
    const formActualizar = document.querySelector(".formActualizar")
    const idInput = document.querySelector(".idInput")
    const nombreInput = document.querySelector(".nombreInput")
    const apellidoInput = document.querySelector(".apellidoInput")
    const matriculaInput = document.querySelector(".matriculaInput")
    const actualizarBtn = document.querySelector(".actualizar")

    //*FETCH A LA API ----------------

    idInput.addEventListener("submit", function (event) {
        event.preventDefault()

        const payload = {
            id: idInput.value.trim()
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
            .then(data => (formActualizar.innerHTML = `<form action="submit" class="form">
                <div class="title">
                    <h2>Modificá los datos necesarios</h2>
                </div>
    
                <label for="name" class="form__label">Id:</label>
                <input type="text" class="nombreInput" name="texto" value="${data.id}" id="name" required>
    
                <label for="name" class="form__label">Nombre:</label>
                <input type="text" class="nombreInput" name="texto" id="name" value="${data.nombre}" required>
    
                <label for="apellido" class="form__label">Apellido:</label>
                <input type="text" class="apellidoInput" name="apellido" id="apellido" value="${data.apellido}" required>
    
                <label class="form__label" for="matricula">Matrícula:</label>
                <input type="number" class="matriculaInput" id="matricula" value="${data.matricula}" required>
    
                <button type="submit" class="actualizar">Actualizar</button>
    
            </form>`
            ))
            .catch(err => console.log(err))

    })


    actualizarBtn.addEventListener("submit", function (event) {
        event.preventDefault()

        const payload = {
            nombre: nombreInput.value.trim(),
            apellido: apellidoInput.value.trim(),
            matricula: matriculaInput.value.trim(),
        }

        const settings = {
            method: 'PUT',
            body: JSON.stringify(payload),
            headers: {
                'Content-Type': 'application/json',
            },
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                formActualizar.innerHTML += `<p class="exitoMensaje">La información se actualizó correctamente</p>`
                resetUploadForm()
            })
            .catch(err => {
                formActualizar.innerHTML += `<p class="errorMensaje">Error al actualizar la información</p>`
                resetUploadForm()
            })
    })

    function resetUploadForm() {
        idInput.value = "";
        nombreInput.value = "";
        apellidoInput.value = "";
        matriculaInput.value = "";
    }


})