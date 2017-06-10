package io.scalac.slack.common

import scala.concurrent.{ ExecutionContext, Future }
import slick.jdbc.H2Profile.api._
import slick.jdbc.meta.MTable

abstract class AbstractRepository {
  val bucket: String
  protected val db = SlackbotDatabase.db

  def migrationNeeded()(implicit s: Session, ec: ExecutionContext): Future[Boolean] = {
    db.run(MTable.getTables) map { list =>
      list.exists(table => {
        table.name.name.contains(bucket)
      }) == false
    }
  }

}
