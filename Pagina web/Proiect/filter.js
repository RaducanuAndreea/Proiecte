function filter() {
    var input, ul, a, i;
    input = document.querySelector(".search-box > input");
    ul = document.querySelectorAll(".menu > ul > li");
    for (i = 0; i < ul.length; i++) {
      a = ul[i].querySelector("a > span");
      if (a.innerHTML.toUpperCase().indexOf(input.value.toUpperCase()) > -1) {
      ul[i].style.display = "";
      } else {
      ul[i].style.display = "none";
      }
    }
}