import styled from 'styled-components';
import { Link } from '../../../node_modules/react-router-dom/dist/index';
import palette from '../../lib/styles/palette';
import Button from '../common/Btn';

/**
 * form style sheet , Wrapper
 */

const StyledInput = styled.input`
  font-size: 1rem;
  border: none;
  background: ${palette.lime[2]};
  border-bottom: 1px solid rgba(0, 0, 0, 0.3);
  padding-bottom: 1rem;
  width: 100%;
  outline: none;
  &:focus {
    color: teal;
    border-bottom: 1px solid rgba(0, 0, 0, 0.6);
  }
  & + & {
    margin-top: 1rem;
  }
`;
const Footer = styled.div`
  margin-top: 2rem;
  text-align: right;
  a {
    color: rgba(0, 0, 0, 0.7);
    text-decoration: none;
    &:hover {
      color: rgba(0, 0, 0, 0.9);
    }
  }
`;

const AuthFormBlock = styled.div`
  h2 {
    margin: 0;
    color: red;
    margin-bottom: 1rem;
  }
`;

const tMap = {
  login: '로그인',
  register: '회원가입',
};

const AuthForm = ({ type, form, onChanege, onSubmit }) => {
  const text = tMap[type];
  return (
    <AuthFormBlock>
      <h3>{text}</h3>
      <form onSubmit={onSubmit}>
        <StyledInput
          autoComplete="id"
          name="id"
          placeholder="ID"
          type="text"
          onChange={onChanege}
          defaultvalue={form.id}
        />
        <StyledInput
          autoComplete="passWord"
          name="passWord"
          placeholder="PassWord"
          type="password"
          onChange={onChanege}
          defaultvalue={form.passWord}
        />
        {type === 'register' && (
          <StyledInput
            autoComplete="passWordCheck"
            name="passWordCheck"
            placeholder="PassWordCheck"
            type="text"
            onChange={onChanege}
            defaultvalue={form.passWordCheck}
          />
        )}
        {type === 'register' && (
          <StyledInput
            autoComplete="userName"
            name="userName"
            placeholder="userName"
            type="text"
            onChange={onChanege}
            defaultvalue={form.userName}
          />
        )}
        {type === 'register' && (
          <StyledInput
            autoComplete="phoneNumber"
            name="phoneNumber"
            placeholder="phoneNumber"
            type="number"
            onChange={onChanege}
            defaultvalue={form.phoneNumber}
          />
        )}
        {type === 'register' && (
          <StyledInput
            autoComplete="adress"
            name="adress"
            placeholder="adress"
            type="text"
            onChange={onChanege}
            defaultvalue={form.adress}
          />
        )}
        {type === 'register' && (
          <StyledInput
            autoComplete="nickName"
            name="nickName"
            placeholder="nickName"
            type="text"
            onChange={onChanege}
            defaultvalue={form.nickName}
          />
        )}

        <Button orange fullWidth style={{ marginTop: '1rem' }}>
          {text}
        </Button>
      </form>
      <Footer>
        {type === 'login' ? (
          <Link to="/register">회원가입</Link>
        ) : (
          <Link to="/login">로그인</Link>
        )}
      </Footer>
    </AuthFormBlock>
  );
};

export default AuthForm;
