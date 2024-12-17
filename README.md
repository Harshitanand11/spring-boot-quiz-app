Here is how to test the end points:
Test API Endpoints
Start a Quiz:
POST
URL: http://localhost:8080/quiz/start
Parameters: userName=John

Get a Random Question:
GET
URL: http://localhost:8080/quiz/question

Submit an Answer:
POST
URL: http://localhost:8080/quiz/submit
Parameters:
userId=1
questionId=1
answer=4


