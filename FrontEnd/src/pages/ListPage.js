import axios from "axios";
import React, { useState, useEffect } from "react";

const List = () => {
  const [postID, setPostID] = useState([]);
  const [title, setTitle] = useState([]);
  const [content, setContent] = useState([]);
  const [nickName, setNickName] = useState([]);
  const url = "localhost:3001/post";

  function getList() {
    axios.get(url).then(function (response) {
      setPostID(response.data);
      console.log("데이터 가져옴");
    });
  }

  return (
    <div>
      <div>리스트 페이지</div>
    </div>
  );
};

export default List;
