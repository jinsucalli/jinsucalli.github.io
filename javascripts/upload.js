var express = require("express");
var app = express()
var fs = require('fs');

app.configure(function () {
    app.use(express.bodyParser());
});

app.post('/upload', function(req, res) {
    fs.readFile(req.files.file.path, function (err, data) {
        var fileName = req.files.file.name

        if(!fileName){
            res.end();
        } else {
            var Path = __dirname + "/" + fileName;

            fs.writeFile(Path, data, function (err) {
                res.writeHead(200, {'Content-Type': 'text/html' });
                res.end('Upload success');
            });
        }
    });
});

app.listen(8080, function () {
    console.log("Server Start!");   
})
