window.addEventListener('load', function () {

    const url = "http://localhost:8080/dentist";
    const formActualizar = document.querySelector(".formActualizar")
    const idSearchForm = document.querySelector(".idSearchForm")
    const idInput = document.querySelector(".idInput")

    //*FETCH A LA API ----------------

    idSearchForm.addEventListener("submit", function (event) {
        event.preventDefault()

        const id = idInput.value.trim()

        if (id === "") {
            return idSearchForm.innerHTML += `<span class="errorMensaje">You have to select a number</span>`
        }

        const settings = {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        }

        fetch(`${url}/${id}`, settings)
            .then(response => response.json())
            .then(data => {
                formActualizar.innerHTML =
                    `<div class="title">
                    <h2>Modificá los datos necesarios</h2>
                </div>

                <form action="submit" class="formSubmit">

                    <label for="id" class="form__label">Id:</label>
                    <input type="text" class="idForm" name="id" value="${data.id}" placeholder="Ingrese el id" required>

                    <label for="nombre" class="form__label">Nombre:</label>
                    <input type="text" class="nombreInput" name="nombre" value="${data.nombre}" placeholder="Ingrese el nombre" required>

                    <label for="apellido" class="form__label">Apellido:</label>
                    <input type="text" class="apellidoInput" name="apellido" value="${data.apellido}" placeholder="Ingrese el apellido" required>

                    <label class="form__label" for="matricula">Matrícula:</label>
                    <input type="text" class="matriculaInput" name="matricula" value="${data.matricula}" placeholder="Ingrese la matrícula" required>

                    <button type="submit" class="actualizar">Actualizar</button>

                </form>`

                const actualizarForm = document.querySelector(".formSubmit")
                const nombreInput = document.querySelector(".nombreInput")
                const apellidoInput = document.querySelector(".apellidoInput")
                const matriculaInput = document.querySelector(".matriculaInput")
                const idForm = document.querySelector(".idForm")

                actualizarForm.addEventListener("submit", function (event) {
                    event.preventDefault()

                    const payload = {
                        id: idForm.value.trim(),
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

                    fetch(`${url}/update`, settings)
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
            .catch(err => console.log(err))

    })

})