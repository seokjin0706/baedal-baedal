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

/* GET posts listing. */
router.get('/', function (req, res, next) {
  connection.query('select * from post', (err, rows) => {
    if (rows.length) {
      res.json(rows);

    } else {
      res.json({ 'result': 'fail' });
    }
  });
});

/* GET post listing */
router.get('/:postID', function (req, res, next) {
  connection.query('select * from post where postID=?', [req.params.postID], (err, rows) => {
    if(rows.length){
      res.json(rows);
    }else{
      res.json({'result' : 'fail'});
    }
  });
});
/* GET mypost listing */
router.get('/mypost/:nickName', function (req, res, next) {
  connection.query('select * from post where nickName=?', [req.params.nickName], (err, rows) => {
    if(rows.length){
      res.json(rows);
    }else{
      res.json([{'result' : 'fail', 'nickName' : ''}]);
    }
  });
});
/* POST post creating */
router.post('/create', function (req, res, next) {
  const title = req.body.title;
  const content = req.body.content;
  const nickName = req.body.nickName;
  const insert_sql = {
    title: title,
    content: content,
    nickName: nickName,
  }
  connection.query('insert into post set?', insert_sql, (err, rows) => {
    if (err){
      console.log(err);
      res.json({ 'result': 'fail' });
    }else{
      console.log(`${title} create OK`);
      res.json([insert_sql]);
    }
  });

});


module.exports = router;