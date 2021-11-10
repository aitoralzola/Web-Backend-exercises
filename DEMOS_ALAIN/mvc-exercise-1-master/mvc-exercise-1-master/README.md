# MVC Exercise 1

## Explaination

Check UserController.
We will diferenciate 3 cases:

1. GET call for getting a view (e.g.: view, creation/edition form, list...).
1. GET call for deleting a resource (e.g.: delete user).
1. POST calls for creating and updating a resource (e.g.: sending creation/edition data).

## Redirect Vs. dispatch

If we are trying to get a view, the most probable thing is that we will end up making a dispatch of the view at the end of the controller.

If we are trying to delete, create or update a resource, we will end up making a redirect, otherwise, if the user refreshes the page, they will make the action again.

Example 1 (view with dispatch):

1. We call ```GET /user``` url, asking the user list.
1. Controller dispatches the user list view.
1. Url does not change.
1. We press F5, we go to step 1 again.

Example 2 (create with dispatch [wrong]):

1. We call ```GET /user?action=create``` to get the User Form.
1. Controller dispatches the user form.
1. Fill the form and submit it calling ```POST /user?action=create``` to create the user.
1. URL does not change.
1. We press F5, last request executes again, we go to step 3 again
1. The user is created twice.
1. URL does not change.
1. We press F5, last request executes again, we go to step 3 again
1. The user is created three times
1. ...

Example 3 (create with redirect [correct]):

1. We call ```GET /user?action=create``` to get the User Form.
1. Controller dispatches the user form.
1. Fill the form and submit it calling ```POST /user?action=create``` to create the user.
1. Controller redirects us to ```GET /user?action=view&userId={newUserId}```.
1. Controller dispatches the user view.
1. We press F5, last request executes again, we go to step 4.
1. No user is created again.


## 404 Not found

Imagin that we a user calls ```GET /user?action=view&userId=9``` and that there is no user with id=9. Acording to HTTP standards, we should send a 404 error. How do we do that?

```java
// UserController.java
response.sendError(HttpServletResponse.SC_NOT_FOUND, "User Not Found: " + userId);
```

But warning, even if that function is executed, the function continues executing, so this should not be done:

```java
// Imaginary code, wrong execution
if(user==null){
    response.sendError(HttpServletResponse.SC_NOT_FOUND, "User Not Found: " + userId);
}
RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/example.jsp");
dispatcher.forward(request, response);
```

This would cause an error, because we are returning a 404 and a success at the same time. We could do something like this:

```java
// UserController.java
    if(user == null){
        // Return 404
        response.sendError(HttpServletResponse.SC_NOT_FOUND, "User Not Found: " + userId);
        return;
    ...

    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/user/user_form.jsp");
    dispatcher.forward(request, response);
```

That return will end the execution of the function and the dispatcher will not execute.

### DaoUser

Now DAO user has more functions, so we can make the entire CRUD.

```java
public interface DaoUser {
  public void insertUser(User user);
  public User loadUser(String username,String password);
  public User loadUser(int userId);
  public ArrayList<User> loadUsers();
  public void updateUser(User user);
  public boolean deleteUser(int userId);
}
```

```DaoUserMySQL.java``` will implement those functions and perform those actions against MySQL Database.

### UserFacade

There is a special thing with edit/create in this project. We could have made them independent, but this way seems simpler.

We just have to check userId. If there is a userId already in the user, then we are editing it, otherwise we are creating a new user:

```java
// UserFacade.java
public void saveUser(User user) {
    if (user.getUserId() == 0) {
        daoUser.insertUser(user);
    } else {
        daoUser.updateUser(user);
    }
}
```

### Hidden input

For the same purpose, we reuse the User form. If userId is set, then we will show the edit form, otherwise the create form.

The previous userId is not shown because it is suposed not to change. Therefore, the form has a hidden input:

```jsp
<input type="hidden" name="userId" value="${empty requestScope.user ? '' : requestScope.user.userId}"/>
```

The user will not be able to change it. **WARNING! A normal user will not be able to change it through the interface, but someone with malicious intentions could easily change it. It is not a security measurement but a accessibility idea.**

## Next and Before

* Before [11-dao-user](https://gitlab.com/mgep-web-engineering-1/javaee/11-dao-user)
* Next [12-friendly-URLs](https://gitlab.com/mgep-web-engineering-1/javaee/12-friendly-urls)