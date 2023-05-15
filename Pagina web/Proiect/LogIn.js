var emailArray = [];
var passwordArray = [];

var loginBox = document.getElementById("login");
var regBox = document.getElementById("register");
var forgetBox = document.getElementById("forgot");

var loginTab = document.getElementById("lt");
var regTab = document.getElementById("rt");

function loginTabFun() {
  regBox.style.visibility = "hidden";
  loginBox.style.visibility = "visible";
  forgetBox.style.visibility = "hidden";

  loginTab.style.backgroundColor = "rgb(12, 132, 189)";
  regTab.style.backgroundColor = "rgba(11, 177, 224, 0.82)";
}

function forTabFun() {
  regBox.style.visibility = "hidden";
  loginBox.style.visibility = "hidden";
  forgetBox.style.visibility = "visible";

  regTab.style.backgroundColor = "rgba(11, 177, 224, 0.82)";
  loginTab.style.backgroundColor = "rgba(11, 177, 224, 0.82)";
}

function login() {
  var email = document.getElementById("se").value;
  var password = document.getElementById("sp").value;

  if (!email) {
    alert("Email required");
    return;
  }

  const user = sessionStorage.getItem(email);

  if (!user) {
    alert("No user with that email");
    return;
  }

  const usersplit = user.split(";");

  const userpassword = usersplit[0];
  const name = usersplit[1];
  const username = usersplit[2];

  console.log(password, userpassword);
  if (password != userpassword) {
    alert("Wrong password");
    return;
  }

  window.location.href = "/Home.html";
  sessionStorage.setItem("loggedin", true);
}


function forgot() {
  var email = document.getElementById("se").value;

  if (emailArray.indexOf(email) == -1) {
    if (email == "") {
      alert("Email required.");
      return;
    }
    alert("Email does not exist.");
    return;
  }

  alert("email is send to your email check it in 5min. \n Thanks");
  document.getElementById("fe").value = "";
}
