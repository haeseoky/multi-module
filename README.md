# Spring Boot 멀티 모듈 프로젝트

이 프로젝트는 Kotlin과 Spring Boot 3.0을 사용하여 개발된 멀티 모듈 아키텍처를 갖춘 애플리케이션입니다. 클린 아키텍처 원칙에 따라 설계된 이 프로젝트는 도메인 중심의 모듈 구조를 통해 유지보수성과 확장성을 높였습니다.

## 프로젝트 구조

```
multi-module/
├── api/               # 외부 API 인터페이스 모듈
│   ├── controller/    # REST 컨트롤러
│   ├── error/         # 오류 처리
│   ├── common/        # 공통 유틸리티
│   └── config/        # 설정 클래스
├── application/       # 비즈니스 로직 모듈
│   ├── service/       # 서비스 구현
│   └── dto/           # 데이터 전송 객체
├── domain/            # 핵심 도메인 모듈
│   ├── entity/        # 도메인 엔티티
│   └── repository/    # 리포지토리 인터페이스
└── infrastructure/    # 인프라 모듈
    ├── repository/    # 리포지토리 구현
    └── external/      # 외부 시스템 연동
```

## 기술 스택

- **언어**: Kotlin 1.7.21
- **프레임워크**: Spring Boot 3.0.0
- **빌드 도구**: Gradle (Kotlin DSL)
- **데이터베이스 액세스**: Spring Data JPA
- **API 문서화**: SpringDoc OpenAPI (Swagger)
- **외부 시스템 연동**: Spring Cloud OpenFeign
- **테스트**: JUnit 5, Mockito Kotlin

## 시작하기

### 필수 조건

- JDK 17 이상
- Gradle 7.x 이상

### 빌드 및 실행

```bash
# 프로젝트 클론
git clone https://github.com/haeseoky/multi-module.git
cd multi-module

# 빌드
./gradlew clean build

# 애플리케이션 실행
./gradlew api:bootRun
```

## 모듈 설명

### 1. API 모듈

외부 시스템과의 통신을 담당하는 모듈로, 컨트롤러, 오류 처리, API 문서화 및 설정을 포함합니다.

```kotlin
@SpringBootApplication
@ComponentScan("com.multimodule")
@EnableJpaRepositories("com.multimodule")
@EntityScan(value = ["com.multimodule"])
class ApiApplication
```

주요 기능:
- REST API 엔드포인트 제공
- 입력 유효성 검사
- 오류 처리 및 예외 변환
- API 문서화 (Swagger)

### 2. 애플리케이션 모듈

비즈니스 로직을 구현하는 모듈로, 서비스 레이어와 DTO(Data Transfer Object)를 포함합니다.

주요 기능:
- 트랜잭션 관리
- 비즈니스 로직 구현
- 도메인 모듈과 인프라 모듈 간의 조정
- 데이터 변환 (엔티티 ↔ DTO)

### 3. 도메인 모듈

비즈니스 도메인을 표현하는 핵심 모듈로, 엔티티와 리포지토리 인터페이스를 포함합니다.

주요 기능:
- 도메인 엔티티 정의
- 비즈니스 규칙 및 제약 조건
- 리포지토리 인터페이스 정의

### 4. 인프라 모듈

외부 시스템과의 통합 및 기술적 구현을 담당하는 모듈입니다.

주요 기능:
- 데이터베이스 액세스 구현 (Spring Data JPA)
- 외부 서비스 통합 (Feign Client)
- 캐싱, 이벤트 처리 등의 인프라 관련 기능

## 종속성 구조

모듈 간 종속성은 다음과 같이 설계되었습니다:

```
api → application → domain ← infrastructure
```

- **api**: application, domain, infrastructure에 의존
- **application**: domain에만 의존
- **domain**: 어떤 모듈에도 의존하지 않음
- **infrastructure**: domain에만 의존

이 종속성 구조는 클린 아키텍처의 원칙을 따르며, 핵심 도메인 로직이 외부 기술에 의존하지 않도록 설계되었습니다.

## 개발 가이드

### 새 기능 추가하기

1. **도메인 계층**: 먼저 도메인 엔티티와 필요한 인터페이스를 정의합니다.
2. **인프라 계층**: 도메인에서 정의한 인터페이스를 구현합니다.
3. **애플리케이션 계층**: 비즈니스 로직과 서비스를 구현합니다.
4. **API 계층**: REST 컨트롤러와 DTO를 구현합니다.

### 테스트 전략

- **단위 테스트**: 각 모듈은 독립적으로 테스트 가능합니다.
- **통합 테스트**: 애플리케이션과 인프라 계층의 통합 테스트에 집중합니다.
- **API 테스트**: API 모듈에서 엔드-투-엔드 테스트를 수행합니다.

## 추가 고려사항

- 현재 이 프로젝트는 개발 환경에서 H2 데이터베이스를 사용하며, 프로덕션 환경에서는 MySQL을 사용하도록 구성되어 있습니다.
- Spring Cloud OpenFeign을 사용하여 외부 시스템과 통합할 수 있습니다.
- SpringDoc OpenAPI를 통해 자동 생성된 API 문서는 서버 실행 후 `/swagger-ui.html`에서 확인할 수 있습니다.
