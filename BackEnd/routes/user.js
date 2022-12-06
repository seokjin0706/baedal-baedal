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

/* GET users listing. */
router.get('/', function (req, res, next) {
  res.send('respond with a resource');
});


/* POST user create*/
router.post('/create', function (req, res, next) {
  const userID = req.body.userID;
  const passWord = req.body.passWord;
  const userName = req.body.userName;
  const phoneNumber = req.body.phoneNumber;
  const adress = req.body.adress;
  const nickName = req.body.nickName;
  const insert_sql = {
    userID: userID,
    passWord: passWord,
    userName: userName,
    phoneNumber: phoneNumber,
    adress: adress,
    nickName: nickName,
  }
  connection.query('select userID from user where userID=?', [userID], (err, rows) => {
    if (rows.length) {
      res.json({ 'result': 'fail' });
    } else {
      connection.query('insert into user set?', insert_sql, (err, rows) => {
        if (err) throw err;
        console.log(`${userID} create OK`);
        res.json([insert_sql]);
      });
    }
  });
});

/* POST login.*/
router.post('/login', function (req, res, next) {
  const userID = req.body.userID;
  const passWord = req.body.passWord;
  connection.query('select * from user where userID=? AND passWord=?', [userID, passWord], (err, rows) => {
    if (err) throw err;

    if (rows.length) {
      req.session.userID = rows[0].userID;
      req.session.passWord = rows[0].passWord;
      req.session.userName = rows[0].userName;
      req.session.phoneNumber = rows[0].phoneNumber;
      req.session.adress = rows[0].adress;
      req.session.nickName = rows[0].nickName;
      req.session.isLogined = true;
      req.session.save(() => {
        res.json({"result":"success", "userID": rows[0].userID, "passWord": rows[0].passWord,"userName": rows[0].userName,"phoneNumber": rows[0].phoneNumber ,"adress": rows[0].adress ,"NickName": rows[0].nickName});
      })
    } else {
      res.json({ 'result': 'fail' });
    }
  });
});

/* POST logout.*/
router.post('/logout', function (req, res, next) {

  delete req.session.userID;
  delete req.session.passWord;
  delete req.session.userName;
  delete req.session.phoneNumber;
  delete req.session.adress;
  delete req.session.nickName;
  delete req.session.isLogined;
  req.session.save(() => {
    res.json({ 'result': 'success' });
  })
});

module.exports = router;