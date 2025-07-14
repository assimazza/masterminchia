# Masterminchia
***Masterminchia***: a Java 5 implementation of the popular Mastermind board game

***Masterminchia***: una implementazione in Java 5 the popolare gioco da tavola "Mastermind"

# English

This project was a university project developed during my bachelor. The course primary goal was to teach how to develop a GUI for Java using the SWING/AWT frameworks.

The project is in Italian only and it is complete, it runs and works if you have the Java JRE v5 installed. This means that you might also want to run it on a Windows XP machine, native or emulated.

Although the project is complete, the assets are not packed into the JAR file. Just leave them in the main folder as they are.

To run the game, either run the batch file or give the following from a command prompt:

```
java -jar MasterMinchiaNoComment.jar
```

There are slight variations of the jar file which differ only for the content of the About section but they won't change the game.

## How to play

Mastermind is a logic game. You simply need to guess the combitionan set by the computer and hidden behind the cover at the top of the board. You can place different dots of different colours (or blank) in either of the four holes. The computer will check your proposed solution against the combination. If you guessed right one element, it will place a black dot on the left of your solution. If you guessed the right pin colour but the wrong hole, it will place a white dot on the left. You have limtied time and a limited number of attempts to guess correctly.

## Is the game finished?

The game was finished for what it was the original target: develop a working mastermind using a GUI. Originally, the game was meant to be more ambitious. I wanted to add support for the following two modes:

<ul>
  <li> A multiplayer mode: two boards next to each other to be played over LAN</li>
  <li> A simple AI to play against the computer</li>
</ul>

The AI can be very simple, just a state machine, but bear in mind that this is a logic game and the AI can behave to be perfect at guessing!

For this reason, I don't consider it fully finished but it is playable. I appreciate it is also running on Java 5, so probably there isn't much scope for completing the implementation. Nevertheless it is there and it is running, for any nostalgic of Java 5.

## License and others

The game is released under GPL v3, you are free to extend it and fork it however you like!

The game has also some insider jokes dated back to uni, you might not be able to get them unfortunately.

# Italiano

Questo progetto e' un progettino universitario sviluppato per il corso di laure triennale di Ingegneria Informatica. Il corso era pensato per insegnare a sviluppare GUI in Java 5.

Il gioco e' funzionante e localizzato esclusivamente in italiano. Richiede la JRE 5 e, probabilmente, il sistema operativo Windows XP, nativo o emulato. Il gioco e' stato testato in una macchina virtuale e funziona.

Gli asset (le immagini) del gioco non sono state include nell'archivio JAR, basta lasciarle nella cartella principale dove si trova anche il JAR e non toccarle.

Ci sono diversi JAR con piccole varianti del gioco, perlopiu' limitate alla sezione <em>Informazioni su...</em>, la dinamica di gioco non cambia tra le versioni.

Per avviare il gioco, si puo' usare il file bat oppure dare il seguente comando:

```
java -jar MasterMinchiaNoComment.jar
```

## Il gioco e' completo?

Il gioco e' stato completato per quelli che erano i requisiti dell'esame. Tuttavia il progetto, originariamente, era piu' ambizioso e prevedeva le seguenti due modalita':

<ul>
  <li> Modalita' multiplayer: due scacchiere una a fianco all'altra per giocare via LAN</li>
  <li> Modalita' contro il computer</li>
</ul>

L'IA del computer doveva essere molto semplice, un semplice automi a stati finiti. Tuttavia, essendo un gioco di lopgica, dovrebbe essere possibile sviluppare una IA in grado di vincere sempre, quindi attenzione a non rendere il gioco frustrante!

## Licenza e altro

Il codice e' rilasciato con licenza GPL v3, ognuno e' libero di estenderlo o di farne una fork a piacere.

Ci sono diversi scherzi dentro il gioco, tutti relativi a persone interne all;universita' e purtroppo non sara' possibile tracciarne il significato
