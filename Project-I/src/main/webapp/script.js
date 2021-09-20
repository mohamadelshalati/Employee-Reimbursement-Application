
async function login(){
    document.getElementById('login-btn').disabled = true;

    let username = document.getElementById('username').value;
    let psw = document.getElementById('psw').value;
    let credentials = []
    credentials.push(username);
    credentials.push(psw);

    let response = await fetch('LoginServlet',{
        method: 'POST',
        mode: 'cors',
        headers: {
            'content-type': 'application/json'
        },
        body: JSON.stringify(credentials)
    });


    if (response.redirected){
        localStorage.setItem("id", "1")
        window.location.href = response.url;   
    }
    else{
        console.log('else')
        wrongC();
        //window.location.href = "http://localhost:8080/ProjectI";
        document.getElementById('login-btn').disabled = false;
    }
}
console.log(localStorage.getItem("id"));

function wrongC(){
    document.getElementById('wrong').innerHTML = "Wrong email or password!";
    setTimeout(function(){
    document.getElementById("wrong").innerHTML=""}, 3000);
}