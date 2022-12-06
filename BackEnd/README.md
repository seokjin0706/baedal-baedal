# BackEnd


|API Title|URL|Method|Data Params|Success Response|Error Response|
|------|---|---|---|---|---|
|회원가입|POST|/user/create|```[{"userID":string, "passWord": string ,"userName": string ,"phoneNumber": string ,"adress": string ,"NickName": string}] ```|``` [{"userID":string, "passWord": string ,"userName": string ,"phoneNumber": string ,"adress": string ,"NickName": string}] ```|```[{"result":"fail"}] ```|
|로그인|POST|/user/login|``` [{"userID":string, "passWord": string}]```|```[{"result":"success"}] ```|``` [{"result":"fail"}] ```|
|로그아웃|POST|/user/logout||```[{"result":"success"}] ```||
|게시글 생성|POST|/post/create|```[{"title":string , "content" : string, "nickName": string}] ```|``` [{"title":string, "content": string,"nickName": string}] ```|``` [{"result":"fail"}] ```|
|전체 게시글 목록 보기|GET|/post||``` [{"postID":int", title":string, "content": string,"nickName": string}] ```|```[{"result":"fail"}] ```|
|특정 게시글 목록 보기|GET|/post/:postID||```[{"postID":int, "title":string, "content": string,"nickName": string}] ```|```[{"result":"fail"}] ```|
