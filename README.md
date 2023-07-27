# SocialMediaApi

CheckPoints
1. Configure Application as per your settings for databases and email.
2. Complete the Methods comment-lined Headings in controller layer.


Intermediate Project - Social Media Dashboard API

In this project, you will be working on building a Social Media Dashboard API that allows users to manage their friends, perform complex queries, implement pagination and sorting, and integrate an email service. The API will support CRUD operations for users and friends, as well as the ability to retrieve N-level mutual friends.

    Create User and Friend Models:
        User Model: The user data should include fields like UserID, Username, Email, PhoneNumber, and ProfileImage (a URL to the user's profile image).
        Friend Model: The friend data should include fields like FriendID, UserID (referring to the user who added the friend), and FriendUserID (referring to the user who is being added as a friend).

    CRUD API for Users:
    Implement API endpoints to perform CRUD operations for users:
    a. Create User: The candidate needs to implement an API endpoint to add a new user to the database. The endpoint should generate a unique UUID as the UserID field and return this ID if the user is successfully added to the database.
    b. Read User: The candidate needs to implement an API endpoint to retrieve user details based on their UserID.
    c. Update User: The candidate needs to implement an API endpoint to update user details in the database based on their UserID.
    d. Delete User: The candidate needs to implement an API endpoint to delete a user from the database based on their UserID.

    CRUD API for Friends:
    Implement API endpoints to perform CRUD operations for friends:
    a. Add Friend: The candidate needs to implement an API endpoint to add a friend connection between two users in the database. The endpoint should take UserID and FriendUserID as input and establish a friend connection between them.
    b. Remove Friend: The candidate needs to implement an API endpoint to remove a friend connection between two users in the database. The endpoint should take UserID and FriendUserID as input and delete the friend connection between them.
    c. Get Friends of a User: The candidate needs to implement an API endpoint to retrieve a list of all friends of a user based on their UserID.

    Complex Queries:
    Implement API endpoints for complex queries:
    a. Get Mutual Friends: The candidate needs to implement an API endpoint that takes two user IDs as input and returns a list of mutual friends between those two users.
    b. N-level Mutual Friend: The candidate needs to implement an API endpoint that takes a user ID and a level (n) as input and returns a list of N-level mutual friends of that user. For example, if user A is a friend of B, and B is a friend of C, and n=1, then the API should return user B as a mutual friend for user A, and if n=2, it should return user C as a mutual friend for user A.

    Pagination and Sorting:
    Modify the "Get Friends of a User" API to implement pagination and sorting options. Allow the client to specify the page number, page size, and sorting criteria (e.g., sort by username or email). Return the appropriate subset of friends based on the pagination parameters.

    Email Service Integration:
    Implement a functionality that sends an email to a user when they add a new friend. The email should contain a message stating that "<FriendUsername> is now your friend. You can reach them at <FriendEmail> or <FriendPhoneNumber>". The email should be a link that opens the email client. Candidate should create a new email account specifically for this purpose instead of using personal accounts.
