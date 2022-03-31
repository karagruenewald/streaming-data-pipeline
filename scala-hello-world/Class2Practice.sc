
val stateMap = Map (
  "MT" -> "Bozeman, Montana",
  "ID" -> "McCall, Idaho",
  "CO" -> "Boulder, Colorado"
)

val stateList = List("CO", "ID", "MT")

 stateList.flatMap(place => stateMap.get(place))