import { Route, Routes } from "react-router-dom";
import Home from "./pages/HomePage";
import List from "./pages/PostList";
import Login from "./pages/LoginPage";
import Register from "./pages/RegisterPage";
import PostCreate from "./pages/PostCreate";
import UserDetail from "./pages/UserDetail";

function App() {
  return (
    <Routes>
      @import
      url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
      <Route path="/" element={<Home />} />
      <Route path="/PostCreate" element={<PostCreate />} />
      <Route path="/UserDetail" element={<UserDetail />} />
      <Route path="/List" element={<List />} />
      <Route path="/login" element={<Login />} />
      <Route path="/Register" element={<Register />} />
    </Routes>
  );
}

export default App;
