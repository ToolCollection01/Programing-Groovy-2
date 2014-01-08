def sql = groovy.sql.Sql.newInstance('jdbc:mysql://localhost:3306/weatherinfo',
				     userid, password, 'com.mysql.jdbc.Driver')

println sql.connection.catalog



println "City                Temperature"
sql.eachRow('SELECT * from weather') {
  printf "%-20s%s\n", it.city, it[1]
}



processMeta = { metaData ->
  metaData.columnCount.times { i ->
    printf "%-21s", metaData.getColumnLabel(i+1)
  }
  println ""
}

sql.eachRow('SELECT * from weather', processMeta) {
  printf "%-20s %s\n", it.city, it[1]
}


rows = sql.rows('SELECT * from weather')

println "Weather info available for ${rows.size()} cities"




bldr = new groovy.xml.MarkupBuilder()

bldr.weather {
  sql.eachRow('SELECT * from weather') {
    city(name: it.city, temperature: it.temperature)
  }
}



dataSet = sql.dataSet('weather')
citiesBelowFreezing = dataSet.findAll { it.temperature < 32 }
println "Cities below freezing:"
citiesBelowFreezing.each {
  println it.city
}



println "Number of cities : " + sql.rows('SELECT * from weather').size()
dataSet.add(city: 'Denver', temperature: 19)
println "Number of cities : " + sql.rows('SELECT * from weather').size()



temperature = 50
sql.executeInsert("""INSERT INTO weather (city, temperature)
VALUES ('Oklahoma City', ${temperature})""")

println sql.firstRow(
  "SELECT temperature from weather WHERE city='Oklahoma City'")
