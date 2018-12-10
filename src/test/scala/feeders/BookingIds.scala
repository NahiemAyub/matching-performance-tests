package feeders

import java.text.SimpleDateFormat
import java.util.{Calendar, Date, TimeZone}

object BookingIds {
  def generateDate(numberOfDaysAfterToday: Integer) = {
    val dateFormat = new SimpleDateFormat("yyyy-MM-dd")
    val dt = new Date
    val c = Calendar.getInstance
    c.setTimeZone(TimeZone.getTimeZone("GMT"))
    c.setTime(dt)
    c.add(Calendar.DATE, numberOfDaysAfterToday)
    dateFormat.format(c.getTime)
  }
}
