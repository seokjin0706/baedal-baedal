import React, { useState, useEffect } from "react";
import axios from "axios";
import Post from "./Post";

const Posts = () => {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:3001/post").then((response) => {
      setPosts(response.data);
    });
  }, []);

  return (
    <>
      <h1>주문주문 리스트</h1>
      <button className="writ">글쓰기</button>
      <Post posts={posts} />
    </>
  );
};

export default Posts;
