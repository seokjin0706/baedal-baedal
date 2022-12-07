import React from "react";

const Post = ({ posts }) => {
  return (
    <div className="list-container">
      <div>
        {posts.map((post) => {
          return (
            <div className="list-title" key={post.postID}>
              {post.postID}
            </div>
          );
        })}
      </div>
      <div>
        {posts.map((post) => {
          return (
            <div key={post.postID} className="list-content" maxlength="10">
              {post.content}
            </div>
          );
        })}
      </div>
      <div>
        {posts.map((post) => {
          return (
            <div key={post.postID} className="list-nickName">
              {post.nickName}
            </div>
          );
        })}
      </div>
    </div>
  );
};

export default Post;
