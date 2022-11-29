import { createAction, handleActions } from 'redux-actions';

const START_LODING = 'loding/START_LODING';
const END_LODING = 'loding/END_LODING';

//payload 설정

export const startLoading = createAction(
  START_LODING,
  (requestType) => requestType,
);

export const endLoading = createAction(
  END_LODING,
  (requestType) => requestType,
);

const initialState = {};

const loading = handleActions(
  {
    [START_LODING]: (state, action) => ({ ...state, [action.payload]: true }),
    [END_LODING]: (state, action) => ({ ...state, [action.payload]: false }),
  },
  initialState,
);

export default loading;
