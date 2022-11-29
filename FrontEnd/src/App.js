import { Route,Routes } from 'react-router-dom';
import Login from './pages/Login';
import Register from './pages/Register';
import Feed from './pages/Feed';
import home from './pages/home';

const App =()=>{
  return (
    <>
      
      <Routes>
      <Route path="/" element={<home/>} />
        <Route path="/login" element={<Login/>} />
        <Route path="/register" element={<Register/>} />
        <Route path="/feed" element={<Feed/>} exact/>
    </Routes>
    </>
  );
};


export default App;
