# Message Sending System

#### Stack
Java 21  
spring boot 3.3.4  
mysql  

#### 서비스 설명
메시지 발송 시스템을 구현한다.    
Rcs 기준으로 Message를 발송해야 한다.  
History 테이블로 Message 발송 이력을 조회할 수 있어야 한다.  
Rcs, Message, History 테이블 관계에 따라 구성한다.  

#### Business 요구사항
아래 API들을 구현한다.
- Master - CR
- RCS - CRU
- Message - CR
- History - CR

#### API 설명
1. Master
	1. (masterId, masterName, createTime) 테이블에 대한 생성, 조회하는 API
2. Rcs
	1. (rcsId, rcsName, maxCount, createTime) 테이블에 대한 CRU API
3. Message
	1. (messageId, title, body) 테이블에 대한 생성, 조회하는 API
	2. 생성할 때, messageId는 UUID / 메시지를 보내려는 RCS의 maxCount를 체크
4. Send
	1. (sendId, rcsId, messageId, count, status) 테이블에 대한 생성, 조회하는 API
	2. '발송'이라는 도메인
5. sendMessage
	1. (id, messageId, sendId) 테이블에 대한 생성, 조회하는 API
	2. Send와 Message 테이블 사이 다대다 관계를 풀어주는 테이블
	3. Send와 Message 테이블의 Key값을 갖는다.

RCS를 기준으로 Message를 발송.

#### 추가 개발
- RCS에 설정된 메시지 발송 횟수 제한으로 동시성 이슈를 고려
- 데이터 일관성을 고려
- ElasticSearch, Kafka 기반으로 검색 엔진을 개발하여 Message 테이블을 빠르게 조회

#### 우대 사항
- Jmeter로 부하 테스트
- Prometheus와 Grafana 기반의 데이터 수집과 모니터링
- 예외 처리 전략
- ORM은 jpa 기반으로 하되, 복잡한 쿼리가 필요한 경우 Mybatis 사용해도 무방. 혹은 QueryDSL
