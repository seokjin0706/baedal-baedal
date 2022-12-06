import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { changeField, initialForm, register } from '../../modules/auth';
import AuthForm from '../../components/auth/AuthForm';

const RegisterForm = () => {
  const dispatch = useDispatch();
  const { form, auth, authError } = useSelector(({ auth }) => ({
    form: auth.register,
    auth: auth.auth,
    authError: auth.authError,
  }));
  //인풋값 확인용
  const onChange = (e) => {
    const { value, name } = e.target;
    dispatch(
      changeField({
        form: 'register',
        key: name,
        value,
      }),
    );
  };
  // 폼 등록 이벤트
  const onSubmit = (e) => {
    e.preventDefault();
    const {
      id,
      password,
      passwordCheck,
      userName,
      address,
      phoneNumber,
      nickName,
    } = form;
    /** 인풋값 사용자 실수 처리파트 구현 필요 todo start */
    if (password !== passwordCheck) {
      return;
    }
    dispatch(
      register({ id, password, userName, address, phoneNumber, nickName }),
    );
    /** 인풋값 사용자 실수 처리파트 구현 필요 todo end */
  };

  //폼초기화용
  useEffect(() => {
    dispatch(initialForm('register'));
  }, [dispatch]);

  //성공 실패처리용
  useEffect(() => {
    if (authError) {
      console.log('오류');
      console.log(authError);
      return;
    }
    if (auth) {
      console.log('성공');
      console.log(auth);
    }
  }, [auth, authError]);
  return (
    <AuthForm
      type="register"
      form={form}
      onChange={onChange}
      onSubmit={onSubmit}
    />
  );
};

export default RegisterForm;
