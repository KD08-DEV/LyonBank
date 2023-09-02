$(document).ready(function() {
    //on ready
});
/**
 * @param {Event} event
 */
async function signIn(event) {
    event.preventDefault();
    let data= {};
    data.email = document.getElementById('txtEmail').value;
    data.password = document.getElementById('txtPassword').value;

    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    const response = await request.text();
    if (response != 'FAIL'){
        localStorage.token = response;
        localStorage.email = data.email;
        window.location.href= 'index.html';
        console.log(response);
    }else {
        alert("Try again please, password or email wrong");
    }

}

//show password logic

const password = document.getElementById('show-password');
password.addEventListener('click', showPassword);

function showPassword() {
    var x = document.getElementById("txtPassword");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}
