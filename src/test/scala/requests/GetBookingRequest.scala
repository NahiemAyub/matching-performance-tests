package requests

import io.gatling.core.Predef._
import io.gatling.http.Predef.{http, status}

object GetBookingRequest {

    val feeder = csv("src/test/scala/feeders/search.csv").random // random id from the csv file

    val get = feed(feeder)
      .exec(http("Get booking request") // execute your request
        .get("/booking/${bookingId}")
        .check(status.in(200, 201))

      )
      .pause(2)

}

