import styled from 'styled-components';
import palette from '../../lib/styles/palette';
import Button from '../common/Btn';
import { Link } from 'react-router-dom';
<style>
@import url('https://fonts.googleapis.com/css2?family=Lato&display=swap');
</style>
/**
 * layOut component
 *
 */


const AuthTemplateBlock = styled.div`
font-family: 'Lato', sans-serif;
  position : absolute;
  left:0;
  top:0;
  right:0;
  bottom:0;
  display: flex;
  flex-direction :column;
  justify-content: center;
  align-items: center;
  background-color: lavender;
  
`;

const FormContainer = styled.div`
  .logo-container{
    display: block;
    padding-bottom: 2rem;
    text-align: center;
    font-weight: 500;
    letter-spacing: 1.5px;
    
    a{
      text-decoration: none;
      color : black;
      font-weight: 700;
    }
  }
  box-shadow: 0 0 6px rgba(0,0,0,0.5);
  padding: 2rem;
  width: 400px;
  background: ${palette.lime[2]};
  border-radius: 4px;
`;

const AuthTemplate = ({children}) => {
  return (
    <AuthTemplateBlock>
      <FormContainer>
        <div className='logo-container'>
          <Link to="/">배달배달 배달비공유웹</Link>
        </div>
        {children}
      </FormContainer>

    </AuthTemplateBlock>
  );
};

export default AuthTemplate;

