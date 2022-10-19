let form = document.getElementById('transaction-form');

form.addEventListener('submit', (e)=>{
    const senderName = form.children[0].children[0].children[0].value;
    const receiverName = form.children[0].children[1].children[0].value;
    const amount = form.children[0].children[2].children[0].value;
    let newData = JSON.stringify({
        'senderName': senderName,
        'receiverName': receiverName,
        'amount': amount
    })
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
        "amount": amount,
        "senderName": senderName,
        "receiverName": receiverName
    });

    var requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
    };

    fetch("http://localhost:8081/transactions", requestOptions)
    .then(response => response.text())
    .then(result => console.log(result))
    .catch(error => console.log('error', error));

})