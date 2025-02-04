Chemist Hub acts as a centralised data warehouse, storing and managing the results of distributed computations.

Run the project:

  $> docker compose -f docker-compose.yml up --build

Git Hooks Setup

  To enable custom Git hooks for this repository, configure Git to use the `.githooks` directory:

  $> chmod +x .githooks/pre-push
  $> git config --local core.hooksPath .githooks

Supposed architecture

  .
  ├── build.sbt
  ├── docker-compose.yml
  ├── Dockerfile
  ├── examples
  ├── README.txt
  ├── src
  │   ├── main
  │   │   └── scala
  │   │       ├── api
  │   │       │   ├── endpoints
  │   │       │   │   ├── batch
  │   │       │   │   │   └── BatchProcessingEndpoints.scala
  │   │       │   │   ├── streaming
  │   │       │   │   │   └── StreamingProcessingEndpoints.scala
  │   │       │   │   └── query
  │   │       │   │       └── QueryEndpoints.scala
  │   │       │   ├── ErrorHandler.scala
  │   │       │   └── ServerBuilder.scala
  │   │       ├── app
  │   │       │   ├── Main.scala
  │   │       │   └── units
  │   │       │       ├── BatchJobRunner.scala
  │   │       │       ├── StreamingJobRunner.scala
  │   │       │       ├── QueryJobRunner.scala
  │   │       │       ├── SparkSessionProvider.scala
  │   │       │       └── HadoopClient.scala
  │   │       ├── config
  │   │       │   └── ConfigLoader.scala
  │   │       ├── core
  │   │       │   ├── domain
  │   │       │   │   ├── batch
  │   │       │   │   │   ├── SystemPropsBatch.scala
  │   │       │   │   │   └── BatchProcessingState.scala
  │   │       │   │   ├── streaming
  │   │       │   │   │   ├── SystemPropsStream.scala
  │   │       │   │   │   └── StreamingProcessingState.scala
  │   │       │   │   └── query
  │   │       │   │       ├── QueryResult.scala
  │   │       │   │       └── QueryState.scala
  │   │       │   ├── errors
  │   │       │   │   └── http
  │   │       │   │       ├── batch
  │   │       │   │       │   └── BatchProcessingError.scala
  │   │       │   │       ├── streaming
  │   │       │   │       │   └── StreamingProcessingError.scala
  │   │       │   │       └── query
  │   │       │   │           └── QueryError.scala
  │   │       │   ├── repositories
  │   │       │   │   ├── HDFSRepository.scala
  │   │       │   │   ├── # KafkaRepository.scala
  │   │       │   │   ├── # HiveRepository.scala
  │   │       │   │   ├── # HBaseRepository.scala
  │   │       │   │   └── types
  │   │       │   │       ├── DataRepository.scala
  │   │       │   │       └── QueryRepository.scala
  │   │       │   ├── services
  │   │       │   │   ├── batch
  │   │       │   │   │   ├── BatchProcessingService.scala
  │   │       │   │   │   ├── ParquetWriter.scala
  │   │       │   │   │   └── JSONWriter.scala
  │   │       │   │   ├── streaming
  │   │       │   │   │   ├── StreamingProcessingService.scala
  │   │       │   │   │   ├── # KafkaProducerService.scala
  │   │       │   │   │   └── # KafkaConsumerService.scala
  │   │       │   │   ├── query
  │   │       │   │   │   ├── QueryService.scala
  │   │       │   │   │   ├── # HiveQueryService.scala
  │   │       │   │   │   └── # HBaseQueryService.scala
  │   │       │   │   ├── # cache
  │   │       │   │   │   # ├── DistributedCacheService.scala
  │   │       │   │   │   # ├── LocalCacheService.scala
  │   │       │   │   │   # └── types
  │   │       │   │   │   #     └── CacheService.scala
  │   │       │   └── utils
  │   │       │       ├── # FileUtils.scala
  │   │       │       ├── # KafkaUtils.scala
  │   │       │       ├── # HadoopUtils.scala
  │   │       │       └── # SparkUtils.scala
  │   │       ├── infrastructure
  │   │       │   ├── hdfs
  │   │       │   │   └── HDFSClient.scala
  │   │       │   ├── # kafka
  │   │       │   │   # ├── KafkaConsumer.scala
  │   │       │   │   # ├── KafkaProducer.scala
  │   │       │   │   # └── KafkaConfig.scala
  │   │       │   ├── # hive
  │   │       │   │   # └── HiveClient.scala
  │   │       │   ├── # hbase
  │   │       │   │   # └── HBaseClient.scala
  │   │       │   ├── spark
  │   │       │   │   └── SparkSessionManager.scala
  │   │       │   └── # monitoring
  │   │       │       # ├── MetricsCollector.scala
  │   │       │       # └── LoggingService.scala
  │   │       └── resource
  │   │           ├── application.conf
  │   │           ├── logback.xml
  │   │           └── reference.conf
  │   └── test
  │       └── scala
  │           ├── app
  │           │   └── MainSpec.scala
  │           ├── config
  │           │   └── ConfigLoaderSpec.scala
  │           ├── core
  │           │   ├── repositories
  │           │   │   ├── HDFSRepositorySpec.scala
  │           │   │   ├── # KafkaRepositorySpec.scala
  │           │   │   ├── # HiveRepositorySpec.scala
  │           │   │   ├── # HBaseRepositorySpec.scala
  │           │   │   └── QueryRepositorySpec.scala
  │           │   ├── services
  │           │   │   ├── batch
  │           │   │   │   └── BatchProcessingServiceSpec.scala
  │           │   │   ├── streaming
  │           │   │   │   └── StreamingProcessingServiceSpec.scala
  │           │   │   ├── query
  │           │   │   │   └── QueryServiceSpec.scala
  │           │   │   ├── # cache
  │           │   │   │   # └── DistributedCacheServiceSpec.scala
  │           │   │   └── # utils
  │           │   │       # ├── FileUtilsSpec.scala
  │           │   │       # ├── KafkaUtilsSpec.scala
  │           │   │       # ├── HadoopUtilsSpec.scala
  │           │   │       # └── SparkUtilsSpec.scala
  │           └── resource
  │               └── application.spec.conf

