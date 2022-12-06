import axios from "axios";
import React, { useState, useEffect } from "react";
import "../css/ListPage.css";

const List = () => {
  const [SessionId, setSessionId] = useState("");
  const [postID, setPostID] = useState([]);
  const [title, setTitle] = useState([]);
  const [content, setContent] = useState([]);
  const [nickName, setNickName] = useState([]);
  const url = "localhost:3001/post";

  useEffect(() => {
    let sessionStorage = window.sessionStorage;
    //setSessionId(sessionStorage.getItem("saveId")); //Test용
    setSessionId(sessionStorage.getItem("id")); //서버 돌아갈때는 이걸 열기
    console.log("saveID : " + SessionId); //Test용
  });

  function getList() {
    axios.get(url).then(function (response) {
      setPostID(response.data);
      console.log("데이터 가져옴");
    });
  }

  return (
    <div>
      <div className="Container-ListPage">
        <div className="Container_section"></div>
        <div className="Container_section">
          <div className="Container_section_main">
            <ul className="food_list">
              <li className="food_list_container">
                <span className="food_list_title">치킨먹을사람</span>
                <span className="food_list_content">
                  오늘 BBQ먹을 사람 구합니다.
                </span>
                <span className="food_list_nickName">KING</span>
              </li>
            </ul>
          </div>
        </div>
        <div className="Container_section"></div>
      </div>
    </div>
  );
};

export default List;
