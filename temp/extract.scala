val lines = io.Source.fromFile("pubs.txt").getLines

val ps = for { 
  line <- lines
  postcode <- """[A-Z]{1,2}[0-9][0-9A-Z]? ?[0-9][A-Z]{2}""".r findAllIn line
} yield postcode

ps foreach println