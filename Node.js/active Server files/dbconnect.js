const mysql = require("mysql");
const dbcconfig = require("../mongodbtest/dbconfig");
const express = require("express");

const con = mysql.createConnection({

    host : dbcconfig.HOST,
    user : dbcconfig.USER,
    password : dbcconfig.password,
    database : dbcconfig.DB
});

con.connect((err) => {
    if (err){
        console.log('Error, Failure to connect');
    }
        console.log('MySQL successfully Connected');
});



module.exports = {

    con,

}