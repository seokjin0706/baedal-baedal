import React, { useState, useEffect } from "react";
import axios from "axios";
import Post from "./Post";

const Posts = () => {
  const [posts, setPosts] = useState([]);
  let sessionStorage = window.sessionStorage;
  let userID;
  let nickName;
  let passWord;

  useEffect(() => {
    nickName = sessionStorage.getItem("nickName");
    console.log(nickName);
    document.getElementById("user-nickName").innerHTML = nickName;

    //잠깐임시
    sessionStorage.setItem("userID", "userSJ"); //뒤에 값들을 json에서 빼오면됨  //아마도 ... session.userID
    sessionStorage.setItem("passWord", "p123"); //session.passWord
    sessionStorage.setItem("userName", "오바자"); //session.UserName
    sessionStorage.setItem("phoneNumber", "Number"); //session.Number
    sessionStorage.setItem("adress", "adress"); //session.adress
    sessionStorage.setItem("nickName", "닉네임"); //session.nickName
    //잠깐임시

    axios
      .get("https://my-json-server.typicode.com/typicode/demo/posts")
      .then((response) => {
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
  const HandleUserDetail = (e) => {
    document.location.href = "/UserDetail"; //유저 디테일 페이지로 이동
  };

  return (
    <>
      <h1>주문주문 리스트</h1>

      <button className="writ" onClick={HandlePostCreate}>
        글쓰기
      </button>
      <button className="usermom" onClick={HandleUserDetail}>
        유저 정보 보기
      </button>

      <div id="user-nickName">undefined</div>
      <Post posts={posts} />
    </>
  );
};

export default Posts;
