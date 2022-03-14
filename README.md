# REST PRACTICE
#### REST API 관련 강의에서 들은 내용을 연습합니다.

### URI를 이용한 버전 관리
```
v1: /api/v1/users/{id}
v2: /api/v1/users/{id}
```

## HATEOAS(Hypermedia As the Engine of Application State)
- 어플리케이션의 추가 상태 정보를 보여준다.
- 현재 리소스와 연관된 자원 상태 정보를 제공한다.
- 하나의 리소스에서 가능한 다른 작업들을 확인할 수 있도록 한다. (API 사용자에게 추가적인 정보를 제공한다.)

```
// [GET] /api/v1/users/{userId}
...

EntityModel entityModel = EntityModel.of(userDto);
WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUsers());
entityModel.add(linkTo.withRel("all-users"));

ResponseDto responseDto = ResponseDto.builder()
        .status(HttpStatus.OK.value())
        .message("get user")
        .result(entityModel)
        .build();   
...

// 응답
{
    "status": 200,
    "message": "get user",
    "result": {
        "id": 1,
        "name": "a",
        "birthDate": "1998-05-05",
        "address": "경기도 ~~~",
        "links": [
            {
                "rel": "all-users",
                "href": "http://localhost:8080/api/v1/users"
            }
        ]
    }
}
```

## HAL  
???