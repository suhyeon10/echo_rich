### Swagger UI URL
- http://3.38.11.238:8090/swagger-ui/index.html

### 프로젝트 클론한 뒤, 빌드 오류 발생시
- 인텔리제이 프로젝트 SDK를 자바 17로 맞춰주어야 합니다.
- 파일 탭 > 프로젝트 구조 > 프로젝트 > SDK
- 파일 탭 > 설정 > build 도구 > Gradle > JVM

### Local 배포 방식
- gradle > clean
- gradle > bootjar
- docker-compose up -d 명령어 구동

### AWS 배포 방식
- gradle > clean
- gradle > bootjar
- deploy.sh 실행
- EC2 내부에서 이미지 pull -> docker run
