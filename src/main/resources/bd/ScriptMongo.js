// Connect to database
var db = connect("btokuuvbmabzcox-mongodb.services.clever-cloud.com/btokuuvbmabzcox", "u25c2o7xvoblajyduvak", "uTgSWg1sF3knY0yvKMmN");
//var db = db.getSiblingDB('btokuuvbmabzcox')
// Create collection in database
db.createCollection("users");

// Retrieve json file
var file = cat('./data.json');
var o = JSON.parse(file);

// Insert users from json file
db.users.insert(o);

// Change field birthDay to date type
db.users.find( { 'birthDay' : { $type : 2 } } ).forEach( function (x) {   
  x.birthDay = new Date(x.birthDay);
  db.users.save(x);
});

// Vider la collection users
/*db.getSiblingDB('users')
db.users.drop()*/