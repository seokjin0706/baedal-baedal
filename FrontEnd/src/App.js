import { Route, Routes } from "react-router-dom";
import Home from "./pages/HomePage";
import List from "./pages/ListPage";
import Login from "./pages/LoginPage";
import Register from "./pages/RegisterPage";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/List" element={<List />} />
      <Route path="/login" element={<Login />} />
      <Route path="/Register" element={<Register />} />
    </Routes>
  );
}

export default App;
