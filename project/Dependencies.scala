import sbt._

object Dependencies {
  private lazy val scalaTestVersion  = "3.2.15"
  private lazy val scalaLogVersion   = "1.4.6"
  private lazy val sparkVersion      = "3.2.0"
  private lazy val hadoopVersion     = "3.4.0"
  private lazy val catsEffectVersion = "3.3.11"
  private lazy val http4sVersion     = "0.23.29"
  private lazy val pureconfigVersion = "0.17.1"

  lazy val pureconfig        = "com.github.pureconfig" %% "pureconfig-core"     % pureconfigVersion
  lazy val http4sEmberClient = "org.http4s"            %% "http4s-ember-client" % http4sVersion
  lazy val http4sEmberServer = "org.http4s"            %% "http4s-ember-server" % http4sVersion
  lazy val catsEffect        = "org.typelevel"         %% "cats-effect"         % catsEffectVersion
  lazy val sparkCore         = "org.apache.spark"      %% "spark-core"          % sparkVersion
  lazy val sparkSql          = "org.apache.spark"      %% "spark-sql"           % sparkVersion
  lazy val hadoopClient      = "org.apache.hadoop"      % "hadoop-client"       % hadoopVersion
  lazy val hadoopHdfs        = "org.apache.hadoop"      % "hadoop-hdfs"         % hadoopVersion
  lazy val scalaLogging      = "ch.qos.logback"         % "logback-classic"     % scalaLogVersion
  lazy val scalaTest         = "org.scalatest"         %% "scalatest"           % scalaTestVersion % Test
}
