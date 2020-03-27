var crypto = require('crypto');
var uuid = require('uuid');
const express = require('express');
const mysql = require('mysql');
var bodyParser = require('body-parser');
const mysql1 = require('../mongodbtest/dbconnect');

// Create connection
var db = mysql1.con;





//PASSWORD ULTIL
var genRandomString = function(length){
    return crypto.randomBytes(Math.ceil(length/2))
    .toString('hex')/* CONVERT TO HEX */
    .slice(0, length);
};
var sha512 = function (password,salt){
    var hash = crypto.createHmac('sha512',salt);
    hash.update(password);
    var value = hash.digest('hex');
    return {
        salt:salt,
        passwordHash:value
    };
};
function saltHashPassword(userPassword){
    var salt = genRandomString(16);
    var passwordData = sha512(userPassword,salt);
    return passwordData;
}

function checkHashPassword(userPassword,salt){
    var passwordData = sha512(userPassword,salt);
    return passwordData;
}

const app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

app.post('/register/', (req,res, next)=>{

    var post_data = req.body; //GET POST PARAMS

    var uid = uuid.v4(); //Get UUID
    var plaint_password = post_data.password;
    var hash_data = saltHashPassword(plaint_password);
    var password = hash_data.passwordHash; //Get HASH VALUE
    var salt = hash_data.salt; //Get SALT

    var name = post_data.name;
    var email = post_data.email;

    db.query('SELECT * FROM users where email=?', [email],function(err,result,fields){
        db.on('error', function(err){
            console.log('[MySQL ERROR]',err);
        });

                if(result && result.length)
            res.json('User already exists!!!');
        else
        {
            db.query('INSERT INTO users (unique_id, name, email, encrypted_password, salt, created_at, updated_at) VALUES (?, ?, ?, ?, ?, NOW(),NOW())',[uid,name,email,password,salt],function(err,result,fields){
                db.on('error', function(err){
            console.log('[MySQL ERROR]',err);
                    res.json('Register error: ',err);
        });
                res.json('Register successful');
            })
        }
    });
});

app.post('/login/', (req,res,next)=>{
    var post_data = req.body;

    var user_password = post_data.password;
    var email = post_data.email;

        db.query('SELECT * FROM users where email=?', [email],function(err,result,fields){
        db.on('error', function(err){
            console.log('[MySQL ERROR]',err);
        });

                if(result && result.length)
        {
            var salt = result[0].salt;
            var encrypted_password = result[0].encrypted_password;
            var hashed_password = checkHashPassword(user_password,salt).passwordHash;
            if(encrypted_password == hashed_password)
                res.end(JSON.stringify(result[0]))
            else
                res.end(JSON.stringify('Wrong Password, Try again'));
        }
        else
        {
       res.json('User does NOT exist!!!');
        }
    });

});


app.get('/destinations', (req, res) => {
// get all destinations
    let sql = 'SELECT * FROM destinations';
    db.query(sql, (err, result) => {
        if (err) throw err;
        res.send(result);

    });

});

app.get('/destinations/:id', (req, res) => {
// Get specific dest_ID from the database
    let sql = `SELECT * FROM Countries WHERE id = ${req.params.id}`;
    db.query(sql, (err, result) => {
        if (err) console.log('Please enter the correct id');
        res.send(result);
        console.log("User searched" + req);

    });

});
app.get('/Search/:keyword1/:keyword2/:keyword3', (req, res) => {
// Search for the keywords where keyword 1 or 2 or 3 = parameter 1, 2 and 3
    let sql = `SELECT * FROM Countries WHERE Keyword1 ="${req.params.keyword1}" OR Keyword2 = "${req.params.keyword1}" OR Keyword3 = "${req.params.keyword1}" AND  Keyword1 = "${req.params.keyword2}" OR Keyword2 = "${req.params.keyword2}" OR Keyword3 = "${req.params.keyword2}" AND Keyword1 = "${req.params.keyword3}" OR Keyword2 = "${req.params.keyword3}" OR Keyword3 = "${req.params.keyword3}" ORDER BY RAND() `;
    db.query(sql, (err, result) => {
        if (err) throw err;
        res.send(result);
        console.log("User searched" + req);

    });

});

app.get('/Search/:keyword1/:keyword2', (req, res) => {
   // Two keywords search
    let sql = `SELECT * FROM Countries WHERE Keyword1 ="${req.params.keyword1}" OR Keyword2 = "${req.params.keyword1}" OR Keyword3 = "${req.params.keyword1}" AND Keyword1 = "${req.params.keyword2}" OR Keyword2 = "${req.params.keyword2}" OR Keyword3 = "${req.params.keyword2}" ORDER BY RAND() `;
    db.query(sql, (err, result) => {
        if (err) throw err;
        res.send(result);
        console.log("User searched" + req);

    });

});
app.get('/Search/:keyword1', (req, res) => {
    // One keyword search
     let sql = `SELECT * FROM Countries WHERE Keyword1 ="${req.params.keyword1}" OR Keyword2 = "${req.params.keyword1}" OR Keyword3 = "${req.params.keyword1}" ORDER BY RAND() `;
     db.query(sql, (err, result) => {
         if (err) throw err;
         res.send(result);
         console.log("User searched" + req);

     });

 });
 app.get('/Weather/:country1', (req, res) => {
    // Search for a specific country's weather
     let sql = `SELECT weather FROM Countries WHERE Country = "${req.params.country}" `;
     db.query(sql, (err, result) => {
         if (err) throw err;
         res.send(result);
         console.log("User searched" + req);
     });

 });

 app.get('/Summary/:country1', (req, res) => {
    // Search for a specific country summary
     let sql = `SELECT Summary FROM Countries WHERE Country = "${req.params.country1}" `;
     db.query(sql, (err, result) => {
         if (err) throw err;
         res.send(result);
         console.log("User searched" + req);

     });

 });
 app.get('/Attractions/:country1', (req, res) => {
    // Search for attractions for a specific country
     let sql = `SELECT Attractions FROM Countries WHERE Country = "${req.params.country1}" `;
     db.query(sql, (err, result) => {
         if (err) throw err;
         res.send(result);
         console.log("User searched" + req);

     });

 });

 app.post('/Rating/:rating/:comment', (req, res) => { // rating_id , ratingvalue , comments, pk: rating_id
    // Search for attractions for a specific country
     let sql = `INSERT INTO rating(ratingvalue, comments) VALUES (${req.params.rating} , "${req.params.comment}") `;
     db.query(sql, (err, result) => {
         if (err) throw err;
         res.send(result);
         console.log("User rated" + req);

     });

 });







const port = process.env.PORT || 3000;

app.listen(port, () => {

console.log(`Server started on port ${port}`);
});

