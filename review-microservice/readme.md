

# Review Microservice

# Response Object
```
{
    "id": "e1f0b77f-343e-4b6f-bfca-ee6956cabbed",
    "userId": "0d08f810-34ab-42a7-914e-3f2013312530",
    "blogId": "2579cfc1-d711-46df-9bd0-beb2b714fbdb",
    "userName": "Subham Kr Gupta",
    "rating": 5,
    "comment": "Good Blog"
}
```
## Required Fields in Object [Not Null]
- userId
- blogId
- userName
- rating
- comment

---

# URL
---
## GET Methods
### Get Review By ID
    http://localhost:8030/review/getReviewById/{id}
### Find By UserID
    http://localhost:8030/review/findByUserId/{userId}
### Find By BlogId
    http://localhost:8030/review/findByBlogId/{blogId}
### Find By UserName
    http://localhost:8030/review/findByUserName/{userName}
### Find By Rating
    http://localhost:8030/review/findByRating/{rating}
### Find By UserID And BlogId
    http://localhost:8030/review/findByUserIdAndBlogId/{userId}/{blogId}
### Find By UserID And ID
    http://localhost:8030/review/findByUserIdAndId/{userId}/{id}
### Find By BlogID And ID
    http://localhost:8030/review/findByBlogIdAndId/{blogId}/{id}
---
## POST Methods
### Create Review
    http://localhost:8030/review/create
---
## PUT Methods
### Update Method
    http://localhost:8030/review/update/{id}
---
### Delete Method
    http://localhost:8030/deleteById/{id}
---

## Swagger URL
    http://localhost:8030/swagger-ui/index.html#/

