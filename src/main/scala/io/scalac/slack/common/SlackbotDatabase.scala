package io.scalac.slack.common

import slick.jdbc.H2Profile.api._

object SlackbotDatabase {
  lazy val db = Database.forConfig("h2")
}
