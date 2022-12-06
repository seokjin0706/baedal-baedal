import React from "react";

const Post = ({ posts }) => {
  return (
    <div className="list-container">
      <div>
        {posts.map((post) => {
          return (
            <div className="list-title" key={post.id}>
              {post.title}
            </div>
          );
        })}
      </div>
      <div>
        {posts.map((post) => {
          return (
            <div key={post.id} className="list-content">
              {post.content}
            </div>
          );
        })}
      </div>
      <div>
        {posts.map((post) => {
          return (
            <div key={post.id} className="list-nickName">
              {post.nickName}
            </div>
          );
        })}
      </div>
    </div>
  );
};

export default Post;
