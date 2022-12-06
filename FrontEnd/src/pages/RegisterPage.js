import React, { useState } from "react";

const RegisterPage = () => {
  const [userID, setId] = useState("");
  const [passWord, setPassword] = useState("");
  const [userName, setUserName] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");
  const [adress, setAdress] = useState("");
  const [nickName, setNickName] = useState("");

  const handleRegister = (e) => {
    const registerBox = {
      userID,
      passWord,
      userName,
      phoneNumber,
      adress,
      nickName,
    };

    fetch("http://localhost:3001/user/create", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(registerBox),
    }).then(() => {
      console.log("회원가입성공");
    });
  };

  return (
    <div>
      <input
        type="text"
        placeholder="Id"
        onChange={(e) => setId(e.target.value)}
        className="form"
      />
      <input
        type="text"
        placeholder="PassWord"
        onChange={(e) => setPassword(e.target.value)}
        className="form"
      />
      <input
        type="text"
        placeholder="이름"
        onChange={(e) => setUserName(e.target.value)}
        className="form"
      />
      <input
        type="phoneNumber"
        placeholder="휴대폰번호"
        onChange={(e) => setPhoneNumber(e.target.value)}
        className="form"
      />
      <input
        type="text"
        placeholder="주소"
        onChange={(e) => setAdress(e.target.value)}
        className="form"
      />
      <input
        type="text"
        placeholder="닉네임"
        onChange={(e) => setNickName(e.target.value)}
        className="form"
      />
      <button className="btn-login" onClick={handleRegister}>
        로그인
      </button>
    </div>
  );
};

export default RegisterPage;
