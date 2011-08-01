object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles

  def filesMatching(query: String, method) =
    for (file <- filesHere; if file.getName.method(query))
      yield file

  def filesMatching(query: String, 
    matcher: (String, String) => Boolean) = {
    for (file <- filesHere; if matcher(file.getName,query))
      yield file
  }

  def filesEnding(query: String) =
    filesMatching(query, _.endsWith(_))

  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))
 /*---------------- */

  def filesMatching(matcher: (String, String) => Boolean) = {
    for (file <- filesHere; if matcher(file.getName))
      yield file
  }

  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))
}
