import React from "react";

function FoodList({ posts }) {
  return (
    <ul>
      {posts.map((post) => {
        return (
          <li key={post.postID}>
            <span>{post.title}</span>
            <span>{post.content}</span>
            <span>{post.nickName}</span>
          </li>
        );
      })}
    </ul>
  );
}

export default FoodList;
