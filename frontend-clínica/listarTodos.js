window.addEventListener('load', function () {

    const url = 'xxxxxxxxxxxxxx/dentist';

    const settings = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    }

    fetch(url, settings)
        .then(response => response.json())
        .then(data => data.map)
})