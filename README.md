## Installation
First we go to the db folder in TaskCompose attached to gitup and run the docker file,rreate an image named mysql_task 
```bash
docker build -t  mysql_task .
```

Next we initialize the dabase, we will go to the Docker-compose folder and run the command like in file docker-compose in TaskCompose folder.

We have successfully initialized the DB container!
  
## Introduce

 Next is the API here which has 2 forms:
first api without authentication includes:

```bash
/api/v1/auth/login
```
```bash
/api/v1/auth/register
```
```bash
/api/v1/tasks/getAll
```
```bash
/api/v1/tasks/get/{id}
```

2. API needs authentication and authorization:
```bash
/api/v1/tasks/create
```
```bash
/api/v1/tasks/update
```
```bash
/api/v1/tasks/create
```

## Usage

An unauthorization API:
GET ALL TASK  API :
```bash
/api/v1/tasks/getAll
```
![image](https://github.com/PhamDinhDuy-2508/TaskAssignment/assets/69359047/ec059f1b-b3be-4768-a172-bc72879310da)

GET TASK WITH ID  API : 

```bash
/api/v1/tasks/get/{id}
```
![image](https://github.com/PhamDinhDuy-2508/TaskAssignment/assets/69359047/8fcb0fb7-67e9-45b5-9e09-1ba76f422108)


To be able to use the authorization API:
_ If we do not have an account, we will go to 
```bash
/api/v1/auth/register
```
to register see example below.

example request body :
```bash
{
    "username" : "phamdinhduytest123",
    "password" :"25082000"
}
```

![image](https://github.com/PhamDinhDuy-2508/TaskAssignment/assets/69359047/13af3b49-f173-4428-b038-1e10f4fb242a)

After registering, we can start logging in (note that the username and password we just registered and currently by default all accounts are in the ADMIN role)
example request body :
```bash
{
    "username" : "phamdinhduytest123",
    "password" :"25082000"
}
```
![image](https://github.com/PhamDinhDuy-2508/TaskAssignment/assets/69359047/0b593431-aa21-47df-9b91-d9ed5303e98c)

Save the token And use that token for API authorizations
Create TASK  API : 
```bash
/api/v1/tasks/create
```
```bash
Header:{
'Authorization' : "Bearer" +  /* token has bee reponsed by Login */
}
```
```bash

request Body :
{
    "title":"phamdinhduytest123456",
    "description":"123123123123123123",
    "complete" : true
}
```

![image](https://github.com/PhamDinhDuy-2508/TaskAssignment/assets/69359047/788f9864-db9a-46b0-97c3-3c9428b96d84)

Update TASK  API : api/v1/tasks/update/{id}
Header:{
'Authorization' : "Bearer" +  /* token has bee reponsed by Login */
}
request Body :
{
    "title":"phamdinhduy2508123123123",
    "description":"123123123123123123",
    "complete" : true
}

![image](https://github.com/PhamDinhDuy-2508/TaskAssignment/assets/69359047/e7f6e88f-d3ca-4180-93bd-33750908aadd)

DELETE TASK  API : api/v1/tasks/delete/{id}
Header:{
'Authorization' : "Bearer" +  /* token has bee reponsed by Login */
}

![image](https://github.com/PhamDinhDuy-2508/TaskAssignment/assets/69359047/fbc39f8d-e00f-4ef1-9544-54bb58332b0b)
    
