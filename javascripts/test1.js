var simon = document.getElementById("simon");

simon.addEventListener("click", picLink);

function picLink() {
  var PicId = this.attributes["data-img"].value;
  var pic = document.getElementById(PicId);
  console.log(this);
  if (pic.className === "hide") {
    pic.className = "";
  } else {
    pic.className = "hide";
  }
}
