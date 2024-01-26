****Student Management Portal - Student Controller****
**Overview**
    *This AuthenticationController* is part of the Student Management Portal, a web application built with the Spring Framework. 
    It handles the authentication-related aspects of the application, 
    including displaying login, signup pages, and handling user registration and login.
    The StudentController is a component of the Student Management Portal, 
    a Spring-based web application. This controller is responsible for managing 
    student-related operations such as creating, listing, editing, and deleting students.

**Features**
    *Landing Page:* The root URL ("") directs users to the landing page of the portal.
    *Signup Page:* Provides a view for new users to sign up.
    *Signin Page:* Provides a view for existing users to sign in.
    *User Registration:* Handles the registration of new users with email and password. It also includes password matching validation.
    *User Login:* Authenticates users based on their email and password. Redirects authenticated users to the students listing page or shows an error for failed login attempts.
    *Create Student View:* Presents a form to create a new student.
    *Register Student:* Handles the registration of new students with provided details.
    *List Students:* Displays a list of all registered students.
    *Edit Student:* Shows a form for editing an existing student's information.
    *Update Student:* Updates the information of a specific student.
    *Confirm Delete Student:* Presents a confirmation view before deleting a student.
    *Delete Student:* Removes a student from the system.
    *View Student:* Displays detailed information about a specific student.
**Endpoints**
    *GET /:* Displays the landing page.
    *GET /signup:* Displays the signup page for new users.
    *GET /signin:* Displays the signin page for existing users.
    *POST /register:* Registers a new user.
    *POST /login:* Logs in a user and redirects to the students list if successful, or returns to the login page with an error message if unsuccessful.
    *GET /student/createStudent:* Displays the student creation form.
    *POST /student/registerStudent:* Registers a new student.
    *GET /student/allStudents:* Lists all students.
    *GET /student/editStudent/{id}:* Shows the edit form for a student.
    *POST /student/updateStudent/{id}:* Updates a student's information.
    *GET /student/confirmDelete/{id}:* Confirms the deletion of a student.
    *POST /student/deleteConfirmed/{id}:* Deletes a student.
    *GET /student/viewStudent/{id}:* Views details of a specific student.
**Dependencies**
    *AuthenticationServices:* A service class that handles the logic for user authentication, 
    including user creation and verification.
    *StudentServiceImplementation:* This service class handles the business logic 
    related to student operations like creating, updating, and deleting students.
**Views**
    *portal/index:* The landing page view.
    *portal/signup:* The view for new user registration.
    *portal/signin:* The view for user login.
    *portal/createStudent:* The view for creating a new student.
    *portal/registerStudent:* The view displayed after registering a student.
    *portal/list:* The view for listing all students.
    *portal/editStudent:* The view for editing a student.
    *portal/confirmDelete:* The view for confirming the deletion of a student.
    *portal/viewStudent:* The view for displaying a student's detailed information.
**Usage**
    To use this controller, ensure that the Spring Framework is set up correctly in your project and the 
    AuthenticationServices class is implemented with the required methods for user authentication.
    To use this controller, ensure that the Spring Framework is configured in your project and that 
    StudentServiceImplementation is implemented with the necessary methods for managing students.