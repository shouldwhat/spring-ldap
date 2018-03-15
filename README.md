# spring-ldap

* 프로젝트 소개

	*. LDAP(Lightweight Directory Access Protocol) 을 다루는 API를 제어하여, MS-ActiveDirectory 플랫폼 상의 Entity를 관리하기 위한 프로젝트.

	*. OOP 사상을 반영한 클래스 구조 설계.

	*. 테스트 가능한 junit 클래스 구현.

	*. 제어 가능한 Entity : 사용자(CN), 조직(OU), 컴퓨터 (COMPUTER), 정책(POLICY)

* 개발 환경

	*. JDK : 1.8.0_144
	
	*. spring-boot : 2.0.0.RELEASE
	
	*. MS-ActiveDirectory : Windows Server 2012 R2
	
	
* 클래스 구조
![](/images/class.png)

* 클래스 설명

	(1) TODO
	
	(2) 
	
* 시퀀스

	*. 조직(OU) 생성	
	![](/images/sequence_create.png)

	*. 사용자(CN) 삭제
	![](/images/sequence_delete.png)

	*. 컴퓨터 (COMPUTER) 조회
	![](/images/sequence_find.png)
