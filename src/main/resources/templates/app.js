const apiUrl = 'http://localhost:8080/api';

function tampilkanSemuaKotak() {
    fetch(`${apiUrl}/boxes/all`)
        .then(response => response.json())
        .then(boxes => {
            const html = boxes.map(box =>
                `<div>
                    <h3>${box.name}</h3>
                    <p>${box.description}</p>
                    <button onclick="tampilkanDetailKotak(${box.id})">Detail</button>
                    <button onclick="tampilkanFormUbahKotak(${box.id})">Ubah</button>
                    <button onclick="hapusKotak(${box.id})">Hapus</button>
                 </div>`).join("");
            document.getElementById('content').innerHTML = html;
        });
}

function tampilkanSemuaItem() {
    fetch(`${apiUrl}/items/all`)
        .then(response => response.json())
        .then(items => {
            const html = items.map(item =>
                `<div>
                    <h3>${item.name}</h3>
                    <p>${item.description}</p>
                    <button onclick="tampilkanDetailItem(${item.id})">Detail</button>
                    <button onclick="tampilkanFormUbahItem(${item.id})">Ubah</button>
                    <button onclick="hapusItem(${item.id})">Hapus</button>
                 </div>`).join("");
            document.getElementById('content').innerHTML = html;
        });
}

function tampilkanDetailKotak(id) {
    fetch(`${apiUrl}/boxes/${id}`)
        .then(response => response.json())
        .then(box => {
            const itemsHtml = box.items.map(item => `<li>${item.name}: ${item.description}</li>`).join("");
            const html = `<h2>${box.name}</h2>
                          <p>${box.description}</p>
                          <h4>Items:</h4>
                          <ul>${itemsHtml}</ul>`;
            document.getElementById('content').innerHTML = html;
        });
}

function tampilkanDetailItem(id) {
    fetch(`${apiUrl}/items/${id}`)
        .then(response => response.json())
        .then(item => {
            const html = `<h2>${item.name}</h2>
                          <p>${item.description}</p>`;
            document.getElementById('content').innerHTML = html;
        });
}

function tampilkanFormBuatKotak() {
    document.getElementById('content').innerHTML = `
        <h2>Buat Kotak</h2>
        <form onsubmit="buatKotak(); return false;">
            <input type="text" id="name" placeholder="Nama Kotak"><br>
            <input type="text" id="description" placeholder="Deskripsi"><br>
            <input type="text" id="price" placeholder="Harga"><br>
            <button type="submit">Buat</button>
        </form>`;
}

function tampilkanFormBuatItem() {
    document.getElementById('content').innerHTML = `
        <h2>Buat Item</h2>
        <form onsubmit="buatItem(); return false;">
            <input type="text" id="name" placeholder="Nama Item"><br>
            <input type="text" id="description" placeholder="Deskripsi"><br>
            <button type="submit">Buat</button>
        </form>`;
}

function buatKotak() {
    const kotak = {
        name: document.getElementById('name').value,
        description: document.getElementById('description').value,
        price: parseFloat(document.getElementById('price').value),
        items: []
    };
    fetch(`${apiUrl}/boxes/create`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(kotak)
    }).then(() => tampilkanSemuaKotak());
}

function buatItem() {
    const item = {
        name: document.getElementById('name').value,
        description: document.getElementById('description').value
    };
    fetch(`${apiUrl}/items/create`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(item)
    }).then(() => tampilkanSemuaItem());
}

function hapusKotak(id) {
    fetch(`${apiUrl}/boxes/${id}`, {
        method: 'DELETE'
    }).then(() => tampilkanSemuaKotak());
}

function hapusItem(id) {
    fetch(`${apiUrl}/items/${id}/delete`, {
        method: 'DELETE'
    }).then(() => tampilkanSemuaItem());
}

function tampilkanFormUbahKotak(id) {
    fetch(`${apiUrl}/boxes/${id}`)
        .then(response => response.json())
        .then(box => {
            document.getElementById('content').innerHTML = `
                <h2>Ubah Kotak</h2>
                <form onsubmit="ubahKotak(${id}); return false;">
                    <input type="text" id="name" value="${box.name}"><br>
                    <input type="text" id="description" value="${box.description}"><br>
                    <input type="text" id="price" value="${box.price}"><br>
                    <button type="submit">Ubah</button>
                </form>`;
        });
}

function tampilkanFormUbahItem(id) {
    fetch(`${apiUrl}/items/${id}`)
        .then(response => response.json())
        .then(item => {
            document.getElementById('content').innerHTML = `
                <h2>Ubah Item</h2>
                <form onsubmit="ubahItem(${id}); return false;">
                    <input type="text" id="name" value="${item.name}"><br>
                    <input type="text" id="description" value="${item.description}"><br>
                    <button type="submit">Ubah</button>
                </form>`;
        });
}

function ubahKotak(id) {
    const kotak = {
        name: document.getElementById('name').value,
        description: document.getElementById('description').value,
        price: parseFloat(document.getElementById('price').value)
    };
    fetch(`${apiUrl}/boxes/${id}`, {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(kotak)
    }).then(() => tampilkanSemuaKotak());
}

function ubahItem(id) {
    const item = {
        name: document.getElementById('name').value,
        description: document.getElementById('description').value
    };
    fetch(`${apiUrl}/items/${id}`, {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(item)
    }).then(() => tampilkanSemuaItem());
}
