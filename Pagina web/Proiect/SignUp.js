window.addEventListener("DOMContentLoaded", (event) => {
  document
    .getElementById("file-upload")
    .addEventListener("change", function (e) {
      if (e.target.files[0]) {
        console.log(document.getElementById("path").innerHTML);
        document
          .getElementById("path")
          .setAttribute("src", e.target.files[0].name);
      }
    });
});

function register() {
  let error = false;
  document.getElementById("nerror").innerHTML = "";
  document.getElementById("eerror").innerHTML = "";
  document.getElementById("uerror").innerHTML = "";
  document.getElementById("perror").innerHTML = "";
  document.getElementById("rperror").innerHTML = "";
  const email = document.getElementById("email").value;
  const password = document.querySelector('[type="password"]').value;
  const password2 = document.querySelectorAll('[type="password"]')[1].value;
  const username = document.getElementById("username").value;
  const name = document.getElementById("name").value;

  console.log(email, password, password2);
  

  if (!name) {
    document.getElementById("nerror").innerHTML = "Name is Required!";
    error = true;
  }

  else if(!name.trim()){ 
    document.getElementById("nerror").innerHTML = "Nume invalid"; 
    error = true
  }

  if (!email) {
    document.getElementById("eerror").innerHTML = "Email is Required!";
    error = true;
  } else if (!email.includes("@")) {
    document.getElementById("eerror").innerHTML = "Email Invalid!";
    error = true;
  }

  else if(!email.trim()){ 
    document.getElementById("eerror").innerHTML = "Email Invalid!"; 
    error = true
  }

  if (!username) {
    document.getElementById("uerror").innerHTML = "Username is Required!";
    error = true;
  }
  
  else if(!username.trim()){ 
    document.getElementById("uerror").innerHTML = "Username Invalid!"; 
    error = true
  }

  if (!password) {
    document.getElementById("perror").innerHTML = "Password is Required!";
    error = true;
  }
  else if(!password.trim()){ 
    document.getElementById("perror").innerHTML = "Password Invalid!"; 
    error = true
  }

  if (!password2) {
    document.getElementById("rperror").innerHTML =
      "Password repetition is Required!";
    error = true;
  }
  if (!(password == password2)) {
    if (!password2) document.getElementById("rperror").innerHTML += "<br/>"
    document.getElementById("rperror").innerHTML += "Passwords must be identical!";
    error = true;
  }

 
  if (error) return;

  sessionStorage.setItem(email, `${password};${name};${username}`);
  alert("Te-ai inregistrat cu succes!");
  window.location.href = "/LogIn.html";
}
