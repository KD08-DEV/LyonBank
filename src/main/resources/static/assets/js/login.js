$(document).ready(function() {
    //on ready
});
async function signIn() {
    let data= {};
    data.email = document.getElementById('txtEmail').value;
    data.password = document.getElementById('txtPassword').value;
    console.log(data.password, data.email);

    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    const response = await request.json();
    console.log(response)
    if (response !== 'FAIL'){
        localStorage.token = response;
        localStorage.email = data.email;
        console.log(response);
    }else {
        alert("ERROR");
    }

}