const mysql = require("mysql");
const dbcconfig = require("../mongodbtest/database - config");
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

function select(query)
{
    con.query(query,function(err,result){
        if(err) throw err;
        return result;
    });
}

module.exports = {

    con,
    select : select
}