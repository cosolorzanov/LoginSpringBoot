function checkPass() {
    var pass = document.getElementById("password").value;
    var confpass = document.getElementById("confirmPassword").value;

    if(pass!==confpass){
        document.getElementById("submit").disabled=true;
        document.getElementById("errorConfirmPassword").innerText= "la contraseña no coincide";
    }
    else {
        document.getElementById("submit").disabled=false;
        document.getElementById("errorConfirmPassword").innerText= "";
    }
}