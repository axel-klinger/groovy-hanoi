
class Hanoi {

  static main(args) {

    def stapelListe = [[3,2,1] as Stack, [] as Stack, [] as Stack] as List
    println "Stapel: " + stapelListe

    def alleSteineAufLetztemStapel = stapelListe[0].size() + stapelListe[1].size() > 0

    while (alleSteineAufLetztemStapel) {

      def eingabe = System.console().readLine('Nächster Zug? ') // z.B. 1 2
      def von = (eingabe.split(' ')[0] as int) - 1    // Stapelindex 0-2
      def nach = (eingabe.split(' ')[1] as int) - 1
      // TODO: Fehler der Eingabe abfangen z.B. 4 7
      def istZielstapelLeer = stapelListe[nach].size() == 0
      def obererStein = stapelListe[von].last()
      def untererStein = !stapelListe[nach].empty() ? stapelListe[nach].last() : 0

      if (istZielstapelLeer || obererStein < untererStein) {
          // nimm den obersten Stein vom UrsprungsStapel runter ...
          def stein = stapelListe[von].pop()
          // ... und lege ihn auf den Zielstapel
          stapelListe[nach].push(stein)
        } else {
          println "Fehler! Oberer Stein muss größer als unterer Stein sein!"
        }
        println "Stapel: " + stapelListe
        alleSteineAufLetztemStapel = stapelListe[0].size() + stapelListe[1].size() > 0 // WH!!!
        // -> do while ...
      }
      println 'Fertig!'
    }
  }
