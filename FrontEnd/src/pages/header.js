import React from "react";
import { useState, useEffect } from "react";
import "../css/Header.css";

function Header(props) {
  const [nickNamea, nickNameSet] = useState([]);
  let nickName;
  useEffect(() => {
    nickName = sessionStorage.getItem("nickName");
    console.log("nick : " + nickName);
    document.getElementById("header_nickName").innerHTML = nickName;
  }, []);

  return (
    <>
      <header className="header_container">
        <div className="box-logo">
          <span>배달배달</span>
        </div>

        <div className="box"></div>
        <div className="box-nickName">
          <div id="header_nickName">undefiend</div>
        </div>
        <div className="box-icon">
          <a href="/List">
            <div className="icon">리스트</div>
          </a>
          <a href="/chat">
            <div className="icon">채팅방</div>
          </a>
          <a href="/userDetail">
            <div className="icon">자세히</div>
          </a>
        </div>
      </header>
    </>
  );
}

export default Header;
