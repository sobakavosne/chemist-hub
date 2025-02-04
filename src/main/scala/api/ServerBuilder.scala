package api

import cats.effect._
import org.http4s.ember.server._
import org.http4s.server._
import org.http4s.implicits._
import api.endpoints._
import app.units._
import org.apache.spark.sql.SparkSession
import pureconfig.ConfigSource
import pureconfig.generic.auto._

object ServerBuilder {

  case class AppConfig(host: String, port: Int)

  def createServer[F[_]: Async]: Resource[F, Server] = {

    val config = ConfigSource.default.loadOrThrow[AppConfig]

    val spark = SparkSession.builder()
      .appName("ChemistHub")
      .master("local[*]")
      .config("spark.hadoop.fs.defaultFS", "hdfs://name-node:9000")
      .getOrCreate()

    val httpApp = (
      FlowEndpoints.routes[F] <+>
        PreprocessorEndpoints.routes[F]
    ).orNotFound

    EmberServerBuilder.default[F]
      .withHost(config.host)
      .withPort(config.port)
      .withHttpApp(httpApp)
      .build
  }

}
