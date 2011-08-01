object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles

  def filesEnding(query: String) =
    for (file <- filesHere; if file.getName.endsWith(query))
        yield file
}
