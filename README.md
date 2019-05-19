### Prerequisites

- Java

### Install

#### clone 

```bash
git clone https://github.com/kimjongmo/SummerCoding.git
```

```bash
cd SummerCoding
```



#### give permission

```bash
chmod +x ./gradlew
```



#### build project

```bash
./gradlew build
```





#### running jar

```bash
java -jar api/build/libs/api.jar
```

```bash
java -jar front/build/libs/front.jar
```

```bash
java -jar batch/build/libs/batch.jar
```



<hr>

### 기능 설명

![???? ???](/project_image.PNG)

- 상단 구문 To Do를 클릭시홈(/index)으로 이동
- 다양한 방식으로 검색 가능
- 지구본은 현재 마감된 개수를 의미
- 마감된 건수가 있는지 1분마다 확인(setInterval)
- 상태는 대기중,완료,마감이 있음
- 대기중인 상태일때는 대기중 상태를 클릭했을 때 완료로 바뀜
- 대기중인 상태에서는 수정이 가능
- 삭제는 모든 상태에서 가능
- 하단의 Add를 클릭 시 추가 가능