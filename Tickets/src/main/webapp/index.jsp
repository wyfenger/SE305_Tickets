<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<body>
    <form action="/register" method="get">
		<div>
		  <label for="username">username</label>
		  <input type="text" name="username"/>
		</div>
		<div>
          <label for="password">password</label>
          <input type="password" name="password"/>
        </div>
		<div class="submit">
		  <button type="submit">Register</button>    
		</div>
	</form>
    <form action="/login" method="get">
        <div>
          <label for="username">username</label>
          <input type="text" name="username"/>
        </div>
        <div>
          <label for="password">password</label>
          <input type="password" name="password"/>
        </div>
        <div class="submit">
          <button type="submit">Login</button>    
        </div>
    </form>
    

</body>

</html>
