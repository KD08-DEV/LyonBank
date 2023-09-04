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

//eye icon
const eyeIcon = document.getElementById('eyeIcon');

const eyeIconConfirm = document.getElementById('eyeIconConfirm');



function showPassword() {
    var x = document.getElementById("txtPassword");
    if (x.type === "password") {
        x.type = "text";
        eyeIcon.classList.remove('fe-eye');
        eyeIcon.classList.add('fe-eye-off');
    } else {
        x.type = "password";
        eyeIcon.classList.remove('fe-eye-off');
        eyeIcon.classList.add('fe-eye');
    }
}

function showConfirmPassword() {
    var x = document.getElementById("confirmPassword");
    if (x.type === "password") {
        x.type = "text";
        eyeIconConfirm.classList.remove('fe-eye');
        eyeIconConfirm.classList.add('fe-eye-off');
    } else {
        x.type = "password";
        eyeIconConfirm.classList.remove('fe-eye-off');
        eyeIconConfirm.classList.add('fe-eye');
    }
}

