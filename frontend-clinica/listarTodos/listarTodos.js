window.addEventListener('load', function () {

    const main = document.querySelector("main")
    const url = "http://localhost:8080/dentist";


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
                main.innerHTML += `<div class="cartas">
                    <p>${elem.nombre}</p>
                    <p>${elem.apellido}</p>
                    <p>${elem.matricula}</p>
                </div>`
            }
        ))
        .catch(err => console.log(err))
})