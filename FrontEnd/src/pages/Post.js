import React from "react";

const Post = ({ posts }) => {
  return (
    <div>
      <div>
        {posts.map((post) => {
          return <div key={post.id}>{post.title}</div>;
        })}
      </div>
      <div>
        {posts.map((post) => {
          return <div key={post.id}>{post.content}</div>;
        })}
      </div>
      <div>
        {posts.map((post) => {
          return <div key={post.id}>{post.nickName}</div>;
        })}
      </div>
    </div>
  );
};

export default Post;
