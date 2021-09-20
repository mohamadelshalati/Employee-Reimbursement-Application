authFunction()
getList();
document.getElementById('log-btn').addEventListener('click', logout);

function logout(){
    localStorage.removeItem("id");
}

function authFunction(){
    if (localStorage.getItem("id") === "1"){
        console.log("authorized")
    }else{
        location.replace("http://localhost:8080/ProjectI/login.html")
    }
}

async function getList(){
    let response= await fetch('ListServlet', {
    method: 'GET',
    mode: 'cors'
    });
    let list = await response.json();
    console.log(list);

    let a = '';
        for (let i = 0; i < list.length; i++){
            let date = new Date (list[i].submitTime);
            let shortDate = date.toLocaleDateString();
            let date1 = new Date (list[i].resolveTime);
            let shortDate1 = date1.toLocaleDateString();
            let status; 
            if (list[i].status == "APPROVED" || list[i].status == "DENIED"){
                status = "RESOLVED"
            }
            else{
                status = `<a style= "color:green; padding-left:10%"  href="ManagerServlet?id=${list[i].ticketId}&approve=true"><i class="fas fa-check"></i></a>&nbsp;&nbsp;&nbsp<a style= color:red; href="ManagerServlet?id=${list[i].ticketId}&approve=false"><i class="fas fa-times"></i></a>`
            }

            
        a +=`<tr>
                <th scope="row">${i + 1}</th>
                <td>${list[i].ticketId}</td>
                <td>${list[i].employeeName}</td>
                <td> $${list[i].reimbAmount}</td>
                <td>${list[i].type}</td>
                <td>${list[i].ticketDesc}</td>
                <td>${list[i].status}</td>
                <td>${shortDate}</td>
                <td>${list[i].resolveTime == null ? 'Not resloved yet' : shortDate1}</td>
                <td>${list[i].managerName == null ? 'Not resloved yet' : list[i].managerName}</td> 
                <td>${status}</td>
            </tr>`
        }

    document.getElementById('list').innerHTML = a;
}

isManager = getCookie('isManager');
function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
  }
if (isManager === "true"){
    document.getElementById('manager-nav').hidden = false;
} 
else{
    document.getElementById('manager-nav').hidden = true;
}

resolved = getCookie('resolved');
function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
}



document.getElementById('filter-select').addEventListener('change', filter);

