# password-validation

- Please execute the jar file on the **main** directory
> Java version: 8 or higher

    java -jar validation-0.0.1-SNAPSHOT.jar

- execute a Post request on `http://localhost:8080/login`
passing the parameter: `{"password": "AcZb@D123"}`


## Rules
- Password must have more than 8 characters
- At least one or more upper char
- At least one or more lower char
- At least one or more special chars
- Repeated chars are not allowed
- White spaces are not allowed

## Examples

`Input: " " //false
Input: "abcdefgh" //false
Input: "AAAbbbCc" //false 
Input: "Abcdefg12" //false
Input: "Abcdefg12" //false
Input: "Ab cdefg12" //false
Input: "AcZb@D123" //true` 