$(document).ready(function() {
 //on ready
});
async function registerUsers() {
    let data= {};
    data.name = document.getElementById('name').value;
    data.lastname = document.getElementById('lastname').value;
    data.phone = document.getElementById('phone').value;
    data.email = document.getElementById('txtEmail').value;
    data.password = document.getElementById('txtPassword').value;
    let confirmpassword  = document.getElementById('confirmPassword').value;

    if(confirmpassword != data.password){
        alert("The password you entered did not match");
        return;
    }

    const request = await fetch('api/users', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    alert("The account was created successfully!");
    window.location.href = 'login.html';
}

//show password logic

const password = document.getElementById('show-password');
password.addEventListener('click', showPassword);

const confirmPassword = document.getElementById('show-confirm');
confirmPassword.addEventListener('click', showConfirmPassword);


function showPassword() {
    var x = document.getElementById("txtPassword");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}

function showConfirmPassword() {
    var x = document.getElementById("confirmPassword");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}

