import React, { useState } from "react";
import "../css/RegisterPage.css";

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
      document.location.href = "/Login"; //리스트 페이지로 이동
    });
  };

  return (
    <div>
      <div class="co">
        <div class="Container">
          <h3 class="title">회원가입</h3>

          <input
            type="text"
            placeholder="Id"
            className="form"
            onChange={(e) => setId(e.target.value)}
          />
          <input
            type="text"
            onChange={(e) => setPassword(e.target.value)}
            placeholder="PassWord"
            className="form"
          />
          <input
            type="text"
            onChange={(e) => setUserName(e.target.value)}
            placeholder="이름"
            className="form"
          />
          <input
            type="phoneNumber"
            onChange={(e) => setPhoneNumber(e.target.value)}
            placeholder="휴대폰번호"
            className="form"
          />
          <input
            type="text"
            onChange={(e) => setAdress(e.target.value)}
            placeholder="주소"
            className="form"
          />
          <input
            type="text"
            onChange={(e) => setNickName(e.target.value)}
            placeholder="닉네임"
            className="form"
          />
          <button className="btn-register" onClick={handleRegister}>
            회원가입
          </button>
          <a href="/Login">로그인 페이지로 돌아가기</a>
        </div>
      </div>
    </div>
  );
};

export default RegisterPage;
