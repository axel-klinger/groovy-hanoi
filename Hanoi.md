Die Türme von Hanoi
====================


Türme von Hanoi

```
    |       |       |
    #       |       |
   ###      |       |
  #####     |       |
 #######    |       |
-------------------------
    1       2       3
```

1. Beschreibung des Spiels (möglichst kompakt)
-----------------------------------------------
Vorgabe
- es gibt n Stapel
- auf dem ersten Stapel liegen m Steine nach Größe sortiert - der größte Stein liegt unten

Ziel
- alle Steine nach Größe sortiert auf den letzten Stapel bringen
```
Axels-MBP-2:hanoi axelklinger$ groovy Hanoi.groovy
Stapel: [[3, 2, 1], [], []]
Nächster Zug? 1 3
Stapel: [[3, 2], [], [1]]
Nächster Zug? 1 3
Fehler! Oberer Stein muss größer als unterer Stein sein!
Stapel: [[3, 2], [], [1]]
Nächster Zug? 1 2
Stapel: [[3], [2], [1]]
Nächster Zug? 3 2
Stapel: [[3], [2, 1], []]
Nächster Zug? 1 3
Stapel: [[], [2, 1], [3]]
Nächster Zug? 2 1
Stapel: [[1], [2], [3]]
Nächster Zug? 2 3
Stapel: [[1], [], [3, 2]]
Nächster Zug? 1 3
Stapel: [[], [], [3, 2, 1]]
Fertig!
```

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
