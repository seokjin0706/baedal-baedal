const express = require('express');
const router = express.Router();

const mysql = require('mysql');

const connection = mysql.createConnection({
  host: 'localhost',
  user: 'baedal',
  password: 'passwd',
  database: 'baedal',
});

connection.connect();


/* GET chat listing */
router.get('/:postID', function (req, res, next) {
  connection.query('select * from chat where postID=?', [req.params.postID], (err, rows) => {
    if(rows.length){
      res.json(rows);
    }else{
      res.json([{'result' : 'fail', 'postID' : 0}]);
    }
  });
});

/* POST chat creating */
router.post('/create', function (req, res, next) {
    const postID = req.body.postID;
    const title = req.body.title;
    const sender = req.body.sender;
    const message = req.body.message;
    const insert_sql = {
        postID: postID,
        title: title,
        sender: sender,
        message: message,
    }
    connection.query('insert into chat set?', insert_sql, (err, rows) => {
      if (err){
        console.log(err);
        res.json({ 'result': 'fail' });
      }else{
        console.log(`${message} create OK`);
        res.json([insert_sql]);
      }
    });
  
  });
  
module.exports = router;