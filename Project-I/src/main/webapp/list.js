authFunction();
getList();
getCookie();
document.getElementById('log-btn').addEventListener('click', logout);

async function getList(){
    let response= await fetch('MyListServlet', {
    method: 'GET',
    mode: 'cors'
    });
    let list = await response.json();
    console.log(list);

    var a = '';
        for (let i = 0; i < list.length; i++){
            let date = new Date (list[i].submitTime);
            let shortDate = date.toLocaleDateString(); 
            let date1 = new Date (list[i].resolveTime);
            let shortDate1 = date1.toLocaleDateString();
            
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

function authFunction(){
    if (localStorage.getItem("id") === "1"){
        console.log("authorized")
    }else{
        location.replace("http://localhost:8080/ProjectI/login.html")
    }
}

function logout(){
    localStorage.removeItem("id");
}



