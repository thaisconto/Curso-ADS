function changeColor() {
    var colors = ["red", "blue", "green", "yellow", "purple"];
    var randomIndex = Math.floor(Math.random() * colors.length);
    var randomColor = colors[randomIndex];
    document.getElementById("div").style.backgroundColor = randomColor;
}

