//폼관리를 위한 리덕스 모듈
import { createAction, handleActions } from 'redux-actions';
import produce from 'immer';
import { takeLatest } from 'redux-saga/effects';
import createRequestSage, {
  createRequestActionTypes,
} from '../lib/createRequestSaga';
import * as authAPI from '../lib/api/auth';

const CHANGE_FIELD = 'auth/CHANGE_FIELD';
const INITIALIZE_FORM = 'auth/INITIALIZE_FORM';

const [REGISTER, REGISTER_SUCCESS, REGISTER_FAILURE] =
  createRequestActionTypes('auth/REFISTER');

const [LOGIN, LOGIN_SUCCESS, LOGIN_FAILURE] =
  createRequestActionTypes('auth/LOGIN');
export const changeField = createAction(
  CHANGE_FIELD,
  ({ form, key, value }) => ({
    form, // 로그인 , 회원가입
    key, // id,pass,passcheck , userName, address, phoneNumber , nickName
    value,
  }),
);

export const initialForm = createAction(INITIALIZE_FORM, (form) => form);

export const register = createAction(
  REGISTER,
  ({ id, password, userName, address, phoneNumber, nickName }) => ({
    id,
    password,
    userName,
    address,
    phoneNumber,
    nickName,
  }),
);

export const login = createAction(LOGIN, ({ id, password }) => ({
  id,
  password,
}));

//사가 생성
const registerSaga = createRequestSage(REGISTER, authAPI.register);
const loginSaga = createRequestSage(LOGIN, authAPI.login);

export function* authSaga() {
  yield takeLatest(REGISTER, registerSaga);
  yield takeLatest(LOGIN, loginSaga);
}

const initialState = {
  login: {
    id: '',
    password: '',
  },
  register: {
    id: '',
    password: '',
    passwordCheck: '',
    userName: '',
    address: '',
    phoneNumber: '',
    nickName: '',
  },
  auth: null,
  authError: null,
};

const auth = handleActions(
  {
    [CHANGE_FIELD]: (state, { payload: { form, key, value } }) =>
      produce(state, (draft) => {
        draft[form][key] = value; //state.login.id 이런형식
      }),
    [INITIALIZE_FORM]: (state, { payload: form }) => ({
      ...state,
      [form]: initialState[form],
      authError: null, //폼 바뀔때 회원 인증 에러 초기화 해주어야한다.
    }),
    [LOGIN_SUCCESS]: (state, { payload: auth }) => ({
      ...state,
      authError: null, //성공한 경우 에러코드 초기화
      auth,
    }),
    [LOGIN_FAILURE]: (state, { payload: error }) => ({
      ...state,
      authError: error, //실패한경우 auth상태를 error로 바꿈 , auth에 밀어주지않고 자체적으로 처리함
    }),
    [REGISTER_SUCCESS]: (state, { payload: auth }) => ({
      ...state,
      authError: null, //성공한 경우 에러코드 초기화
      auth,
    }),
    [REGISTER_FAILURE]: (state, { payload: error }) => ({
      ...state,
      authError: error, //실패한경우 auth상태를 error로 바꿈 , auth에 밀어주지않고 자체적으로 처리함
    }),
  },
  initialState,
);

export default auth;
