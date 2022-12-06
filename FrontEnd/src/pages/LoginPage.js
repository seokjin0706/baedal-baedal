import React, { useState } from "react";

const Login = () => {
  const [id, setId] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = (e) => {
    const loginBox = { id, password };

    fetch("http://127.0.0.1:3001/user/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(loginBox),
    }).then(() => {
      console.log("로그인성공");
    });
  };

  return (
    <div>
      <h1>로그인</h1>
      <input
        type="text"
        placeholder="Id"
        onChange={(e) => setId(e.target.value)}
        className="form"
      />
      <input
        type="text"
        placeholder="Password"
        onChange={(e) => setPassword(e.target.value)}
        className="form"
      />

      <button className="btn-login" onClick={handleLogin}>
        로그인
      </button>
    </div>
  );
};

export default Login;
