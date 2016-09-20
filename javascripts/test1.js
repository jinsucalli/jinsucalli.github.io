var simon = document.getElementById("simon");

simon.addEventListener("click", function(){

  console.log(this);
  
});

//picLink);

function picLink() {
  var PicId = this.attributes["data-img"].value;
  console.log(this);
}