async function filter(){
    let response= await fetch('ListServlet', {
        method: 'GET',
        mode: 'cors'
        });
        let list = await response.json();


    let selection = document.getElementById('filter-select').value;
    let a = '';
    if(selection == 1){
        let n = 0;
        for(let i = 0; i < list.length; i++){
                if (list[i].status == "PENDING"){
                    for (let j = 0; j < 1 ; j++){
                        let date = new Date (list[i].submitTime);
                        let shortDate = date.toLocaleDateString();
                        let date1 = new Date (list[i].resolveTime);
                        let shortDate1 = date1.toLocaleDateString();
                        let status; 
                        if (list[i].status == "APPROVED" || list[i].status == "DENIED"){
                            status = "RESOLVED"
                        }
                        else{
                            status = `<a style= "color:green; padding-left:10%"  href="ManagerServlet?id=${list[j].ticketId}&approve=true"><i class="fas fa-check"></i></a>&nbsp;&nbsp;&nbsp<a style= color:red; href="ManagerServlet?id=${list[j].ticketId}&approve=false"><i class="fas fa-times"></i></a>`
                        }  
                    a +=`<tr>
                        <th scope="row">${n += 1}</th>
                        <td>${list[i].ticketId}</td>
                        <td>${list[i].employeeName}</td>
                        <td> $${list[i].reimbAmount}</td>
                        <td>${list[i].type}</td>
                        <td>${list[i].ticketDesc}</td>
                        <td>${list[i].status}</td>
                        <td>${shortDate}</td>
                        <td>${list[i].resolveTime == null ? 'Not resloved yet' : shortDate1}</td>
                         <td>${list[i].managerName == null ? 'Not resloved yet' : list[i].managerName}</td> 
                        <td>${status}</td>
                    </tr>`
                }
                    
            }
        }
    }
    else if (selection == 2){
        let n = 0;
        for(let i = 0; i < list.length; i++){
            if (list[i].status == "APPROVED"){
                for (let j = 0; j < 1 ; j++){
                    let date = new Date (list[i].submitTime);
                    let shortDate = date.toLocaleDateString();
                    let date1 = new Date (list[i].resolveTime);
                    let shortDate1 = date1.toLocaleDateString();
                    let status; 
                    if (list[i].status == "APPROVED" || list[i].status == "DENIED"){
                        status = "RESOLVED"
                    }
                    else{
                        status = `<a style= "color:green; padding-left:10%"  href="ManagerServlet?id=${list[j].ticketId}&approve=true"><i class="fas fa-check"></i></a>&nbsp;&nbsp;&nbsp<a style= color:red; href="ManagerServlet?id=${list[j].ticketId}&approve=false"><i class="fas fa-times"></i></a>`
                    }
        
                    
                a +=`<tr>
                        <th scope="row">${n += 1}</th>
                        <td>${list[i].ticketId}</td>
                        <td>${list[i].employeeName}</td>
                        <td> $${list[i].reimbAmount}</td>
                        <td>${list[i].type}</td>
                        <td>${list[i].ticketDesc}</td>
                        <td>${list[i].status}</td>
                        <td>${shortDate}</td>
                        <td>${list[i].resolveTime == null ? 'Not resloved yet' : shortDate1}</td>
                        <td>${list[i].managerName == null ? 'Not resloved yet' : list[i].managerName}</td> 
                        <td>${status}</td>
                    </tr>`
                }
                
            }
        }
    }
    else if (selection == 3){
        let n = 0;
        for(let i = 0; i < list.length; i++){
            if (list[i].status == "DENIED"){
                for (let j = 0; j < 1 ; j++){
                    let date = new Date (list[i].submitTime);
                    let shortDate = date.toLocaleDateString();
                    let date1 = new Date (list[i].resolveTime);
                    let shortDate1 = date1.toLocaleDateString();
                    let status; 
                    if (list[i].status == "APPROVED" || list[i].status == "DENIED"){
                        status = "RESOLVED"
                    }
                    else{
                        status = `<a style= "color:green; padding-left:10%"  href="ManagerServlet?id=${list[j].ticketId}&approve=true"><i class="fas fa-check"></i></a>&nbsp;&nbsp;&nbsp<a style= color:red; href="ManagerServlet?id=${list[j].ticketId}&approve=false"><i class="fas fa-times"></i></a>`
                    }
        
                    
                a +=`<tr>
                        <th scope="row">${n += 1}</th>
                        <td>${list[i].ticketId}</td>
                        <td>${list[i].employeeName}</td>
                        <td> $${list[i].reimbAmount}</td>
                        <td>${list[i].type}</td>
                        <td>${list[i].ticketDesc}</td>
                        <td>${list[i].status}</td>
                        <td>${shortDate}</td>
                        <td>${list[i].resolveTime == null ? 'Not resloved yet' : shortDate1}</td>
                        <td>${list[i].managerName == null ? 'Not resloved yet' : list[i].managerName}</td> 
                        <td>${status}</td>
                    </tr>`
                }
            }
        }
    }
    else{
        for (let i = 0; i < list.length; i++){
            let date = new Date (list[i].submitTime);
            let shortDate = date.toLocaleDateString();
            let date1 = new Date (list[i].resolveTime);
            let shortDate1 = date1.toLocaleDateString();
            let status; 
            if (list[i].status == "APPROVED" || list[i].status == "DENIED"){
                status = "RESOLVED"
            }
            else{
                status = `<a style= "color:green; padding-left:10%"  href="ManagerServlet?id=${list[i].ticketId}&approve=true"><i class="fas fa-check"></i></a>&nbsp;&nbsp;&nbsp<a style= color:red; href="ManagerServlet?id=${list[i].ticketId}&approve=false"><i class="fas fa-times"></i></a>`
            }

            
        a +=`<tr>
                <th scope="row">${i + 1}</th>
                <td>${list[i].ticketId}</td>
                <td>${list[i].employeeName}</td>
                <td> $${list[i].reimbAmount}</td>
                <td>${list[i].type}</td>
                <td>${list[i].ticketDesc}</td>
                <td>${list[i].status}</td>
                <td>${shortDate}</td>
                <td>${list[i].resolveTime == null ? 'Not resloved yet' : shortDate1}</td>
                <td>${list[i].managerName == null ? 'Not resloved yet' : list[i].managerName}</td> 
                <td>${status}</td>
            </tr>`
        }
    }
    document.getElementById('list').innerHTML = a;
}

