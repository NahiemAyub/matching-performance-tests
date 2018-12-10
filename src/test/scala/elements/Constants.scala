package elements

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

object Constants {
  private val baseUrl: String = "http://hotel-test.equalexperts.io/"

  val httpProtocol: HttpProtocolBuilder = http
    .connectionHeader("close")
    .disableCaching
    .shareConnections
    .baseURLs(baseUrl)
    .check(status.in(200,201))
}