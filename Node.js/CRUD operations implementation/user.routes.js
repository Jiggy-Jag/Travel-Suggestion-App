module.exports = app => {
  const users = require("../controllers/user.controller.js");

  // Create a new User
  app.post("/users", users.create);

  // Retrieve all users
  app.get("/users", users.findAll);

  // Retrieve a single users with userId
  app.get("/users/:userId", users.findOne);

 };
