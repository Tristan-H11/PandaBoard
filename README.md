#Panda Board
CHECKS AUF GITHUB EINRICHTEN UND TESTS SCHREIBEN
##Ziel des Übungs-Projektes
Das Projekt soll ein einfaches Kanban-Board abbilden. Es ist möglich, 
mehrere Spalten zu erstellen, in denen Karten (später Issues) mit Titel und einfachem
Inhalt gesammelt werden können. <br>
Die Karten können zwischen den Spalten verschoben werden. Entweder per Drag and Drop 
oder per Kontextmenü. <br>
Später soll den Karten ein zeitlicher Aufwand zugeordet werden können und es 
kann eingetragen werden, wie viele Stunden wöchentlich am Projekt gearbeitet werden können.
Dadurch wird gekennzeichnet, welche Karten bis wann erledigt sein müssen und welche
schon überfällig sind. <br>
Die chronologische Reihenfolge, in der die Tickets abgearbeitet werden, wird durch 
die vertikale Reihenfolge in einer "Gesamt"-Kategorie festgelegt.
Diese Übersicht ist nur verfügbar, wenn sie aktiv aufgerufen wird.
<br>
<br>
Zusätzlich wird ein automatisches Deployment per Github Actions auf einen Webserver
umgesetzt.
##Beginnende Funktionalitäten
Zu Anfang wird es lediglich ein simples Board mit zwei Spalten sein, in denen Karten
hin und her geschoben werden können. Die Inhalte sind beim neuladen identisch angeordnet.
<br>Anschließend werden chronologisch folgende Funktionen
implementiert:

<tr>
<li>Tickets erstellen und löschen (Kontextmenü)</li>
<li>Projekt bearbeiten können. Überischtsseite (Spalten, Name, Wochenstunden, etc)</li>
<li>Spalten erstellen und löschen (Min: 2 Spalten)</li>
<li>Ticket mit Inhalt und Titel bearbeiten können</li>
<li>Zeitaufwand für ein Ticket eingeben</li>
<li>Wöchentlich aufwendbare Zeit für das Projekt eingeben können</li>
<li>Tasks farbig machen</li>
</tr>






