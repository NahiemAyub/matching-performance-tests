package requests

import io.gatling.http.Predef._
import io.gatling.core.Predef._
import io.gatling.http.Predef.http

object HomePageRequest {
  val get = exec(http("Home Page request")
    .get("/")
    .check(status.is(200))
  )

}




