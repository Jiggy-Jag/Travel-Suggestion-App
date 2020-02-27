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
        console.log('Error');
    }
        console.log('MySQL Connected');
});


const app = express();

app.get('/destinations', (req, res) => {

    let sql = 'SELECT * FROM destinations';
    db.query(sql, (err, result) => {
        if (err) console.log('EERROR');
        res.send(result);

    });

});

app.get('/destinations/:id', (req, res) => {

    let sql = `SELECT * FROM destinations WHERE dest_id = ${req.params.id}`;
    db.query(sql, (err, result) => {
        if (err) console.log('EEROR');
        res.send(result);

    });

});


app.listen('3000', () => {

console.log('Server started on port 3000');
});