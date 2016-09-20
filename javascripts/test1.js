var simon = document.getElementById("simon");

simon.addEventListener("click", picLink);

function picLink() {
  var PicId = this.attributes["data-img"].value;
  console.log(this);
}
