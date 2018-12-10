package simulations

import elements.Constants
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import requests.{GetBookingRequest, _}

import scala.concurrent.duration._

class GetRequestsLoadTest extends Simulation {

  val homePageViews: ScenarioBuilder = scenario("Visiting Home Page")
    .exec(HomePageRequest.get)

  val getBookings: ScenarioBuilder = scenario("Get Booking")
    .exec(GetBookingRequest.get)

  setUp(
    homePageViews.inject(
      rampUsersPerSec(1) to 10 during(30 seconds),
      constantUsersPerSec(1) during (60 seconds),
      rampUsersPerSec(1) to 0 during(30 seconds)
    ),
    getBookings.inject(
      rampUsersPerSec(1) to 10 during(30 minutes),
      constantUsersPerSec(1) during (60 seconds),
      rampUsersPerSec(1) to 0 during(30 seconds)
    )

  ).protocols(Constants.httpProtocol)
    .maxDuration(1 minutes)
}
