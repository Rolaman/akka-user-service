package rolaman.db

import com.zaxxer.hikari._
import slick.jdbc.JdbcBackend.Database

class DbConnection(jdbcUrl: String, dbUser: String, dbPassword: String) {

  private val hikariDataSource = {
    val hikariConfig = new HikariConfig()
    hikariConfig.setJdbcUrl(jdbcUrl)
    hikariConfig.setUsername(dbUser)
    hikariConfig.setPassword(dbPassword)

    new HikariDataSource(hikariConfig)
  }

  val profile = slick.jdbc.PostgresProfile

  val db = Database.forDataSource(hikariDataSource, None)
  db.createSession()

}
