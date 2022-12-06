import React, { useState } from "react";
import "../css/LoginPage.css";

const Login = () => {
  const [id, setId] = useState("");
  const [password, setPassword] = useState("");
  const [saveId, setSaveId] = useState(""); //test용 지울것
  let sessionStorage = window.sessionStorage;

  const SessionTest = (e) => {
    //test용 지울것
    sessionStorage.setItem("saveId", saveId);
    setSaveId(sessionStorage.getItem("saveId"));
    console.log("saveID : " + saveId);
    document.location.href = "/List";
  };

  const handleLogin = (e) => {
    const loginBox = { id, password };

    fetch("http://127.0.0.1:3001/user/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(loginBox),
    }).then(() => {
      console.log("로그인성공");
      sessionStorage.setItem("id", id);
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
            placeholder="IdSessionTest"
            className="form"
            onChange={(e) => setSaveId(e.target.value)}
          ></input>

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
          <button className="SessionTest" onClick={SessionTest}>
            SessionTest
          </button>
          <a href="/Register">회원가입</a>
        </div>
      </div>
    </div>
  );
};

export default Login;
