import React, { useState } from "react";
import "../css/LoginPage.css";

const Login = () => {
  const [id, setId] = useState("");
  const [password, setPassword] = useState("");
  const [session, setSession] = useState("");

  let sessionStorage = window.sessionStorage;

  const handleLogin = (e) => {
    const loginBox = { id, password };

    fetch("http://127.0.0.1:3001/user/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(loginBox),
    }).then((response) => {
      setSession(response.data);

      console.log("로그인성공");
      //session 저장 Start
      sessionStorage.setItem("userID", "userID"); //뒤에 값들을 json에서 빼오면됨  //아마도 ... session.userID
      sessionStorage.setItem("passWord", "password"); //session.passWord
      sessionStorage.setItem("userName", "오바자"); //session.UserName
      sessionStorage.setItem("phoneNumber", "Number"); //session.Number
      sessionStorage.setItem("adress", "adress"); //session.adress
      sessionStorage.setItem("nickName", "닉네임"); //session.nickName
      //session 저장 End
      document.location.href = "/List"; //리스트 페이지로 이동
    });
  };

  return (
    <div>
      <div className="co">
        <div className="Container">
          <h1 className="title">로그인</h1>

          <input
            type="text"
            placeholder="Id"
            className="form"
            onChange={(e) => setId(e.target.value)}
          />
          <input
            type="password"
            placeholder="Password"
            className="form"
            onChange={(e) => setPassword(e.target.value)}
          />
          <button className="btn-login" onClick={handleLogin}>
            로그인
          </button>
          <a href="/Register">회원가입</a>
        </div>
      </div>
    </div>
  );
};

export default Login;
