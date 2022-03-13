Feature: Gmail mail compose
Scenario:
Given open "chrome" browser
And launch site using "http://www.gmail.com"
When do login using "sunitha.t1922@gmail.com" and "Batch@258" credentials
Then compose is displayed
When click on compose and fill fields and send mail and check response
|to|subject|body|attachment|
|nobel.cse@gmail.com|hi|good morning|C:\Users\Sunitha\OneDrive\Desktop\pic.png|
|sunitha.t1922@gmail.com|hi|hello|C:\Users\Sunitha\OneDrive\Desktop\pic.png|
|sunitha.t1922@gmail.com|hi|hello|C:\Users\Sunitha\OneDrive\Desktop\pic.png|
When do logout
Then login page should be redisplayed
When close site 