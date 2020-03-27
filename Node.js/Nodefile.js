var crypto = require('crypto');
var uuid = require('uuid');
var express = require('express');
var mysql = require('mysql');
var bodyParser = require('body-parser');

var con = mysql.createConnection({
host:'0.0.0.0',
user:'root',
password: 'mohamed123',
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



app.post('/register/', (req,res, next)=>{
    
    var post_data = req.body; //GET POST PARAMS
    
    var uid = uuid.v4(); //Get UUID
    var plaint_password = post_data.password;
    var hash_data = saltHashPassword(plaint_password);
    var password = hash_data.passwordHash; //Get HASH VALUE
    var salt = hash_data.salt; //Get SALT
    
    var name = post_data.name;
    var email = post_data.email;
    
    con.query('SELECT * FROM users where email=?', [email],function(err,result,fields){
        con.on('error', function(err){
            console.log('[MySQL ERROR]',err);
        });
        
                if(result && result.length)
            res.json('User already exists!!!');
        else 
        {
            con.query('INSERT INTO users (unique_id, name, email, encrypted_password, salt, created_at, updated_at) VALUES (?, ?, ?, ?, ?, NOW(),NOW())',[uid,name,email,password,salt],function(err,result,fields){
                con.on('error', function(err){
            console.log('[MySQL ERROR]',err);
                    res.json('Register error: ',err);
        });
                res.json('Register successful');
            })
        }
    });
})

app.post('/login/', (req,res,next)=>{
    var post_data = req.body;
    
    var user_password = post_data.password;
    var email = post_data.email;
    
        con.query('SELECT * FROM users where email=?', [email],function(err,result,fields){
        con.on('error', function(err){
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
    
})


const port = process.env.PORT || 3000;
app.listen(port,()=>{

console.log(`Database is running on port ${port}...`);
})
