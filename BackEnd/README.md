# BackEnd


|API Title|URL|Method|Data Params|Success Response|Error Response|
|------|---|---|---|---|---|
|회원가입|POST|/user/create|```[{"userID":string, "passWord": string ,"userName": string ,"phoneNumber": string ,"address": string ,"nickName": string}] ```|``` [{"userID":string, "passWord": string ,"userName": string ,"phoneNumber": string ,"address": string ,"nickName": string}] ```|```[{"result":"fail"}] ```|
|로그인|POST|/user/login|``` [{"userID":string, "passWord": string}]```|```[{"result":"success", "userID":string, "passWord": string ,"userName": string ,"phoneNumber": string ,"address": string ,"nickName": string}] ```|``` [{"result":"fail"}] ```|
|로그아웃|POST|/user/logout||```[{"result":"success"}] ```||
|게시글 생성|POST|/post/create|```[{"title":string , "content" : string, "nickName": string}] ```|``` [{"title":string, "content": string,"nickName": string}] ```|``` [{"result":"fail"}] ```|
|전체 게시글 목록 보기|GET|/post||``` [{"postID":int", title":string, "content": string,"nickName": string}] ```|```[{"result":"fail"}] ```|
|특정 게시글 목록 보기|GET|/post/:postID||```[{"postID":int, "title":string, "content": string,"nickName": string}] ```|```[{"result":"fail"}] ```|
|채팅방 정보 얻기|GET|/chat/:postID||```[{"chatID" : int, "postID" : int, "title":string, "sender": string, "message"}] ```|```[{'result' : 'fail', 'postID' : 0}] ```|
|채팅 메시지 생성|POST|/chat/create|```[{"postID":int , "title" : string, "sender": string, "message": string}] ```|``` [{"postID":int , "title" : string, "sender": string, "message": string}] ```|``` [{"result":"fail"}] ```|
