import React, { useEffect } from "react";
import "../css/UserDetail.css";

const userDetail = () => {
  let userName;
  let sessionStorage = window.sessionStorage;

  const HandleLogout = (e) => {};

  return (
    <div>
      <div className="Con-userDetail">
        <div className="Container-userDetail">
          <div className="Container-userId">Sejin</div>
          <button className="logout">로그아웃</button>
        </div>
      </div>
    </div>
  );
};

export default userDetail;
