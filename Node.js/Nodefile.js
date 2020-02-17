var express = require('express');
var mysql = require('mysql');
var bodyParser = require('body-parser');

var con = mysql.createConnection({
host:'0.0.0.0',
user:'root',
database:'travelapp'
});
var app=express();

var publicDir=(__dirname+'/public/');

app.use(express.static(publicDir));

app.use(bodyParser.json());

app.use(bodyParser.urlencoded({extended:true}));

app.get("/destinations",(req,res,next)=> {

con.query('SELECT* FROM destinations',function(error,result,fields){

con.on('error',function(err){

console.log('[MYSQL]ERROR',err);

});

if(result && result.length)

{

res.end(JSON.stringify(result));

}

else

{

res.end(JSON.stringify('No data'));

}

});

});
const port = process.env.PORT || 3000;
app.listen(port,()=>{

console.log(`Database is running on port ${port}...`);
})
