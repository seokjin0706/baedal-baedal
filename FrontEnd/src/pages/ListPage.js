import axios from "axios";
import React, { useState, useEffect } from "react";
import "../css/ListPage.css";
import FooList from "./FooList";

const List = () => {
  const [SessionId, setSessionId] = useState("");
  const [posts, setPosts] = useState("");
  const url = "https://my-json-server.typicode.com/typicode/demo/posts";
  let sessionStorage = window.sessionStorage;
  //const foodset = document.getElementsByClassName("food_list");

  useEffect(() => {
    //setSessionId(sessionStorage.getItem("saveId")); //Test용
    setSessionId(sessionStorage.getItem("id")); //서버 돌아갈때는 이걸 열기
    console.log("saveID : " + SessionId); //Test용
    axios
      .get(url)
      .then((response) => {
        setPosts(response.data);
        console.log(response.data);
      })
      .catch((e) => console.log("오류문.."));
  }, []);

  return (
    <div>
      <div className="Container-ListPage">
        <div className="Container_section"></div>
        <div className="Container_section">
          <div className="Container_section_main">
            <FooList posts={posts} />
          </div>
        </div>
        <div className="Container_section"></div>
      </div>
    </div>
  );
};

export default List;
