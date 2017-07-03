/* Türme von Hanoi

    |       |       |
    #       |       |
   ###      |       |
  #####     |       |
 #######    |       |
-------------------------
    1       2       3

1. Beschreibung des Spiels (möglichst kompakt)
-----------------------------------------------
Vorgabe
- es gibt n Stapel
- auf dem ersten Stapel liegen m Steine nach Größe sortiert - der größte Stein liegt unten

Ziel
- alle Steine nach Größe sortiert auf den letzten Stapel bringen

Schritte
- es darf in jedem Zug ein Stein auf einen anderen Stapel gelegt werden -> wenn der Zielstapel leer ist, oder der oberste Stein des Zielstapels größer ist als der Stein des Ausgangsstapels

- ein Zug wird beschrieben durch die Anweisung:
 "Lege den obersten Stein von Stapel X auf Stapel Y"
 -> verkürzte Eingabe: X Y
    1 2 = "Lege den obersten Steil von Stapel 1 auf Stapel 2"
    1 3
    2 3
    ...

2. Grober Ablauf im Programm
def listeVonStapeln
while (!alleSteineAufLetztemStapel) {
	def eingabe = naechsterZug()
	...
	if ( breiteObersterSteinUrsprungsstapel < breiteObersterSteinZielstapel
		|| istZielstapelLeer ) {
			// von Stapel X entfernen
			// auf Stapel Y auflegen
	}

3. s.u. ...
 -> hier erst mal mit 3 Stapeln und 5 Steinen ... - Konfiguration folgt ...
*/

def stapelListe = [[5,4,3,2,1] as Stack, [] as Stack, [] as Stack] as List
print(stapelListe)
// wenn auf dem ersten und zweiten Stapel zusammen noch mindestens ein Stein liegt, liegen nicht alle auf dem letzten Stapel (unabhängig von der tatsächlichen Anzahl der Steine) - und so lange ist das Spiel nicht zu Ende!
	// besser: Anzahl der Steine auf allen bis auf den letzten Stapel ...
	// ... oder Anzahl Steine als Wert und nur den Letzten fragen ... -> next Step ...
// while (anzahlSteineLetzterStapel < anzahlSteine) { ...
def alleSteineAufLetztemStapel = stapelListe[0].size() + stapelListe[1].size() > 0
//while (stapel[0].size() + stapel[1].size() > 0) {
while (!alleSteineAufLetztemStapel) {
	def eingabe = System.console().readLine 'Nächster Zug?' // z.B. 1 2
	def origin = (eingabe.split(' ')[0] as int) - 1
	// -1 weil die Liste der 3 Stapel von Element 0 bis Element 1 geht
	def destination = (eingabe.split(' ')[1] as int) - 1
	// size des obersten Elements eines Stapels ist hier die Breite des Steins (es darf nur ein Stein auf einen größeren Stein gelegt werden!), size des Stapels ist die Anzahl der Steine
//	def anzSteineZielstapel = stapel[destination].size()
	def istZielstapelLeer = stapel[destination].size() == 0
	// @? was passiert bei 3Stapel und der Anweisung 3 7 oder 1 5?
	def breiteObersterSteinUrsprungsStapel = stapel[origin]?.peek()?.size()
	def breiteObersterSteinZielstapel = stapel[destination]?.peek()?.size()

//	if (anzSteineZielstapel == 0 ||
	if (istZielstapelLeer ||
		breiteObersterSteinUrsprungsStapel < breiteObersterSteinZielstapel) {
			// nimm den obersten Stein vom UrsprungsStapel runter ...
			def stein = stapel[origin].pop()
			// ... und lege ihn auf den Zielstapel
			stapel[destination].push(stein)
	}
	print(stapel)
	alleSteineAufLetztemStapel = stapel[0].size() + stapel[1].size() > 0 // WH!!!
	// -> do while ...
}
println 'Fertig!'


// Verbesserung: statt ##### besser 5 als int
// Anzahl Züge anzeigen

// Vorgehen
// 1. Definition des Spiels schriftlich (möglichst kompakt)
// 2. leserliche Form in Hauptmethode
// 3. Hilfsmethoden für alle Details - erstmal reichen Variablen, weil weniger Overhead!
