import styled,{css} from "styled-components"
import palette from "../../lib/styles/palette"

const StyledBtn = styled.button`
    border : none;
    border-radius : 10px;
    font-size =1rem;
    padding: 0.2rem 1rem;
    color : white;
    cursor: pointer;

    background :  ${palette.teal[3]};
    &:hover,
    &:focus,
    &:active {
      color: ${palette.teal[5]};
    }
    ${props=>props.fullWidth&&css`
      padding-top:0.5rem;
      padding-bottom: 0.8rem;
      width:100%;
      font-size:1.5rem;
    `}
    ${props=>props.orange&&css`
      background : ${palette.orange[2]};
      &hover{
        background : ${palette.orange[4]};
      }
    `}
`;

const Button = props => <StyledBtn  {...props}/>;

export default Button;