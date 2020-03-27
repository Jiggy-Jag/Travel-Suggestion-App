# group-project-2019-20-group-13-1
-Licensing
![](BubblePickLicence.png)

- API Documentation:

<b> GET /destinations:</b>

Displays all destinations

optional /id for specific country search

<b>GET /Search/keywords:</b>

Displays search results for keywords searched,

optional /keyword1/keyword2/keyword3 ; the user can search between 1 and 3 keywords

<b>GET /Weather:</b> 

search countries weather 

add /country1 for optional specific country weather search

<b> GET /Summary:</b>

search countries summary

add /country1 for optional specific country summary search

<b>GET /Attractions: </b>
search countries attractions

add /country1 for optional specific country summary search

<b> POST /rating: </b>

add user reviews to the database.

add /rating/comments 

rating : number of stars

comments: user feedback

- System Architecture:

<img width="615" alt="app Architecture" src="https://user-images.githubusercontent.com/56381845/77708495-26962700-6fc0-11ea-9ebd-93e7732c39ab.png">

- How to access the server:

1. Edit database IP address user and password from dbconfig.js

2.Make sure const dbcconfig in dbconnect.js is on the right path.

3.Make sure <b>Mysql1</b> in app.js is on the right path.

4.Make sure Nodejs is installed alongside Mysql and express 

--to install mysql and express run the following commands in the cmd (console commandline)

<b>npm install Mysql</b>

<b> npm install express</b>

5. Finally, run the following in the cmd

<b>node app.js</b>

group-project-2019-20-group-13-1 created by GitHub Classroom

