import React, { useState, useEffect } from "react";
import "../css/PostCreate.css";
import Header from "./Header";

const PostCreate = () => {
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  let nickName;
  let sessionStorage = window.sessionStorage;

  useEffect(() => {
    nickName = sessionStorage.getItem("nickName");
    console.log(nickName);
  }, []);

  const handlePostCreate = (e) => {
    const PostCreateBox = { title, content, nickName };

    fetch("http://127.0.0.1:3001/post/create", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(PostCreateBox),
    }).then(() => {
      console.log("게시글 작성성공");
      document.location.href = "/List"; //리스트 페이지로 이동
    });
  };

  return (
    <div>
      <Header />
      <div className="conm">
        <div className="Container-Create">
          <input
            type="text"
            placeholder="제목을 적어주세요..."
            className="input-title"
            onChange={(e) => setTitle(e.target.value)}
          />

          <input
            type="text"
            placeholder="본문을 적어주세요"
            className="input-content"
            onChange={(e) => setContent(e.target.value)}
          />

          <button className="btn-postCreate" onClick={handlePostCreate}>
            게시글 작성
          </button>
        </div>
      </div>
    </div>
  );
};

export default PostCreate;
