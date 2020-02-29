const express = require('express');
const mysql = require('mysql');


const db = mysql.createConnection({

    host : 'localhost',
    user : 'root',
    password : '' ,
    database : 'travelapp'

});

db.connect((err) => {
    if (err){
        console.log('Error, Failure to connect');
    }
        console.log('MySQL Connected');
});


const app = express();

app.get('/destinations', (req, res) => {

    let sql = 'SELECT * FROM destinations';
    db.query(sql, (err, result) => {
        if (err) throw err;
        res.send(result);

    });

});

app.get('/destinations/:id', (req, res) => {
// Get specific dest_ID from the database
    let sql = `SELECT * FROM destinations WHERE dest_id = ${req.params.id}`;
    db.query(sql, (err, result) => {
        if (err) console.log('Please enter the correct id');
        res.send(result);

    });

});
app.get('/Search/:keyword1/:keyword2/:keyword3', (req, res) => {
// Search for the keywords where keyword 1 or 2 or 3 = parameter 1, 2 and 3
    let sql = `SELECT * FROM Countries WHERE Keyword1 ="${req.params.keyword1}" OR Keyword2 = "${req.params.keyword1}" OR Keyword3 = "${req.params.keyword1}" AND  Keyword1 = "${req.params.keyword2}" OR Keyword2 = "${req.params.keyword2}" OR Keyword3 = "${req.params.keyword2}" AND Keyword1 = "${req.params.keyword3}" OR Keyword2 = "${req.params.keyword3}" OR Keyword3 = "${req.params.keyword3}" `;
    db.query(sql, (err, result) => {
        if (err) throw err;
        res.send(result);

    });

});

app.get('/Search/:keyword1/:keyword2', (req, res) => {
   // Two keywords search
    let sql = `SELECT * FROM Countries WHERE Keyword1 ="${req.params.keyword1}" OR Keyword2 = "${req.params.keyword1}" OR Keyword3 = "${req.params.keyword1}" AND Keyword1 = "${req.params.keyword2}" OR Keyword2 = "${req.params.keyword2}" OR Keyword3 = "${req.params.keyword2}" `;
    db.query(sql, (err, result) => {
        if (err) throw err;
        res.send(result);

    });

});
app.get('/Search/:keyword1', (req, res) => {
    // One keyword search
     let sql = `SELECT * FROM Countries WHERE Keyword1 ="${req.params.keyword1}" OR Keyword2 = "${req.params.keyword1}" OR Keyword3 = "${req.params.keyword1}" `;
     db.query(sql, (err, result) => {
         if (err) throw err;
         res.send(result);

     });

 });
 app.get('/Weather/:country1', (req, res) => {
    // Search for a specific country's weather
     let sql = `SELECT weather FROM Countries WHERE Country = "${req.params.country}" `;
     db.query(sql, (err, result) => {
         if (err) throw err;
         res.send(result);

     });

 });

 app.get('/Summary/:country1', (req, res) => {
    // Search for a specific country summary
     let sql = `SELECT Summary FROM Countries WHERE Country = "${req.params.country1}" `;
     db.query(sql, (err, result) => {
         if (err) throw err;
         res.send(result);

     });

 });
 app.get('/Attractions/:country1', (req, res) => {
    // Search for attractions for a specific country
     let sql = `SELECT Attractions FROM Countries WHERE Country = "${req.params.country1}" `;
     db.query(sql, (err, result) => {
         if (err) throw err;
         res.send(result);

     });

 });





const port = process.env.PORT || 3000;
app.listen(port, () => {

console.log(`Server started on port ${port}`);
});

