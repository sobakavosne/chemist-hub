import Dependencies._

ThisBuild / scalaVersion     := "3.3.3"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.chemist.hub"
ThisBuild / organizationName := "chemist.hub"

Compile / mainClass   := Some("app.Main")
Compile / scalaSource := baseDirectory.value / "src" / "main" / "scala"

enablePlugins(DockerPlugin, JavaAppPackaging)

Docker / packageName        := "chemist-hub"
Docker / dockerExposedPorts := Seq(8081)

Test / scalaSource       := baseDirectory.value / "src" / "test" / "scala"
Test / parallelExecution := false

lazy val root = (project in file("."))
  .settings(
    name := ".",
    libraryDependencies ++= Seq(
      http4sEmberClient,
      http4sEmberServer,
      catsEffect,
      pureconfig.cross(CrossVersion.for3Use2_13),
      sparkCore.cross(CrossVersion.for3Use2_13),
      sparkSql.cross(CrossVersion.for3Use2_13),
      hadoopClient,
      hadoopHdfs,
      scalaLogging,
      scalaTest
    )
  )

scalacOptions ++= Seq(
  "-Xmax-inlines", "64"
)

resolvers ++= Seq(
  "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases/",
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "Maven Central" at "https://repo1.maven.org/maven2/"
)
