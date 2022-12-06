# BackEnd


|API Title|URL|Method|Data Params|Success Response|Error Response|
|------|---|---|---|---|---|
|회원가입|POST|/user/create||``` "object":[{"userID":string, "passWord": string},"userName": string},"phoneNumber": string},"adress": string},"NickName": string} ```|``` "object":[{"result":"fail"} ```|
|로그인|POST|/user/login||```"object":[{"result":"success"} ```|``` "object":[{"result":"fail"} ```|
|로그아웃|POST|/user/logout||```"object":[{"result":"success"} ```||
|게시글 생성|POST|/post/create||``` "object":[{"title":string, "content": string},"nickName": string} ```|``` "object":[{"result":"fail"} ```|
|전체 게시글 목록 보기|GET|/post||``` "object":[{"postID":int", title":string, "content": string},"nickName": string} ```|``` "object":[{"result":"fail"} ```|
|특정 게시글 목록 보기|GET|/post/:postID||``` "object":[{"postID":int, "title":string, "content": string},"nickName": string} ```|``` "object":[{"result":"fail"} ```|
