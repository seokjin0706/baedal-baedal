import axios from "axios";
import React, { useState, useEffect } from "react";
import "../css/ListPage.css";
import FoodList from "./FoodList";

const List = () => {
  const [SessionId, setSessionId] = useState("");
  const [posts, setPosts] = useState("");
  const url = "http://localhost:3001/post";
  let sessionStorage = window.sessionStorage;
  //const foodset = document.getElementsByClassName("food_list");

  const getList = () => {
    axios
      .get(url)
      .then((response) => {
        setPosts(response.data);
      })
      .catch((e) => console.log("오류문.."));
  };

  useEffect(() => {
    //setSessionId(sessionStorage.getItem("saveId")); //Test용
    setSessionId(sessionStorage.getItem("id")); //서버 돌아갈때는 이걸 열기
    console.log("saveID : " + SessionId); //Test용
    getList();
  }, []);

  return (
    <div>
      <div className="Container-ListPage">
        <div className="Container_section"></div>
        <div className="Container_section">
          <div className="Container_section_main">
            <FoodList posts={posts} />
          </div>
        </div>
        <div className="Container_section"></div>
      </div>
    </div>
  );
};

export default List;
