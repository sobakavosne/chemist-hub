import sbt._

object Dependencies {
  private lazy val scalaTestVersion = "3.2.15"
  private lazy val scalaLogVersion  = "1.4.6"
  private lazy val sparkVersion     = "3.3.0"
  private lazy val hadoopVersion    = "3.3.0"

  lazy val sparkCore    = "org.apache.spark" %% "spark-core"      % sparkVersion
  lazy val sparkSql     = "org.apache.spark" %% "spark-sql"       % sparkVersion
  lazy val hadoopCommon = "org.apache.hadoop" % "hadoop-common"   % hadoopVersion
  lazy val hadoopHdfs   = "org.apache.hadoop" % "hadoop-hdfs"     % hadoopVersion
  lazy val scalaLogging = "ch.qos.logback"    % "logback-classic" % scalaLogVersion
  lazy val scalaTest    = "org.scalatest"    %% "scalatest"       % scalaTestVersion % Test
}
