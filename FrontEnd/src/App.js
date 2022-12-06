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
