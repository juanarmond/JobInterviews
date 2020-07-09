### Part 2 My Solution Juan Armond 06/07
Explanation of my the solution Part 2 (6,7)
Simple hash function that give a string calculates and prints the hash
Gets every two bits values of each letter in the string adds its toguether and shifts 4 to the left.

### Partial Solution (Part 1 [1..5]) fount in https://github.com/lvndry/ravelin-code-test 
Tested and everything works.

### Example of resize event request:
```
{
	"websiteURL": "http://ravelin.com",
	"sessionId": "123-123-123-123123123",
	"eventType": "resize",
	"resizeFrom": {
		"width": "786",
		"heigth": "789"
	},
	"resizeTo": {
		"width": "450",
		"heigth": "456"
	}
}
```

### Example of copyAndPaste event request:
```
{
  "eventType": "copyAndPaste",
  "websiteURL": "https://ravelin.com",
  "sessionId": "123123-123123-123123123",
  "pasted": true,
  "formId": "inputCardNumber"
}
```

### Explanation of the solution
The purpose of the exercise is to make a server that receive only POST request. We can for example imagine a website that want to analyse the behavior of the users on their website.

The requests are only sent at some events occurs.

On the backend I used a key/value pair identification so that we can identify a user this way
`Clients[websiteURL][sessionId]`
This way I can identify and complete the structure of a client easily

I handled the different events by creating different routes
Theses routes are in charge of building the struct for the good client depending of the websiteURL and the sessionId

### Tests
I could test the backend thanks to [Postman](https://www.getpostman.com/) avalaible in the `tests` folder.
