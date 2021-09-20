authFunction();
getCookie();
document.getElementById('log-btn').addEventListener('click', function logout(){
    localStorage.removeItem("id");
})

function authFunction(){
    if (localStorage.getItem("id") === "1"){
        console.log("authorized")
    }else{
        location.replace("http://localhost:8080/ProjectI/login.html")
    }
}

async function submitForm(){
    let form = [];
    let amount = document.getElementById('amount').value;
    let type = document.getElementById('r-type').value;
    let description = document.getElementById('description').value;

    form.push(amount);
    form.push(type);
    form.push(description);
    console.log (form[0], form[1], form[2])

    let response = await fetch('FormServlet',{
        method: 'POST',
        mode: 'cors',
        headers: {
            'content-type': 'application/json'
        },
        body: JSON.stringify(form)
    });
    console.log (response);
    if (response.redirected){
        window.location.href = response.url;   
    }
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
