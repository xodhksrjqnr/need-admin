# need-admin

## 역할

해당 프로젝트는 Need(지원 정책 조회 웹 서비스)의 Admin-Server를 구현하였으며, 호출한 클라이언트에게 관리&운영 페이지 정보를 전달하는 역할을 수행한다.

## 개발 환경

- Spring Boot 3.1.0
- Java 17
- Spring Data JPA
- Thymeleaf
- Github Actions
- Docker
- AWS EC2

## 구현 기능

- Post 도메인 구현 (필터 조회, 등록, 공개 여부 변경 기능 구현)
- Job 도메인 구현 (저장 및 전체 조회 기능 구현)
- Benefit 도메인 구현 (저장 및 전체 조회 기능 구현)
- API 서버 구현
- AWS EC2를 이용한 클라우드 서비스 운영
- Docker, Github Actions를 이용한 빌드 및 배포 자동화
- Github Actions, Slack을 이용한 빌드 및 배포 완료 알림
- DB 서버의 MySQL 외부 접속
