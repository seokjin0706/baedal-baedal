import React, { useState, useEffect } from "react";
import axios from "axios";
import Post from "./Post";
import Header from "./Header";
import "../css/ListPage.css";

const Posts = () => {
  const [posts, setPosts] = useState([]);
  let sessionStorage = window.sessionStorage;
  let userID;
  let passWord;
  let url = "http://127.0.0.1:3001/post";
  useEffect(() => {
    //잠깐임시
    /*
    sessionStorage.setItem("userID", "userSJ"); //뒤에 값들을 json에서 빼오면됨  //아마도 ... session.userID
    sessionStorage.setItem("passWord", "p123"); //session.passWord
    sessionStorage.setItem("userName", "오바자"); //session.UserName
    sessionStorage.setItem("phoneNumber", "Number"); //session.Number
    sessionStorage.setItem("adress", "adress"); //session.adress
    sessionStorage.setItem("nickName", "닉네임"); //session.nickName
    */
    //잠깐임시

    axios.get(url).then((response) => {
      setPosts(response.data);
      userID = sessionStorage.getItem("userID");
      passWord = sessionStorage.getItem("passWord");
      console.log(userID);
      console.log(passWord);
    });
  }, []);

  const HandlePostCreate = (e) => {
    document.location.href = "/PostCreate"; //글쓰기 페이지로 이동
  };

  return (
    <>
      <Header />
      <h1>주문주문 리스트</h1>

      <button className="writ" onClick={HandlePostCreate}>
        글쓰기
      </button>
      <Post posts={posts} />
    </>
  );
};

export default Posts;
