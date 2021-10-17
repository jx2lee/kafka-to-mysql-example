# *kakaobank-task-2021-10*

## *사전준비*
> **첨부된 파일을 순차적으로 읽어서 Kafka 토픽 파티션에 Round-Robin 방식으로 넣어주세요.**

### *kafka setup*
* docker 를 이용해 kafka 환경을 구성하였습니다.
* [docker-compose.yml]()
  * kafka container
    * container_name: local-kafka9092
    * port: 9092
    * topic_name: events-all
    * partition: 10
  * zookeeper container
    * container_name: local-zookeeper
    * port: 2181
* 생성된 토픽 확인
  * replication factor 는 고가용성 구성을 고려하지 않고 설정하였습니다. (default value: 1)
```shell
> ./kafka-topics.sh --describe events-all --zookeeper localhost:2181
Topic:customers	PartitionCount:10	ReplicationFactor:1	Configs:
	Topic: customers	Partition: 0	Leader: 1001	Replicas: 1001	Isr: 1001
	Topic: customers	Partition: 1	Leader: 1001	Replicas: 1001	Isr: 1001
	Topic: customers	Partition: 2	Leader: 1001	Replicas: 1001	Isr: 1001
	Topic: customers	Partition: 3	Leader: 1001	Replicas: 1001	Isr: 1001
	Topic: customers	Partition: 4	Leader: 1001	Replicas: 1001	Isr: 1001
	Topic: customers	Partition: 5	Leader: 1001	Replicas: 1001	Isr: 1001
	Topic: customers	Partition: 6	Leader: 1001	Replicas: 1001	Isr: 1001
	Topic: customers	Partition: 7	Leader: 1001	Replicas: 1001	Isr: 1001
	Topic: customers	Partition: 8	Leader: 1001	Replicas: 1001	Isr: 1001
	Topic: customers	Partition: 9	Leader: 1001	Replicas: 1001	Isr: 1001
```

### *CSV to kafka topic*
* `kafka-console-producer.sh` binary 를 이용해 메세지 전송
* `kafka-console-consumer.sh` 로 메시지 consume 확인
```shell
> ./kafka-console-producer.sh --broker-list localhost:9092 --topic events-all < /Users/nhn/workspace/bigdata/kafka/docker/data.csv
> ./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic events-all --from-beginning
...
...
거래내역,333328,7,2021-01-12 15:04:58,AUT,20798
Processed a total of 5421 messages
```

## *과제1*
> **사전 준비된 Kafka 토픽을 Consume 해서 MySQL 에 실시간으로 저장하는 파이프라인을 개발해 주세요.**

* table 생성
  * customer: `sql/create/customer.sql`
  * acco: `sql/create/acco.sql`
  * tran: `sql/create/tran.sql`
* 계획
  * events-all (모든 이벤트 로그) 메세지를 stream 을 이용해 3개 테이블로 저장할 메세지로 sink 합니다.
    1. key 가 null 인 부분을 고객번호 혹은 계좌번호로 설정하고 value 를 transform (csv to Json) 합니다.
    2. transform 된 value 및 key 를 이용해 연관되어 있는 stream 간 join 을 수행합니다.
    3. join 결과값을 각 table 성격에 맞게 topic 으로 sink 합니다.
  * 이후 mysql connector 를 통해 테이블에 저장합니다.
* 구현내용
  * csv to json 으로 변경하고 message key 를 설정하였습니다.
  * 연관되어 있는 stream 간 Join 은 구현하지 못했습니다.
  * 이로인해 과제2 & 과제3 은 진행하지 못했습니다.
  * 추후에 연관있는 stream 간 Join 으로 테이블에 적재하는 코드를 완성할 예정입니다.

## *과제2*
> **MySQL 에 저장된 데이터로 요일별, 연령대별 거래금액의 합계를 구하려고 합니다.**
> 
> **아래의 테이블 형태로 데이터를 출력할 수 있는 SQL문을 작성해 주세요**


## *과제3*
> **세이프박스 계좌의 경우 연결되어 있는 입출금 계좌가 존재합니다.**
> 
> **세이프박스 계좌와 연결된 입출금 계좌의 거래 중 거래금액이 가장 큰 거래를 출력하세요. 아래의 테이블 형태로 데이터를 출력해 주세요.**

# *Reference*
