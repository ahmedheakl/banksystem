
fetch("http://localhost:8081/customers").then(data => data.json()).then(data =>{
    let customers_table = document.getElementById("customers-table")
    for(let i = 0; i < data.length; i++){
        let customer = data[i];
        let new_tr_element = document.createElement("tr");
        let id_td = document.createElement("td");
        let name_td = document.createElement("td");
        let email_td = document.createElement("td");
        let currentBalance_td = document.createElement("td");
        let lastTrans_td = document.createElement("td")

        id_td.innerHTML = customer['id'];
        name_td.innerHTML = customer['name'];
        email_td.innerHTML = customer['email'];
        lastTrans_td.innerHTML = '10/16/2022'
        currentBalance_td.innerHTML = customer['currentBalance'] + '$';
        
        new_tr_element.append(id_td);
        new_tr_element.append(name_td);
        new_tr_element.append(email_td);
        new_tr_element.append(lastTrans_td)
        new_tr_element.append(currentBalance_td);
        new_tr_element.classList.add("secondary-thead")
        customers_table.append(new_tr_element);
    }

    

    document.querySelectorAll(".secondary-thead").forEach((element, xx) =>{
        element.addEventListener("click", (e)=>{
            let id = element.children[0];
            
        })
    })
    
});

