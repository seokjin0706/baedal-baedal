import React, { useState, useEffect } from "react";

const List = () => {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    fetch("http://localhost:3000/post", { method: "GET" })
      .then((result) => result.json)
      .then((data) => {
        setPosts(data);
      });
  }, []);

  return (
    <div>
      <div>리스트 페이지</div>
      <ul>
        {posts.map((post) => (
          <li key={post.id}>{post.title}</li>
        ))}
      </ul>
    </div>
  );
};

export default List;
