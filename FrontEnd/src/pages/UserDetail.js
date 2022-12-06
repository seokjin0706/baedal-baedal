import React, { useState, useEffect } from "react";
import "../css/UserDetail.css";

const UserDetail = () => {
  const [abc, setabc] = useState("");
  const url = "http://127.0.0.1:3001/user/logout";
  let sessionStorage = window.sessionStorage;
  let nickName;

  useEffect(() => {
    nickName = sessionStorage.getItem("nickName");
    console.log(nickName);
    document.getElementById("Container-userId").innerHTML = nickName;
  }, []);

  const handlerLogOut = (e) => {
    fetch(url, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
    }).then((response) => {
      console.log("로그아웃 성공");
      document.location.href = "/"; //홈페이지로 이동

      //세션으로 가져온 값 삭제.... Start
      sessionStorage.removeItem("userID");
      sessionStorage.removeItem("passWord");
      sessionStorage.removeItem("userName");
      sessionStorage.removeItem("phoneNumber");
      sessionStorage.removeItem("adress");
      sessionStorage.removeItem("nickName");
      sessionStorage.clear();
      //세션으로 가져온 값 삭제.... End
    });
  };

  return (
    <div>
      <div className="Con-userDetail">
        <div className="Container-userDetail">
          <div id="Container-userId">undefined</div>
          <button className="logout" onClick={handlerLogOut}>
            로그아웃
          </button>
        </div>
      </div>
    </div>
  );
};

export default UserDetail;
