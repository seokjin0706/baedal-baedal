import {useEffect} from "react";
import { useDispatch,useSelector } from "react-redux";
import { changeField , initialForm } from "../../modules/auth";
import AuthForm from "../../components/auth/AuthForm";

const LoginForm = ()=>{
    const dispatch = useDispatch();
    const {form} = useSelector(({auth})=>({
        form : auth.login
    }))
    //인풋값 확인용
    const onChange = e =>{
        const {value , name} = e.target;
        dispatch(
            changeField({
                form:'login',
                key : name,
                value
            })
        );
    };
    // 폼 등록 이벤트 
    const onSubmit = e=>{
        e.preventDefault();
    };

    //폼초기화용
    useEffect(()=>{
        dispatch(initialForm('login'));
    },[dispatch]);

    return(
        <AuthForm
        type="login"
        form={form}
        onChange = {onChange}
        onSubmit = {onSubmit}
        />
    );

};

export default LoginForm;