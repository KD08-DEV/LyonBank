$(document).ready(function() {
 //on ready
});


async function registerUsers() {
    let data= {};
    //data.name = ..;
    //    data.lastName = document.getElementById('txtEmail').value;
  //  data.phone = document.getElementById('txtEmail').value;
    data.email = document.getElementById('txtEmail').value;
    data.password = document.getElementById('txtPassword').value;

    //let repeatPassword =  document.getElementById('txtRepetirPassword').value;

   /* if(repeatPassword != data.password){
        alert('The password doesnt match')
        return;
    }*/

    const request = await fetch('api/users', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    const users = await request.json();

}