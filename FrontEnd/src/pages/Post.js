import React from "react";

const Post = ({ posts }) => {
  return (
    <div>
      <div>
        {posts.map((post) => {
          return <div key={post.postID}>{post.title}</div>;
        })}
      </div>
      <div>
        {posts.map((post) => {
          return <div key={post.postID}>{post.content}</div>;
        })}
      </div>
      <div>
        {posts.map((post) => {
          return <div key={post.postID}>{post.nickName}</div>;
        })}
      </div>
    </div>
  );
};

export default Post;
