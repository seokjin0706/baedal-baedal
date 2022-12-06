import AuthForm from "../components/auth/AuthForm";
import AuthTemplate from "../components/auth/AuthTemplate";
import LoginForm from "../containers/auth/loginForm";


const Login = () =>{
    return (
        <AuthTemplate>
            <LoginForm/>
        </AuthTemplate>
    );
};

export default Login;