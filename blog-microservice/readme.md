
# Blog Microservice API Details

# Response Object
```
{
    "id": "2579cfc1-d711-46df-9bd0-beb2b714fbdb",
    "author": "Subham",
    "title": "docker",
    "topic": "docker",
    "email": "subham@gmail.com",
    "blogText": "text",
    "imagePath": "https://www.cloudsavvyit.com/p/uploads/2021/04/075c8694.jpeg?width=1198&trim=1,1&bg-color=000&pad=1,1",
    "hashTags": [
      "docker",
      "container"
    ],
    "review": []
  },
```
## Required Fields in Object
- author
- title
- topic
- email
- blogText
- imagePath

---

# URL
## GET Methods
### Get All Blogs
    http://localhost:9000/blog/getAll

### Get Blog By ID
    http://localhost:9000/blog/get/{id}
### Find By Topic
    http://localhost:9000/blog/findTopic/{topic}
### Find By Title
    http://localhost:9000/blog/findTitle/{title}
### Find By Email
    http://localhost:9000/blog/findEmail/{email}
### Find By BlogText
    http://localhost:9000/blog/findBlogText/{blogText}
### Find By Author
    http://localhost:9000/blog/findAuthor/{author}
## POST Methods
### Create Blog
    http://localhost:9000/blog/create
## PUT Methods
### Update Blog With ID
    http://localhost:9000/blog/update/{id}
## Delete Blog
### Delete All Blogs
    http://localhost:9000/blog/deleteAll
### Delete Blog By Id
    http://localhost:9000/blog/delete/{id}


---

# Swagger URL
    http://localhost:9000/swagger-ui/index.html#/



