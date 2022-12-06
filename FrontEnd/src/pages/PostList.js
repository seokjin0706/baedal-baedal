import React, { useState, useEffect } from "react";
import axios from "axios";
import Post from "./Post";

const Posts = () => {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    axios.get("https://jsonplaceholder.typicode.com/users").then((response) => {
      setPosts(response.data);
    });
  }, []);

  return (
    <>
      <h1>setPosts</h1>
      <Post posts={posts} />
    </>
  );
};

export default Posts;
