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
            res.json(JSON.stringify(rows));

        }else{
            res.json({ 'result': 'fail' });
        }
      });
});


module.exports = router;