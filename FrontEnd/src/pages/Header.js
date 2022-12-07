import React from "react";
import { useState, useEffect } from "react";
import "../css/Header.css";
import { FaRocketchat, FaClipboardList, FaUserAlt } from "react-icons/fa";

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
            <div className="icon">
              <FaClipboardList size="34" />
            </div>
          </a>
          <a href="/chat">
            <div className="icon">
              <FaRocketchat size="34" />
            </div>
          </a>
          <a href="/userDetail">
            <div className="icon">
              <FaUserAlt size="34" />
            </div>
          </a>
        </div>
      </header>
    </>
  );
}

export default Header;
