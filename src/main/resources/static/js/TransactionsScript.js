
fetch("http://localhost:8081/transactions").then(data => data.json()).then(data =>{
    let transactions_table = document.getElementById("customers-table")
    console.log(data)
    for(let i = 0; i < data.length; i++){
        let transaction = data[i];
        let new_tr_element = document.createElement("tr");
        let id_td = document.createElement("td");
        let from_td = document.createElement("td");
        let to_td = document.createElement("td");
        let time_td = document.createElement("td");
        let amount_td = document.createElement("td")

        id_td.innerHTML = transaction['id'];
        from_td.innerHTML = transaction['sender']['name'];
        to_td.innerHTML = transaction['receiver']['name'];
        time_td.innerHTML = new Intl.DateTimeFormat('en-US').format(new Date(transaction['timeStamp']))
        amount_td.innerHTML = transaction['amount'] + '$';
        
        new_tr_element.append(id_td);
        new_tr_element.append(from_td);
        new_tr_element.append(to_td);
        new_tr_element.append(time_td)
        new_tr_element.append(amount_td);
        new_tr_element.classList.add("secondary-thead")
        transactions_table.append(new_tr_element);
    }

    document.querySelectorAll(".secondary-thead").forEach((element, xx) =>{
        element.addEventListener("click", (e)=>{
            let id = element.children[0];
            
        })
    })
    
});

